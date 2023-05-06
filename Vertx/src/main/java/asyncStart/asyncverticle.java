package asyncStart;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;

public class asyncverticle extends AbstractVerticle {

    public void start(Promise<Void> startPromise) throws Exception{

        System.out.println("in other verticle async");

        vertx.setTimer(2000,timer->{

            System.out.println("startup task completed!");

            startPromise.complete();
        });



    }

    @Override
    public void stop(Promise<Void> stopPromise) throws Exception {

        vertx.setTimer(2000, timer -> {

            System.out.println("Cleanup tasks are now complete, OtherVerticle is now stopped!");

            stopPromise.complete();

        });

    }
}
