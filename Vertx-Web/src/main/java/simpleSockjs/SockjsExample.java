package simpleSockjs;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.net.SocketAddress;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.sockjs.SockJSHandler;
import io.vertx.ext.web.handler.sockjs.SockJSHandlerOptions;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;


public class SockjsExample extends AbstractVerticle {

  public static void main(String[] args) {

    Vertx vertx = Vertx.vertx();
    vertx.deployVerticle(new SockjsExample());


  }

  public void start() throws UnknownHostException {

    Router router = Router.router(vertx);

    SockJSHandlerOptions options = new SockJSHandlerOptions().setHeartbeatInterval(2000);

    SockJSHandler sockJSHandler = SockJSHandler.create(vertx, options);



    router.route("/myapp/*").subRouter(sockJSHandler.socketHandler(sockJSSocket -> {

        System.out.println("hie");

      sockJSSocket.write("start");


        sockJSSocket.handler(handler -> {
          sockJSSocket.write(handler + "<-");
        });

        sockJSSocket.end();


      }


    ));

    vertx.createHttpServer()
      .requestHandler(router)
      .listen(SocketAddress.inetSocketAddress(new InetSocketAddress(InetAddress.getByName("localhost"), 8080)))
      .onComplete(result -> {

        if (result.succeeded()) {

          System.out.println("Server listening at port 8080");

        } else {

          result.cause().printStackTrace();
        }
      });


  }


}
