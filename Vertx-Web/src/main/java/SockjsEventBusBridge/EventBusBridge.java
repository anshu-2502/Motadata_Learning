package SockjsEventBusBridge;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.http.HttpServer;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.bridge.BridgeEventType;
import io.vertx.ext.bridge.PermittedOptions;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.sockjs.SockJSBridgeOptions;
import io.vertx.ext.web.handler.sockjs.SockJSHandler;
import simpleSockjs.EchoServer;

public class EventBusBridge extends AbstractVerticle {

  public void start(Promise<Void> startPromise) throws Exception {

    HttpServer server = vertx.createHttpServer();

    Router router = Router.router(vertx);

    SockJSHandler sockJSHandler = SockJSHandler.create(vertx);

    EventBus eventBus = vertx.eventBus();

    router.route("/myapp/*").subRouter(sockJSHandler.bridge(new SockJSBridgeOptions()

        .addInboundPermitted(new PermittedOptions().setAddress("chat.inbound"))

        .addOutboundPermitted(new PermittedOptions().setAddress("chat.outbound"))));

      vertx.setPeriodic(4000, tid -> {

        eventBus.publish("chat.inbound", "Anushka here");
      });
    eventBus.consumer("chat.outbound", message->{

      System.out.println(message.body());
    });

    server.requestHandler(router).listen(8888).onComplete(ready -> {

      if (ready.succeeded()) {

        System.out.println("Server Started Listening! ");

        startPromise.complete();

      } else {

        System.out.println("Server Failed To Start!!");
        startPromise.fail("Server Failed To Start!!" + ready.cause().getMessage());
      }
    });
  }

  public static void main(String[] args) {
    Vertx vertx = Vertx.vertx();

    vertx.deployVerticle(new EventBusBridge());
  }
}
