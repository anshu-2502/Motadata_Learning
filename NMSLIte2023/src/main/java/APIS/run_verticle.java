package APIS;

import Database.Databaseh2;
import io.vertx.core.Vertx;

public class run_verticle {
    public static void main(String[]args){

        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(publicApi.class.getName()).onComplete(handler ->{
            if (handler.succeeded()){
                System.out.println("api verticle deployed");
            }
        });

        vertx.deployVerticle(Databaseh2.class.getName()).onComplete(handler -> {
            if (handler.succeeded())
            {
                System.out.println(" database verticle Deployed");
            }else {
                handler.cause().printStackTrace();
            }
        });

    }
}
