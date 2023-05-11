package Session;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.Session;
import io.vertx.ext.web.handler.SessionHandler;
import io.vertx.ext.web.sstore.LocalSessionStore;

public class sessionhandle extends AbstractVerticle {

  @Override
  public void start(Promise<Void> startPromise) throws Exception {

    HttpServer server = vertx.createHttpServer();

    Router router = Router.router(vertx);

    SessionHandler sessionHandler = SessionHandler.create(LocalSessionStore.create(vertx, "mysession.session", 10000)).setSessionTimeout(10000);

    router.get("/session/start").handler(sessionHandler).handler(context -> {

      Session session = context.session();

      System.out.println("session created");

      session.put("name", "anushka");

      System.out.println("session put called");

      context.response().setChunked(true);

      context.end();
    });


    router.get("/session/end").handler(sessionHandler).handler(context -> {

      System.out.println("getting session details..");

      System.out.println(context.session().value());

      System.out.println(context.session().id());

      System.out.println(context.session().lastAccessed());

      System.out.println(context.session().timeout());

      System.out.println(context.session().isRegenerated());

      context.session().destroy();

      System.out.println(context.session().value());

      System.out.println(context.session().isDestroyed());

      context.response().setChunked(true);

      context.end();
    });

    server.requestHandler(router).listen(8080).onComplete(ready -> {

      if (ready.succeeded()) {

        System.out.println("Server Started Listening!");

        startPromise.complete();

      } else {

        System.out.println("Some Internal Error Occurred!" + ready.cause().getMessage());

        startPromise.fail("Some Internal Error Occurred!" + ready.cause().getMessage());
      }
    });
  }
  public static void main(String[] args) {

    Vertx vertx = Vertx.vertx();

    vertx.deployVerticle(sessionhandle.class.getName()).onComplete(handler -> {

      if (handler.succeeded()) {

        System.out.println("Verticle Deployed!");

      } else {

        System.out.println(handler.cause().getMessage());
      }
    });
  }
}

