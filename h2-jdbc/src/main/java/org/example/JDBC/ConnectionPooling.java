package org.example.JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

public class ConnectionPooling implements Runnable {

    private String driver,url,username,password;

    private int maxConnections;

    private boolean waitIfBusy;

    public static Vector<Connection> availableConnections;
    public Vector<Connection> busyConnections;

    private boolean connectionPending=false;

    public ConnectionPooling(){

    }


    public ConnectionPooling(String driver, String url, String username, String password, int initialConnections, int maxConnections, boolean waitIfBusy) throws  SQLException{

        this.driver = driver;

        this.url = url;

        this.username = username;

        this.password = password;

        this.maxConnections = maxConnections;

        this.waitIfBusy = waitIfBusy;

        if (initialConnections > maxConnections) {

            initialConnections = maxConnections;

        }
        availableConnections = new Vector<Connection>(initialConnections);

        busyConnections = new Vector<Connection>();

        for(int connection=0; connection<initialConnections; connection++){

            availableConnections.addElement(makeNewConnection());

        }

    }
    private Connection makeNewConnection() throws SQLException {
        try {


            // Load database driver if not already loaded
            Class.forName(driver);

            // Establish network connection to database

            Connection connection = DriverManager.getConnection(url, username,password);

            // Connection connection = ds.getConnection();

            return (connection);

        }
        catch (Exception cnfe) {

            cnfe.printStackTrace();

            throw new SQLException("ConnectionPool:: SQLException encountered:: "+ cnfe.getMessage());


        }
    }

    public synchronized  Connection getConnection() throws SQLException{

        if(!availableConnections.isEmpty()){

            Connection existingConnection = (Connection) availableConnections.lastElement();

            int lastIndex = availableConnections.size()-1;

            availableConnections.removeElementAt(lastIndex);

            //if connection on available list is closed(timed out) then remove it from available lists and repeat
            //the process of obtaining connection
            //ALSO wakeup the threads that were waiting for connection

            if(existingConnection.isClosed()){

                notifyAll(); //free up spot for anyone waiting

                return (getConnection());

            }

            else{

                busyConnections.addElement(existingConnection);

                return (existingConnection);

            }

        }

        else{

            //1. haven't reached max connections limit. so establish one in bg if there isn't one pending then
            //wait for next available connection

            //2. rached max connection limit and waitIfBusy flag is false

            //3. reached maxConnections limit and waitIFBusy flag is true



          if (!waitIfBusy) {

                System.out.println("connection limit reached!");

            }
            //wait for either new connection or exisiting connection to free up

            try {

                wait();

            }
            catch (InterruptedException ie) {

            }
            // Someone freed up a connection, so try again.
            return (getConnection());
        }


        }

    public synchronized int totalConnections() {
        return (availableConnections.size() + busyConnections.size());
    }

    //if we make a new connection in foreground when none are available since this




    @Override
    public void run() {

        try{
            Connection connection = makeNewConnection();

            synchronized (this){

                availableConnections.addElement(connection);

                connectionPending = false;

                notifyAll();

            }
        }

        catch (Exception e){


        }
    }

    public synchronized  void free(Connection connection){

        busyConnections.removeElement(connection);

        availableConnections.addElement(connection);

        notifyAll();


    }


    public synchronized void CloseAllConnections(){

        closeConnections(availableConnections);

        availableConnections = new Vector<Connection>();

        closeConnections(busyConnections);

        busyConnections = new Vector<Connection>();


    }

    private void closeConnections(Vector<Connection> connections){

        try{

            for(int iterator=0; iterator<connections.size();iterator++){

                Connection connection = (Connection) connections.elementAt(iterator);

                if(!connection.isClosed()){
                    connection.close();
                }

            }


        }
        catch (SQLException sqle ){


            sqle.printStackTrace();
        }
    }

    public synchronized String toString(){

        String info = "ConnectionPool(" + url + "," + username + ")" + ", available=" + availableConnections.size() + ", busy=" + busyConnections.size() + ", max=" + maxConnections;

        return (info);

    }

}
