package eventbus.pointtopoint;


import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.Vertx;

public class Receiver extends AbstractVerticle {

    @Override
    public void start() throws Exception {

     EventBus eventBus = vertx.eventBus();

        eventBus.consumer("ping-address", message -> {

            System.out.println("Received message: " + message.body());

            message.reply("-------ping received----!");
        });

        System.out.println("Receiver ready!");
    }



}
