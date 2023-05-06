package eventbus.pubsub;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.EventBus;

public class Receiver1 extends AbstractVerticle {

    public void start() throws Exception{

        EventBus eventBus = vertx.eventBus();

        eventBus.consumer("hi anshu update--" , message -> {
            System.out.println(message.body());
        });

        eventBus.consumer("hi anshu-2 update--" , message -> {
            System.out.println(message.body());
        });
    }
}
