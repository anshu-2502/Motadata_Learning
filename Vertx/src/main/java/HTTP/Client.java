package HTTP;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpClientRequest;
import io.vertx.core.http.HttpMethod;

public class Client extends AbstractVerticle {

    public static void main(String[] args) {

        try {


            Vertx vertx = Vertx.vertx();

            vertx.deployVerticle(new Client());

        }
        catch (Exception e){

            System.out.println(e);
        }
    }

    @Override
    public void start() throws Exception {

        HttpClient client = vertx.createHttpClient();

        client.request(HttpMethod.GET, 8080, "localhost", "/")
                .compose(HttpClientRequest::send)
                .compose(res -> {

                    System.out.println(res.statusCode());

                    return res.body();
                }).onSuccess(body-> System.out.println(body.toString()));
    }
}