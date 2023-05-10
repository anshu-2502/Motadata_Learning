package Router;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpMethod;
import io.vertx.ext.web.Router;

public class subRouter extends AbstractVerticle {

  public static void main(String[] args) {

    Vertx vertx = Vertx.vertx();

    vertx.deployVerticle(new subRouter());
  }

  @Override
  public void start() {

    Router mainRouter = Router.router(vertx);

    Router placeRouter = Router.router(vertx);

    Router infoRouter = Router.router(vertx);

    mainRouter.route(HttpMethod.GET, "/place/*").subRouter(placeRouter);

    mainRouter.route(HttpMethod.GET, "/info/*").subRouter(infoRouter);

    placeRouter.route("/cities").handler(context -> {

      context.response().putHeader("content-type", "text/plain").setChunked(true);

      context.response().write("Cities : { Jaipur, Ahemadabad, Gorakhpur }");

      context.end();
    });

    infoRouter.route("/fruits").handler(context -> {

      context.response().putHeader("content-type", "text/plain").setChunked(true);

      context.response().write("Fruits : { Apple, Mango, Banana }");

      context.end();
    });

    placeRouter.route("/colleges").handler(context -> {

      context.response().putHeader("content-type", "text/plain").setChunked(true);

      context.response().write("Colleges : { IIT , IIM, NIT }");

      context.end();
    });

    infoRouter.route("/names").handler(context -> {

      context.response().putHeader("content-type", "text/plain").setChunked(true);

      context.response().write("Names : { Anshu , Anushka , Anshhhuu }");

      context.end();
    });

    vertx.createHttpServer().requestHandler(mainRouter)
      .listen(8080).onSuccess(done -> System.out.println("Server listening on PORT 8080"));

  }
}
