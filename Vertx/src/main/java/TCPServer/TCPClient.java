package TCPServer;

import io.vertx.core.Vertx;
import io.vertx.core.net.NetClient;
import io.vertx.core.net.NetSocket;

public class TCPClient {
    public static void main(String[] args) {

        Vertx vertx = Vertx.vertx();

        NetClient client = vertx.createNetClient();

        client.connect(1111, "localhost", ar -> {

            if (ar.succeeded()) {

                System.out.println("Connected to server");

                NetSocket socket = ar.result();

                socket.handler(buffer -> {

                    System.out.println("Received data: " + buffer.toString());

                });

                socket.write("Hello");

                socket.closeHandler(v -> {

                    System.out.println("Connection closed by server");
                });

                socket.exceptionHandler(e -> {

                    System.err.println("Connection error: " + e.getMessage());
                });
            } else {

                System.err.println("Failed to connect: " + ar.cause().getMessage());
            }
        });
    }
}

