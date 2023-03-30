package GroupChatApp;


import java.io.Console;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class WriteThread extends Thread {
    private PrintWriter writer;
    private Socket socket;
    private chatClient client;

    public WriteThread(Socket socket,  chatClient client) {

        this.socket = socket;

        this.client = client;

        try {
            OutputStream output = socket.getOutputStream();

            writer = new PrintWriter(output, true);

        } catch (IOException ex) {

            System.out.println("Error getting output stream: " + ex.getMessage());

            ex.printStackTrace();
        }
    }

    public void run() {

        Console console = System.console();

        String userName = console.readLine("Enter your name: ");

        System.out.println();

        client.setUserName(userName);

        writer.println(userName);

        String text;

        do {
            text = console.readLine("[" + userName + "]: ");

            writer.println(text);

        }
        while (!text.equals("bye"));

        try {
            socket.close();

        }
        catch (IOException ex) {

            System.out.println("Error writing to server: " + ex.getMessage());
        }
    }
}
