package router;

import io.vertx.core.*;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class GET extends AbstractVerticle {

  public static void main(String[] args) {

    Vertx vertx = Vertx.vertx();

    vertx.deployVerticle(GET.class.getName(), new DeploymentOptions().setInstances(2));

  }

  @Override
  public void start(Promise<Void> startPromise) throws IOException {

    try {

      Router router = Router.router(vertx);

      HttpServer server = vertx.createHttpServer();

      server.requestHandler(router).listen(8080).onSuccess(ok -> System.out.println("Server listening at Port 8080"));

      Route route = router.route(HttpMethod.GET, "/home");

      route.handler(context -> {

        System.out.println("Request accepted by " + Thread.currentThread().getName());

        HttpServerResponse response = context.response();

        response.putHeader("content-type", "text/plain");

        response.setChunked(true);

        response.write("hello \n");

        context.next();

      });

      route.handler(context -> {

        HttpServerResponse response = context.response();

        response.write("Anushka\n");
//
//        context.put("hie", "yolo");
//
//        System.out.println("context put successfully");

        context.next();

//        context.response().end();

      });

      route.handler(context -> {

        HttpServerResponse response = context.response();

        response.write("How are you?\n");

        context.response().end();

      });



      router.route(HttpMethod.GET, "/welcome").handler(context -> {

        System.out.println("Request accepted by " + Thread.currentThread().getName());

        HttpServerResponse response = context.response();

        response.putHeader("content-type", "text/plain").setChunked(true);

        response.write("Welcome to Fruit Shop!");

//        String bar = context.get("foo");

//        response.write(bar);

        response.end();

      });

      JsonObject fruits = new JsonObject(new String(Files.readAllBytes(Path.of("/home/anshu/anshu_training/Motadata_Learning/Vertx-Web/src/main/java/router/fruits.json"))));

      router.route("/fruits").order(1).respond(context -> {

        context.response().putHeader("content-type", "application/json");

        context.response().setChunked(true);

        context.response().setStatusCode(200);

        context.response().write(fruits.encodePrettily());

        return context.response().end();
      });

      router.route("/fruits").order(0).respond(context ->
      {
        context.response().putHeader("content-type", "application/json");

        context.response().setChunked(true);

        context.response().setStatusCode(200);

        context.response().write(fruits.encodePrettily());

        return context.response().end();
      });


      router.get("/getprice/:fruitname").consumes("*").produces("application/json").respond(context ->
      {
        String fruitName = context.pathParam("fruitname");

        context.response().putHeader("content-type", "application/json");

        context.response().setChunked(true);

        context.response().setStatusCode(200);

        context.response().write(fruits.getJsonObject(fruitName).getString("price"));

        return context.response().end();
      });

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
