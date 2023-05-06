package worker;

import io.vertx.core.AbstractVerticle;

import io.vertx.core.Promise;

public class workerVerticle extends  AbstractVerticle{

    public void start(Promise<Void> startPromise){

        System.out.println("Worker Starting in " + Thread.currentThread().getName());

        for (int i = 0; i < 5; i++) {

            System.out.print(i + " ");

        }

        startPromise.complete();
    }

}

