package client_server;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.net.NetServer;

public class ServerVerticle extends AbstractVerticle {
        // Create an instance of HttpServer
        @Override
        public void start() {
            // Create a TCP server
            NetServer server = vertx.createNetServer();

            // Handle incoming connections
            server.connectHandler(socket -> {
                // Handle incoming data
                socket.handler(buffer -> {
                    System.out.println("Received data: " + buffer.toString());
                    // Echo back the data to the client
                    socket.write(buffer);
                });
            });

            // Start the server
            server.listen(8080, result -> {
                if (result.succeeded()) {
                    System.out.println("Server started");
                } else {
                    System.err.println("Server failed to start: " + result.cause().getMessage());
                }
            });
        }
    }