package MultithreadChatApp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class MyServer{
    ServerSocket serverSocket;

    Socket socketConnectionClient; //to receive a child connection

    BufferedReader serverMsg = new BufferedReader(new InputStreamReader(System.in));

    BufferedReader clientMsg;

    //send output to outputstream
    PrintWriter output;

    String sendMsg,reply;

    MyServer(){

        try {

            serverSocket = new ServerSocket(9999);

            System.out.println("listening on port 9999");

            socketConnectionClient = serverSocket.accept();//client to accept the connection

            if(socketConnectionClient!=null){

                System.out.println("connected with client");

                //coming from client side
                clientMsg = new BufferedReader(new InputStreamReader(socketConnectionClient.getInputStream()));

                output = new PrintWriter(socketConnectionClient.getOutputStream(),true);

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

                    System.out.println("Client: "+ reply );


                    if(reply==null){
                        System.exit(0);
                    }

                    if(reply.equalsIgnoreCase("bye")){

                        check=false;

                        serverSocket.close();

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
public class talkserver {

    public static void main(String[]args){

          new MyServer();


    }
}
