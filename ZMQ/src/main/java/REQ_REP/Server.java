package REQ_REP;

import org.zeromq.SocketType;

import org.zeromq.ZMQ;

public class Server {
    public static void main(String[] args) throws Exception {

        try (ZMQ.Context context = ZMQ.context(1)) {




            ZMQ.Socket responder = context.socket(ZMQ.REP);

            responder.bind("tcp://*:5555");

            while (!Thread.currentThread().isInterrupted()) {


                byte[] request = responder.recv(0);

//                System.out.println(responder.getMaxMsgSize());


                System.out.println("Received " + new String(request));



//                System.out.println("Received Hello");

                // Do some 'work'
                Thread.sleep(1000);

                // Send reply back to client
                String reply = "World";

                responder.send(reply.getBytes(), 0);

//                responder.setLinger(1000);

//                System.out.println(responder.getLinger());

                responder.close();
            }

        }
    }
}