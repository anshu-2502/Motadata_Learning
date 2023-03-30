package DatagramChatApp;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class client {

    public static void main(String[]args) throws SocketException, UnknownHostException{

        DatagramSocket clientsocket = new DatagramSocket(2431);

        InetAddress ip = InetAddress.getLocalHost();

        System.out.println("client is running");

        Thread clientSend = new Thread(new Runnable() {
            @Override
            public void run() {

                try {

                    Scanner inputmsg = new Scanner(System.in);

                    while (true) {



                            byte[] sendDatagram = new byte[1000];

                            sendDatagram = inputmsg.nextLine().getBytes();

                            //datagram message for new packet:

                            DatagramPacket sendPackage = new DatagramPacket(sendDatagram, sendDatagram.length, ip, 1234);

                            clientsocket.send(sendPackage);

                            String message = new String(sendDatagram);

                            System.out.println("client says:" + message);

                            if ((message).equals("bye")) {

                                System.out.println("Client" + " exiting... ");

                                break;
                            }
                            System.out.println("Waiting for" + " server response... ");
                        }






                }
                catch(Exception e){
                    System.out.println("Exception occured! ");
                }
            }
        });

        Thread clientReceive = new Thread(new Runnable() {
            @Override
            public void run() {

                try {


                        while (true) {

                            byte[] receiveDatagram = new byte[1000];

                            //receiving new message:

                            DatagramPacket receivePacket = new DatagramPacket(receiveDatagram, receiveDatagram.length);

                            clientsocket.receive(receivePacket);

                            //byte to string:

                            String message = new String(receiveDatagram).trim();

                            System.out.println("Server: " + message);

                            if (message.equals("bye")) {

                                System.out.println("server stopped");

                                break;
                            }

                        }

                }
                catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }

        });

        clientSend.start();
        clientReceive.start();

        try {
            clientSend.join();

            clientReceive.join();

        } catch (InterruptedException e) {

            throw new RuntimeException(e);

        }






    }
}
