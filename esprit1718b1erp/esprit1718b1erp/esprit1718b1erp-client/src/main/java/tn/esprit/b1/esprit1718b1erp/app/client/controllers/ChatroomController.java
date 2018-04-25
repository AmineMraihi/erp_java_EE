package tn.esprit.b1.esprit1718b1erp.app.client.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tn.esprit.b1.esprit1718b1erp.app.client.util.ChatRoomClientEndPoint;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.websocket.DeploymentException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class ChatroomController implements Initializable{

    @FXML
    private Text lblRudyCom;

    @FXML
    private Label lblClose;

    @FXML
    private TextArea textArea;
    @FXML
    private TextField textfield;
    @FXML
    private Button Send;

   
    @SuppressWarnings("restriction")
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        ChatRoomClientEndPoint chatRoomClientEndPoint;
        try {
            chatRoomClientEndPoint = new ChatRoomClientEndPoint(textArea);
            textArea.setFocusTraversable(false);
            textArea.setEditable(false);
            Send.setText("Connect");
            textfield.setText(LoginController.getLoggedUser().getName());
            Send.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent arg0) {
                    try {
                        chatRoomClientEndPoint.sendMessage(textfield.getText());
                        textfield.clear();
                        Send.setText("Send");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    
                }
            });
        } catch (URISyntaxException | DeploymentException | IOException e1) {
            e1.printStackTrace();
        }
        
    }

}
