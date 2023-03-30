package GroupChatApp;

import GroupChatApp.chatServer;

import java.io.*;
import java.net.Socket;


//responsible for reading messages sent from client and broadcasting messages to all other clients
//it sends list of online user to new user and it reads usernae & notifies
//other users


//this thread handles connction for each connected client, so server can handle multiple clients

public class UserThread extends Thread{

    private Socket socket;
    private chatServer server;
    private PrintWriter writer;
    public UserThread(Socket socket, chatServer chatServer) {

        this.socket =socket;

        this.server = chatServer;

    }

    public void run(){
        try{

            InputStream input = socket.getInputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            OutputStream output = socket.getOutputStream();


            writer = new PrintWriter(output,true);

            printUsers();
            System.out.println("enter your name: ");
            String userName = reader.readLine();

            server.addUserName(userName);

            String serverMessage = "new user connected: "+ userName;

            server.broadcast(serverMessage, this);

            String clientMessage;

            do{
                clientMessage = reader.readLine();

                serverMessage = "[" + userName + "]: " +clientMessage;

                server.broadcast(serverMessage, this);

            }
            while(!clientMessage.equals("bye"));

            server.removeUser(userName ,this);

            socket.close();

            serverMessage = userName +" has left.";

            server.broadcast(serverMessage, this);

        }

        catch (IOException ex) {

            System.out.println("Error in UserThread: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

     void printUsers() {
        if(server.hasUsers()){

            writer.println("Connected users: "+ server.getUserNames());

        }

        else{

            writer.println("no users connected.");
        }
    }

    public void sendMessage(String message) {

        writer.println(message);
    }
}
