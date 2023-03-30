package EchoApplication;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[]args) {

        System.out.println("waiting for clients");

        try {

            ServerSocket serverSocket = new ServerSocket(9806);

            Socket socketConnection = serverSocket.accept();

            System.out.println("connection established");

        }
        catch(Exception e){
            System.out.println(e);
        }

    }
}
