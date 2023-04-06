package MultipleClientsSingleServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    int port;

    ServerSocket server=null;

    Socket client=null;

    ExecutorService pool = null;

    int clientcount=0;

    public static void main(String[] args) throws IOException {

        Server serverobj=new Server(5000);

        serverobj.startServer();
    }

    Server(int port){

        this.port=port;

        pool = Executors.newFixedThreadPool(5);
    }

    public void startServer() throws IOException {

        server=new ServerSocket(5000);

        System.out.println("Server started");

        System.out.println("Any client can stop the server by sending -1");

        while(true)
        {
            client=server.accept();

            clientcount++;

            ServerThread runnable= new ServerThread(client,clientcount,this);

            pool.execute(runnable);
        }

    }

    private static class ServerThread implements Runnable {

        Server server=null;
        Socket client=null;
        BufferedReader ClientInput;
        PrintStream ClientOutput;
        Scanner sc=new Scanner(System.in);
        int id;
        String message;

        ServerThread(Socket client, int count ,Server server ) throws IOException {

            this.client=client;

            this.server=server;

            this.id=count;

            System.out.println("Connection "+id+"established with client "+client);

            ClientInput=new BufferedReader(new InputStreamReader(client.getInputStream()));

            ClientOutput=new PrintStream(client.getOutputStream());

        }

        @Override
        public void run() {

            int flag=1;

            try{
                while(true){

                    message=ClientInput.readLine();

                    System. out.print("Client("+id+") :"+message+"\n");

                    System.out.print("Server : ");

                    //s=stdin.readLine();
                    message=sc.nextLine();

                    if (message.equalsIgnoreCase("bye"))
                    {
                        ClientOutput.println("BYE");

                        flag=0;

                        System.out.println("Connection ended by server");

                        break;
                    }

                    ClientOutput.println(message);
                }


                ClientInput.close();

                client.close();

                ClientOutput.close();

                if(flag==0) {

                    System.out.println( "Server cleaning up." );

                    System.exit(0);
                }
            }
            catch(IOException ex){

                System.out.println("Error : "+ex);
            }


        }
    }

}