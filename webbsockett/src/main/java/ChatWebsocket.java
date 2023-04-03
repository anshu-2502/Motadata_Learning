//import model.MessageModel;

import model.MessageModel;

import javax.websocket.EncodeException;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


@ServerEndpoint( value= "/chat", decoders = MessageDecoder.class , encoders = MessageEncoder.class)
public class ChatWebsocket {

    public static Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());
    @OnMessage
    public String onMessage(Session session, MessageModel message) {

        System.out.println("handling messsage" + message);


        for(Session eachsession: sessions){

            try {

                eachsession.getBasicRemote().sendObject(message);

            } catch (Exception e) {
                throw new RuntimeException(e);

            }

        }
        return null;
    }

    @OnOpen
    public void onOpen(Session session){

        System.out.println("on open:" + session.getId());

        sessions.add(session);

       session.setMaxIdleTimeout(30000000);

    }

    public  void onClose(Session session){

        System.out.println("on close:" + session.getId());



        sessions.remove(session);


    }


}
