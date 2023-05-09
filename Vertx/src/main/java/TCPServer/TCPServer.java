package TCPServer;

import io.vertx.core.Vertx;
import io.vertx.core.net.NetServer;

public class TCPServer {
    public static void main(String[] args) {

        Vertx vertx = Vertx.vertx();

        NetServer server = vertx.createNetServer();

        server.connectHandler(socket -> {

            System.out.println("Client connected: " + socket.remoteAddress());

            socket.handler(buffer -> {

                System.out.println("Received data: " + buffer.toString());

                socket.write("Echo: " + buffer.toString());
            });

            socket.closeHandler(v -> {

                System.out.println("Client disconnected");
            });

            socket.exceptionHandler(e -> {
                System.err.println("Client error: " + e.getMessage());
            });
        });

        server.listen(1111, ar -> {

            if (ar.succeeded()) {

                System.out.println("Server started");
            } else {

                System.err.println("Server failed to start: " + ar.cause().getMessage());
            }
        });
    }
}
