package HighWaterMark;

import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

public class subscriber {

        public static void main (String[] args)
        {
            try( ZContext context = new ZContext(); ZMQ.Socket socket = context.createSocket(SocketType.SUB))
            {
                socket.connect("tcp://localhost:9999");

                socket.subscribe("Anushkaaaa");


                while ( true )
                {
                    String mess = socket.recvStr();

                    System.out.println(mess);
                }
            }
            catch ( Exception exception )
            {
                exception.printStackTrace();
            }
        }

    }