package eventbus.pubsub;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Verticle;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.eventbus.EventBus;

public class Sender extends AbstractVerticle {

    public void start() throws Exception{

        EventBus eventBus = vertx.eventBus();

//        final int[] count = {1,2};

        int count=5;

        vertx.setPeriodic(1000, message->{

            eventBus.publish("hi anshu", count);

        });

        vertx.setPeriodic(1000, message->{

            eventBus.publish("hi anshu", count);

        });

    }
    public static void main(String[]args){

        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(new Sender());

        vertx.deployVerticle( new Receiver1());

        vertx.deployVerticle(new Receiver2());


    }
}