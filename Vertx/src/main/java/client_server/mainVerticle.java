package client_server;

import io.vertx.core.Vertx;

public class mainVerticle {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(new ServerVerticle());
        vertx.deployVerticle(new ClientVerticle());
    }
}

