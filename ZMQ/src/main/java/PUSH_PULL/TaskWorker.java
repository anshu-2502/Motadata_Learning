package PUSH_PULL;

import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

public class TaskWorker {

    public static void main(String[] args) throws Exception
    {
        try (ZContext context = new ZContext()) {

            ZMQ.Socket receiver = context.createSocket(SocketType.PULL);

            receiver.connect("tcp://localhost:5557");


            ZMQ.Socket sender = context.createSocket(SocketType.PUSH);

            sender.connect("tcp://localhost:5558");


            while (!Thread.currentThread().isInterrupted()) {

                String string = new String(receiver.recv(0), ZMQ.CHARSET).trim();

                long msec = Long.parseLong(string);

                System.out.flush();

                System.out.print(string + '.');


                Thread.sleep(msec);


                sender.send(ZMQ.MESSAGE_SEPARATOR, 0);
            }
        }
    }
}