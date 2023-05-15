//package CounterSockjs;
//
//import io.vertx.core.AbstractVerticle;
//import io.vertx.core.Handler;
//import io.vertx.core.eventbus.EventBus;
//import io.vertx.core.net.SocketAddress;
//import io.vertx.core.shareddata.SharedData;
//import io.vertx.ext.bridge.BridgeOptions;
//import io.vertx.ext.bridge.PermittedOptions;
//import io.vertx.ext.web.Router;
//import io.vertx.ext.web.RoutingContext;
//import io.vertx.ext.web.handler.StaticHandler;
//import io.vertx.ext.bridge.PermittedOptions;
//import io.vertx.ext.web.handler.sockjs.SockJSBridgeOptions;
//import io.vertx.ext.web.handler.sockjs.SockJSHandler;
//
//import java.net.InetAddress;
//import java.net.InetSocketAddress;
//import java.net.UnknownHostException;
//
//public class CounterVerticle extends AbstractVerticle {
//
//  @Override
//  public void start() {
//    Router router = Router.router(vertx);
//
//    router.route("/eventbus/*").handler(eventBusHandler());
//    router.route().handler(staticHandler());
//
//    vertx.createHttpServer()
//      .requestHandler(router)
//      .listen(8080);
//  }
//
//  private SockJSHandler eventBusHandler() {
//    BridgeOptions options = new BridgeOptions()
//      .addOutboundPermitted(new PermittedOptions().setAddressRegex("out"))
//      .addInboundPermitted(new PermittedOptions().setAddressRegex("in"));
//
//    SharedData data = vertx.sharedData();
//    CounterRepo repository = new CounterRepo(data);
//    EventBus eventBus = vertx.eventBus();
//    CounterHandler counterHandler = new CounterHandler(eventBus, repository);
//
//    SockJSHandler sockJSHandler = SockJSHandler.create(vertx);
//    return (SockJSHandler) sockJSHandler.bridge((SockJSBridgeOptions) options, counterHandler);
//  }
//
//  private StaticHandler staticHandler() {
//    return StaticHandler.create()
//      .setCachingEnabled(false);
//  }
//}
