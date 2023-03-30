package DatagramChatApp;

import java.net.*;
import java.util.Scanner;

public class server {

    public static void main(String[]args) throws SocketException, UnknownHostException {

        DatagramSocket serverSocket = new DatagramSocket(1234);

        InetAddress ip = InetAddress.getLocalHost();

        System.out.println("server running");

        //send message:

        Thread serverSend = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Scanner inputmsg = new Scanner(System.in);

                    while (true) {



                            byte[] msginBytes = new byte[1000];

                            msginBytes = inputmsg.nextLine().getBytes();

                            DatagramPacket serverPacket = new DatagramPacket(msginBytes, msginBytes.length, ip, 2431);

                            //sending the packet

                            serverSocket.send(serverPacket);

                            String message = new String(msginBytes);

                            System.out.println("server says: " + message);

                            if ((message).equals("bye")) {

                                System.out.println("Server" + " exiting... ");

                                break;
                            }
                            System.out.println("Waiting for" + " client response... ");
                        }



                }

                catch (Exception e){

                }
            }
        });

        Thread serverReceive = new Thread(new Runnable() {
            @Override
            public void run() {

                try {

                        while (true) {

                            byte[] receiveDatagram = new byte[1000];

                            DatagramPacket serverPacket = new DatagramPacket(receiveDatagram, receiveDatagram.length);

                            serverSocket.receive(serverPacket);

                            //byte data to string:

                            String message = new String(receiveDatagram).trim();

                            System.out.println("client: " + message);

                            if (message.equals("bye")) {

                                System.out.println("client connection closed");

                                break;
                            }

                        }



                }
                catch(Exception e){

                        System.out.println("exception occured");

                    }


            }
        });


        serverSend.start();

        serverReceive.start();

        try {

            serverSend.join();

            serverReceive.join();
        }
        catch (InterruptedException e) {

            throw new RuntimeException(e);

        }





    }
}
