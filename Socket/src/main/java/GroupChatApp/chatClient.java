package GroupChatApp;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public  class chatClient {

    private String hostname;

    private int port;

    private String userName;

    public chatClient(String hostname , int port){

        this.hostname=hostname;

        this.port =port;

    }

    public void execute(){

        try{

            Socket socket = new Socket(hostname, port);

            System.out.println("connected to chat server");

            ReadThread readThread=  new ReadThread(socket, this);

            readThread.start();

            WriteThread writeThread = new WriteThread(socket,this);

            writeThread.start();


        }
        catch (UnknownHostException ex) {

            System.out.println("Server not found: " + ex.getMessage());
        }
        catch (IOException ex) {

            System.out.println("I/O Error: " + ex.getMessage());
        }
    }

    public void setUserName(String userName) {

        this.userName = userName;
    }

    public String getUserName() {

        return this.userName;
    }


    public static void main(String[]args){


        if (args.length < 2) {
            return;
        }

        String hostname = args[0];
        int port = Integer.parseInt(args[1]);

        chatClient client = new chatClient(hostname, port);
        client.execute();


    }
}

