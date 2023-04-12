package HighWaterMark;

import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

import java.util.Random;

public class publisher {

    public static void main (String[] args)
    {
        try( ZContext context = new ZContext(); ZMQ.Socket socket = context.createSocket(SocketType.PUB))
        {
            socket.bind("tcp://*:9999");

            socket.setSndHWM(2);

            Random random = new Random();

            while ( true )
            {
                String message = "Anushka " + random.nextInt(1000);

                socket.sendMore("Anushkaaaa");

                socket.send(message);

                socket.send("Blahh");

                Thread.sleep(1000);
            }
        }
        catch ( Exception exception)
        {
            exception.printStackTrace();
        }
    }

    }
