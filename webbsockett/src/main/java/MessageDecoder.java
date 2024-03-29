import com.google.gson.Gson;
import model.MessageModel;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;


public class MessageDecoder implements Decoder.Text<MessageModel> {

    Gson gson = new Gson();

    @Override
    public MessageModel decode(String s) throws DecodeException {
        return gson.fromJson(s, MessageModel.class);
    }

    @Override
    public boolean willDecode(String s) {
        return s != null;
    }

    @Override
    public void init(EndpointConfig config) {
    }

    @Override
    public void destroy() {
    }

}