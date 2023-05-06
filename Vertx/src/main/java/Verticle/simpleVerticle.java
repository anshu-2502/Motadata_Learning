package Verticle;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;

public class simpleVerticle extends AbstractVerticle {
    @Override
    public void start(Promise<Void> startPromise) throws Exception {

        System.out.println("verticle started");

        vertx.setTimer(4000, handler->{

            System.out.println("timer after 4 seconds");
        });

        vertx.setPeriodic(2000,handler->{

            System.out.println("periodic timer every 2 seconds");

        });

        startPromise.complete();

    }
    public void stop() {
        System.out.println("Cleanup tasks are now complete, VerticleExample is now stopped!");

    }
}
