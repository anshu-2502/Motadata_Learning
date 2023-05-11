package HTTP.websocket;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpClient;

public class Client extends AbstractVerticle {

    public void start() throws Exception {

        HttpClient client = vertx.createHttpClient();

        // "/some-uri" is placeholder for path of the WebSocket endpoint you want to connect to in your application.

        client.webSocket(8080, "localhost", "/some-uri").onSuccess(webSocket -> {

            webSocket.handler(data -> {

                System.out.println("Received data " + data.toString("ISO-8859-1"));

                client.close();

            });

            webSocket.writeBinaryMessage(Buffer.buffer("Hello world"));

        }).onFailure(Throwable::printStackTrace);
    }

    public static void main(String[] args) {
        try {


            Vertx vertx = Vertx.vertx();

            vertx.deployVerticle(new Client());

        }
        catch (Exception e){

            System.out.println(e);
        }


    }
}


