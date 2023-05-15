package CounterSockjs;

import io.vertx.core.Handler;
import io.vertx.core.eventbus.EventBus;
import io.vertx.ext.bridge.BridgeEventType;
import io.vertx.ext.web.handler.sockjs.BridgeEvent;

import java.util.Optional;

public class CounterHandler  implements Handler<BridgeEvent>{

  private final EventBus eventBus;
  private final CounterRepo repository;

  public CounterHandler(EventBus eventBus, CounterRepo repository) {

    this.eventBus = eventBus;

    this.repository = repository;

  }




  @Override
  public void handle(BridgeEvent event) {

    if(event.type()== BridgeEventType.SOCKET_CREATED){

      System.out.println("socket was created.");
    }

    if(event.type() == BridgeEventType.SEND){

      System.out.println("client to server");

      clientToServer();

      event.complete(true);
    }

  }

  private void clientToServer(){

    Optional<Integer> counter = repository.get();

    if (counter.isPresent()) {

      Integer value = counter.get() + 1;

      repository.update(value);

      eventBus.publish("out", value);

    } else {

      Integer value = 1;

      repository.update(value);

      eventBus.publish("out", value);

    }
  }
}
