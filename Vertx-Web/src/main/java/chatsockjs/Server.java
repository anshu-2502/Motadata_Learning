package chatsockjs;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.EventBus;
import io.vertx.ext.bridge.PermittedOptions;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.StaticHandler;
import io.vertx.ext.web.handler.sockjs.SockJSBridgeOptions;
import io.vertx.ext.web.handler.sockjs.SockJSHandler;
import java.text.DateFormat;
import java.time.Instant;
import java.util.Date;

public class Server extends AbstractVerticle {

  public static void main(String[] args) {


    Vertx vertx = Vertx.vertx();

    vertx.deployVerticle(new Server());
  }

  public void start() throws Exception{

    Router router = Router.router(vertx);

    SockJSBridgeOptions options = new SockJSBridgeOptions().addInboundPermitted(new PermittedOptions().setAddress("chat.to.server"))
      .addOutboundPermitted(new PermittedOptions().setAddress("chat.to.client"));


    SockJSHandler ebHandler = SockJSHandler.create(vertx);

    router.mountSubRouter("/eventbus", ebHandler.bridge(options));


    router.route().handler(StaticHandler.create());

    vertx.createHttpServer().requestHandler(router).listen(8080);


    EventBus eb = vertx.eventBus();

    // Register to listen for messages coming IN to the server

    eb.consumer("chat.to.server").handler(message -> {


      String timestamp = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.MEDIUM).format(Date.from(Instant.now()));

      // Send the message back out to all clients with the timestamp prepended.

      eb.publish("chat.to.client", timestamp + ": " + message.body());
    });

  }


}
