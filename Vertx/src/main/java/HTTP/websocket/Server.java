package HTTP.websocket;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;

public class Server extends AbstractVerticle {

    @Override
    public void start() throws Exception {
        vertx.createHttpServer().webSocketHandler(ws -> ws.handler(ws::writeBinaryMessage)).requestHandler(req -> {
            if (req.uri().equals("/")) {

                req.response().sendFile("/home/anshu/anshu_training/Motadata_Learning/Vertx/src/main/java/HTTP/websocket/websocket.html");

                System.out.println("file sent");
            }
        }).listen(8080);

        System.out.println("listening on port 8080");
    }

    public static void main(String[] args) {
        try {

            Vertx vertx = Vertx.vertx();

            vertx.deployVerticle(new Server());

        }
        catch (Exception e){

            System.out.println(e);
        }

    }
}
