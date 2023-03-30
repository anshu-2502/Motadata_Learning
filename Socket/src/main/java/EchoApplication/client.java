package EchoApplication;

import java.net.Socket;

public class client {

    public static void main(String[] args) {

        try {

            System.out.println("client started");

            Socket socketConnection = new Socket("localhost", 9806);
        }
        catch(Exception e){

            System.out.println(e);

        }


    }
}