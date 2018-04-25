package tn.esprit.b1.esprit1718b1erp.app.client.gui;

import java.io.IOException;

import javax.naming.NamingException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import tn.esprit.b1.esprit1718b1erp.app.client.util.ChatRoomClientEndPoint;
import tn.esprit.b1.esprit1718b1erp.app.client.util.ChatRoomMessageHandler;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
import javafx.scene.Scene;

@SuppressWarnings("restriction")
public class Client extends Application{

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
      stage.setTitle("Chat Room");
        final TextField textfield = new TextField();
        Button sendButton = new Button("Send");
        HBox hbox = new HBox();
        hbox.getChildren().addAll(textfield,sendButton);
        TextArea textArea = new TextArea();
        textArea.setFocusTraversable(false);
        textArea.setEditable(false);
        VBox vbox = new VBox();
        vbox.getChildren().addAll(textArea,hbox);
        StackPane stackpane = new StackPane();
        stackpane.getChildren().add(vbox);
        stage.setScene(new Scene(stackpane,250,200));
        final ChatRoomClientEndPoint chatRoomClientEndPoint = new ChatRoomClientEndPoint(textArea);
        sendButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent arg0) {
                try {
                    chatRoomClientEndPoint.sendMessage(textfield.getText());
                    textfield.clear();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                
            }
        });
        stage.show();
        
    }

}
