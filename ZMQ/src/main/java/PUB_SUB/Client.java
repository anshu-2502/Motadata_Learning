package PUB_SUB;

import org.zeromq.SocketType;
import org.zeromq.ZMQ;

import java.util.StringTokenizer;

public class Client {

    public static void main(String[] args)
    {
        try (ZMQ.Context context = ZMQ.context(1)) {

            //  Socket to talk to server

            System.out.println("Collecting updates from weather server");

            ZMQ.Socket subscriber = context.socket(SocketType.SUB);



            subscriber.connect("tcp://*:5556");

            //  Subscribe to zipcode, default is NYC, 10001

            String filter = (args.length > 0) ? args[0] : "10001 ";

            subscriber.subscribe(filter.getBytes(ZMQ.CHARSET));




            //  Process 100 updates
            int update_nbr;

            long total_temp = 0;

            for (update_nbr = 0; update_nbr < 100; update_nbr++) {

                //  Use trim to remove the tailing '0' character

                String string = subscriber.recvStr(0).trim();

                StringTokenizer sscanf = new StringTokenizer(string, " ");

//                int zipcode = Integer.valueOf(sscanf.nextToken());

                int temperature = Integer.valueOf(sscanf.nextToken());

//                int relhumidity = Integer.valueOf(sscanf.nextToken());

                total_temp += temperature;
            }

            System.out.println(String.format("Average temperature for zipcode '%s' was %d.", filter, (int)(total_temp / update_nbr)));
        }
    }
}
