package worker;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;

public class deployWorker extends AbstractVerticle {
    @Override
    public void start(){

        System.out.println("in main method: " + Thread.currentThread().getName());

        DeploymentOptions options = new DeploymentOptions().setWorker(true);

        System.out.println(options.getWorkerPoolSize());

        options.setWorkerPoolSize(2);

        System.out.println("after setting worker poolsize as 2: -> "+options.getWorkerPoolSize());

        vertx.deployVerticle(new workerVerticle(), result->{

            if(result.succeeded()){

                vertx.undeploy(result.result(), res->{

                    if(res.succeeded()){

                        System.out.println("worker undeployed");

                    }
                });
            }
            System.out.println("deployed worker verticle");
        });


    }

    public static void main(String[] args) {

        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(new deployWorker());
    }





}
