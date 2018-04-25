package tn.esprit.b1.esprit1718b1erp.app.client.util;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.Session;

import javafx.scene.control.TextArea;

@SuppressWarnings("restriction")
public class ChatRoomClientEndPoint extends Endpoint{

    Session session = null;
    
    public ChatRoomClientEndPoint(TextArea textarea) throws URISyntaxException, DeploymentException, IOException {
        URI uri = new URI("ws://localhost:18080/esprit1718b1erp-web/chatroom");
        ContainerProvider.getWebSocketContainer().connectToServer(this, uri);
        session.addMessageHandler(new ChatRoomMessageHandler(textarea));
        
    }
    public void onOpen(Session session, EndpointConfig config) {
        this.session=session;
        
    }
    public void sendMessage(String message) throws IOException{
        session.getBasicRemote().sendText(message);
    }
    
    
}
