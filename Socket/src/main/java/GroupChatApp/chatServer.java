package GroupChatApp;//package GroupChatApp;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.HashSet;
import java.util.Set;
import java.net.*;


//starts the server , listens on specific port. connects with new clients
//server is able to handle multiple threads at a time
public class chatServer {

    private int port;

    private Set<String> userNames = new HashSet<>();

    private Set<UserThread> userThreads = new HashSet<>();

    public chatServer(int port) {

        this.port = port;

    }

    public void executeServer() throws IOException {

        try (ServerSocket serverSocket = new ServerSocket(port)) {

            System.out.println("char server is on!!" + port);

            while (true) {

                Socket socket = serverSocket.accept();

                System.out.println("new user connected");

                UserThread newUser = new UserThread(socket, this);

                userThreads.add(newUser);

                newUser.start();
            }
        } catch (Exception ex) {

            System.out.println("error in server: " + ex.getMessage());

            ex.printStackTrace();


        }

    }

    //delivers a message form one user to others:
    void broadcast(String message, UserThread excludeUser) {

        for (UserThread aUser : userThreads) {
            if (aUser != excludeUser) {
                aUser.sendMessage(message);
            }
        }
    }

    void addUserName(String userName) {

        userNames.add(userName);

    }

    void removeUser(String userName, UserThread aUser) {

        boolean removed = userNames.remove(userName);

        if (removed) {

            userThreads.remove(aUser);

            System.out.println("The user" + userName + "left");

        }

    }

    Set<String> getUserNames() {

        return this.userNames;

    }

    boolean hasUsers() {

        return !this.userNames.isEmpty();

    }

    public static void main(String[] args) throws IOException {

        if (args.length < 1) {
            System.out.println("Syntax: java ChatServer <port-number>");
            System.exit(0);
        }

        int port = Integer.parseInt(args[0]);

        chatServer server = new chatServer(port);
        server.executeServer();


    }
}

