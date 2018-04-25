package tn.esprit.b1.esprit1718b1erp.app.client.util;

import java.io.StringReader;

import javax.json.Json;
import javax.websocket.MessageHandler;
import javafx.scene.control.TextArea;
@SuppressWarnings("restriction")
public class ChatRoomMessageHandler implements MessageHandler.Whole<String>{

    TextArea textarea = null;
    public ChatRoomMessageHandler(TextArea textarea) {
        this.textarea=textarea;
    }
    public void onMessage(String message) {
    textarea.appendText(Json.createReader(new StringReader(message)).readObject().getString("message")+"\n"); 
    
    }

}
