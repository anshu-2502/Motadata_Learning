package com.example.starter;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import org.slf4j.LoggerFactory;

public class MainVerticle extends AbstractVerticle {

//  private static final Logger LOG = LoggerFactory.getLogger(MainVerticle.class);

  public static void main(String[]args){
    var vertx = Vertx.vertx();

    vertx.exceptionHandler(error -> {

//      LOG.error("Unhandled: {}", error);

      System.out.println("unhandled"+ error);

    });

    vertx.deployVerticle(new MainVerticle(), ar->{

      if(ar.failed()){

        System.out.println("failed to deploy" + ar.cause());

        return;
      }

      System.out.println("deployed");

    });
  }
  @Override
  public void start(Promise<Void> startPromise) throws Exception {

    vertx.createHttpServer().requestHandler(req -> {

      req.response().putHeader("content-type", "text/plain")
        .end("Hello from Vert.x!");

    }).listen(3421, http -> {

      if (http.succeeded()) {

        startPromise.complete();

        System.out.println("HTTP server started on port 3421");

      } else {

        startPromise.fail(http.cause());

      }
    });
  }
}
