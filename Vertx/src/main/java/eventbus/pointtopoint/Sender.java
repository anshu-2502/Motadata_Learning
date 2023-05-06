package eventbus.pointtopoint;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.EventBus;
import worker.deployWorker;

public class Sender extends AbstractVerticle {

    public void start()throws Exception{

        EventBus eventBus = vertx.eventBus();

        vertx.setPeriodic(1000,  vertex->{

            eventBus.request("ping-address", "hi from sender!!" , reply->{

                if(reply.succeeded()){

                    System.out.println("received ack from sender " + reply.result().body() );

                }
                else{

                    System.out.println("no acknowledegement received from receiver.");

                }
            });
        });
    }

    public static void main(String[] args) {

        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(new Sender());

        vertx.deployVerticle(new Receiver());


    }
}
