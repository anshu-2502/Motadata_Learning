package MultithreadChatApp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

class MyClient{

    Socket socket; //to receive a child connection

    BufferedReader serverMsg = new BufferedReader(new InputStreamReader(System.in));

    BufferedReader clientMsg;

    //send output to outputstream
    PrintWriter output;

    String sendMsg,reply;

    MyClient(){

        try {

           socket = new Socket("localhost",9999);

            System.out.println("connecting on port 9999");


            if(socket!=null){

                System.out.println("connected with server");

                //coming from client side
                clientMsg = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                output = new PrintWriter(socket.getOutputStream(),true);

                readMessage();

                writeMessage();

            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    void readMessage(){

        Thread readThread = new Thread(()->{

            boolean check =true;

            while(check){
                System.out.print("<< ");

                try {
                    sendMsg = serverMsg.readLine();

                    //sending message to client
                    output.println(sendMsg);

                    if(reply.equalsIgnoreCase("bye")) {

                        socket.close();

                        System.exit(0);
                    }

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        );

        readThread.start();

    }

    void writeMessage() throws IOException {

        Thread writeThread = new Thread(()->{
            boolean check =true;

            while(check){


                try {
                    reply = clientMsg.readLine();

                    System.out.println("Server: "+ reply );

                    if(reply==null){
                        System.exit(0);
                    }



                    if(reply.equalsIgnoreCase("bye")){

                        check=false;

                        socket.close();

                        System.exit(0);

                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


            }

        });

        writeThread.start();


    }
}
public class talkclient {

    public static void main(String[]args){

        new MyClient();


    }
}
