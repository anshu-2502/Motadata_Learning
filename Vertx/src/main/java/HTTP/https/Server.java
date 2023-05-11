package HTTP.https;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.core.net.JksOptions;

public class Server extends AbstractVerticle {
    public void start() throws Exception {

        HttpServer server = vertx.createHttpServer(new HttpServerOptions().setSsl(true).setKeyStoreOptions(

                        new JksOptions().setPath("/home/anshu/anshu_training/Motadata_Learning/Vertx/src/main/resources/server-keystore.jks").setPassword("wibble")
                ));

        server.requestHandler(req -> {

            req.response().putHeader("content-type", "text/html").end("<html><body><h1>Hello from vert.x!</h1></body></html>");

        }).listen(4443);
    }

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(new HTTP.https.Server());
    }
}

