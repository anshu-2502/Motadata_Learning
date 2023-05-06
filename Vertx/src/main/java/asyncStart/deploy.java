package asyncStart;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;


public class deploy extends AbstractVerticle {

    public void start()throws Exception{
        System.out.println("main verticle has started, deploying others");


        vertx.deployVerticle("asyncStart.asyncverticle", res->{

            if (res.succeeded()) {

                String deploymentID = res.result();

                System.out.println("Other verticle deployed ok, deploymentID = " + deploymentID);

                vertx.undeploy(deploymentID, res2 -> {
                    if (res2.succeeded()) {
                        System.out.println("Undeployed ok!");
                    } else {
                        res2.cause().printStackTrace();
                    }
                });
            } else {
                res.cause().printStackTrace();
            }
        });
    }

    public static void main(String[] args) {

        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle( new deploy());

    }



}
