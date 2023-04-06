package MultipleClientsSingleServer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Client {

    public static void main(String args[]) throws Exception
    {
        Socket socket=new Socket("127.0.0.1",5000);

        BufferedReader serverInput=new BufferedReader(new InputStreamReader(socket.getInputStream()));

        PrintStream serverOutput=new PrintStream(socket.getOutputStream());

        BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));

        String message;

        while (  true )
        {
            System.out.print("Client : ");

            message=stdin.readLine();

            serverOutput.println(message);

            if ( message.equalsIgnoreCase("BYE") )
            {
                System.out.println("Connection ended by client");

                break;
            }

            message=serverInput.readLine();

            System.out.print("Server : "+message+"\n");


        }
        socket.close();

        serverInput.close();

        serverOutput.close();

        stdin.close();
    }

}
