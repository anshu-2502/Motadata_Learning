package Future;

import io.vertx.core.CompositeFuture;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;

public class future {
    public static void main(String[] args) {

        Vertx vertx = Vertx.vertx();

        Promise<String> promise1 = Promise.promise();

        vertx.setTimer(1000, id -> {

            promise1.complete("Hello");

        });

        Promise<String> promise2 = Promise.promise();

        vertx.setTimer(2000, id -> {

            promise2.complete("world!");

        });


        Future<String> future1 = promise1.future();

        Future<String> future2 = promise2.future();

        CompositeFuture.all(future1, future2).onComplete(ar -> {

            if (ar.succeeded()) {

                String result1 = ar.result().resultAt(0);

                String result2 = ar.result().resultAt(1);

                System.out.println(result1 + " " + result2);
            } else {

                System.err.println("Error: " + ar.cause().getMessage());
            }

            vertx.close();
        });

        vertx.setTimer(3000, id -> {

            vertx.close();
        });
    }
}
