package simpleSockjs;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.sockjs.SockJSHandler;
import io.vertx.ext.web.handler.sockjs.SockJSHandlerOptions;
public class EchoServer extends AbstractVerticle {
  @Override
  public void start(Promise<Void> startPromise) throws Exception {

    HttpServer server = vertx.createHttpServer();

    Router router = Router.router(vertx);

    SockJSHandler jsHandler = SockJSHandler.create(vertx, new SockJSHandlerOptions());

    router.route("/myapp/*").subRouter(jsHandler.socketHandler(socket -> {

      System.out.println(socket.getClass());

      System.out.println(socket.routingContext().getClass());

      System.out.println(socket.routingContext().request().getClass());

      System.out.println(socket.routingContext().response().getClass());

      socket.handler(socket::write);

    }));
    server.requestHandler(router).listen(9090).onComplete(ready -> {


      if (ready.succeeded()) {

        System.out.println("Server Started Listening!");

        startPromise.complete();

      } else {

        System.out.println("Failed to start Stores!");

        startPromise.fail(ready.cause().getMessage());
      }
    });
  }

  public static void main(String[] args) {

    Vertx vertx = Vertx.vertx();

    vertx.deployVerticle(new EchoServer());
  }
}
