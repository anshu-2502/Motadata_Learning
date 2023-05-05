package client_server;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Handler;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpClientRequest;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.RequestOptions;
import io.vertx.core.net.NetClient;

import java.nio.Buffer;

public class ClientVerticle extends AbstractVerticle {
    @Override
    public void start() {
        // Create a TCP client
        NetClient client = vertx.createNetClient();

        // Connect to the server
        client.connect(8080, "localhost", result -> {
            if (result.succeeded()) {
                System.out.println("Connected to server");
                // Send a message
                result.result().write("Hello, server!");
                // Handle the response
                result.result().handler(buffer -> {
                    System.out.println("Received response: " + buffer.toString());
                });
            } else {
                System.err.println("Failed to connect to server: " + result.cause().getMessage());
            }
        });
    }
}