package tn.esprit.b1.esprit1718b1erp.app.client.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import tn.esprit.b1.esprit1718b1erp.app.client.animations.FadeInLeftTransition;
import tn.esprit.b1.esprit1718b1erp.app.client.animations.FadeInRightTransition;
import tn.esprit.b1.esprit1718b1erp.app.client.animations.FadeInTransition;

public class SplashController implements Initializable {
    @FXML
    private ImageView imgLoading;

    @FXML
    private Text lblWelcome;

    @FXML
    private Text lblRudy;

    @FXML
    private VBox vboxBottom;

    @FXML
    private Label lblClose;
    
    Stage stage;

    private void longStart() {
        Service<String> service = new Service<String>() {
            @Override
            protected Task<String> createTask() {
                return new Task<String>() {
                    @Override
                    protected String call() throws Exception {
                        for (int k = 0; k < 50; k++) {
                            Thread.sleep(50);
                        }
                        return null;
                    }
                };
            }
        };
        service.start();
        service.setOnRunning((WorkerStateEvent event) -> {
            new FadeInLeftTransition(lblWelcome).play();
            new FadeInRightTransition(lblRudy).play();
            new FadeInTransition(vboxBottom).play();
        });
        service.setOnSucceeded((WorkerStateEvent event) -> {
            Config2 config = new Config2();
            config.newStage((Stage) lblClose.getScene().getWindow(), "/fxml/login.fxml", "ERP Solutions", true, StageStyle.UNDECORATED,
                    false);
        });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        longStart();
        lblClose.setOnMouseClicked((MouseEvent)->{
            Platform.exit();
        });

    }
}
