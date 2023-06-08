package APIS;

import com.google.gson.Gson;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.*;
import io.vertx.ext.web.sstore.LocalSessionStore;
import io.vertx.ext.auth.properties.PropertyFileAuthentication;

public class publicApi extends AbstractVerticle {

    EventBus eventBus;

    public void start(Promise<Void> startPromise){

        eventBus = vertx.eventBus();

        Router router = Router.router(vertx);

        String path = "/home/anshu/anshu_training/Motadata_Learning/NMSLIte2023/src/main/resources/user.properties";

        try {

            router.route().handler(BodyHandler.create());

            router.route().handler(SessionHandler.create(LocalSessionStore.create(vertx)));

            PropertyFileAuthentication authenticate = PropertyFileAuthentication.create(vertx, path);

            router.route("/user/*").handler(RedirectAuthHandler.create(authenticate, "login.html"));

            router.route("/loginHandler").handler(FormLoginHandler.create(authenticate));

            router.route("/user/*").handler(StaticHandler.create().setCachingEnabled(false));

            router.route("/logout").handler(context -> {

                context.clearUser();

                context.response().putHeader("location", "/user").setStatusCode(302).end();

            });


            router.post("/adddevice").handler(routingContext -> {

                JsonObject addDevicejson =  routingContext.getBody().toJsonObject();

                System.out.println(addDevicejson);

                eventBus.send("insert",addDevicejson);

            });

            router.get("/getdata").handler(routingContext -> {

                eventBus.<JsonArray>request("select", "", reply->{

                    if(reply.succeeded()){

                        routingContext.response()
                                .putHeader("Content-Type", "application/json").end(reply.result().body().toString());

                    }

                    else{
                        System.out.println("nope");
                    }

                    JsonArray data = reply.result().body();

                    System.out.println(data);

                    System.out.println(reply.result().body().encodePrettily());
                });



            });





                router.route().handler(StaticHandler.create());

                vertx.createHttpServer().requestHandler(router).listen(8080);

                System.out.println("listening on port 8080");

                startPromise.complete();

        }

    catch (Exception e){

        e.printStackTrace();

    }}

}
