package tn.esprit.b1.esprit1718b1erp.app.client.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import org.apache.log4j.Logger;

public class TestController {

    @FXML
    private Button buttonId;
    private static final Logger LOGGER = Logger.getLogger(TestController.class);

    @FXML
    void buttonFunction() {
        LOGGER.info("test bouton");

    }

    @FXML
    void initialize() {
        LOGGER.info("Showed Test fxml");
        buttonId.setVisible(true);
    }
}
