package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.LinkedBlockingDeque;

public class ConnectionPool {

    //blocking queue as many threads will access
    private static LinkedBlockingDeque<Connection> connectionPool;

    public static void createConnectionPool(int size){

        connectionPool = new LinkedBlockingDeque<>(size);

        Connection con;

        for(int iterator=0; iterator<size; iterator++){

            try{

                Class.forName("org.h2.Driver");

                con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test" , "sa", "");

                connectionPool.put(con);

            }
            catch (SQLException | ClassNotFoundException|InterruptedException e){

                e.printStackTrace();

                System.exit(1);

            }

        }

    }

    public static Connection getConnection(){

        try{

            System.out.println("connected to database.");

            //removing and retrieving the head of dequeue

            return connectionPool.take();

        }
        catch (InterruptedException e){

            throw new RuntimeException(e);

        }
    }

    public static void putConnection(Connection putconnection){

        try{

            connectionPool.put(putconnection);

        }

        catch(InterruptedException e){

            throw new RuntimeException(e);
        }
    }

}
