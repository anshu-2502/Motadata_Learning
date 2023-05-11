package HTTP.formUpload;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;

public class Server extends AbstractVerticle {

    public void start() throws Exception {

        vertx.createHttpServer().requestHandler(req -> {

            if (req.uri().equals("/")) {

                req.response().sendFile("/home/anshu/anshu_training/Motadata_Learning/Vertx/src/main/java/HTTP/formUpload/index.html");

                System.out.println("sending file");

            } else if (req.uri().startsWith("/form")) {

                req.setExpectMultipart(true);

                req.uploadHandler(upload -> {

                    upload.streamToFileSystem(upload.filename()).onSuccess(v -> req.response().end("Successfully uploaded to " + upload.filename()))

                            .onFailure(err -> req.response().end("Upload failed"));
                });
            } else {
                req.response()
                        .setStatusCode(404)
                        .end();
            }
        }).listen(8080);

    }

    public static void main(String[] args) {
        try {


            Vertx vertx = Vertx.vertx();

            vertx.deployVerticle(new Server());

        }
        catch (Exception e){

            System.out.println(e);
        }
    }
}

