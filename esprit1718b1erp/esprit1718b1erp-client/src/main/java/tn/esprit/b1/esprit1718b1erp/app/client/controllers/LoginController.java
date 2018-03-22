package tn.esprit.b1.esprit1718b1erp.app.client.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import tn.esprit.b1.esprit1718b1erp.app.client.animations.FadeInLeftTransition;
import tn.esprit.b1.esprit1718b1erp.app.client.animations.FadeInLeftTransition1;
import tn.esprit.b1.esprit1718b1erp.app.client.animations.FadeInRightTransition;

public class LoginController implements Initializable {

    @FXML
    private TextField txtUsername;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Text lblWelcome;

    @FXML
    private Text lblUserLogin;

    @FXML
    private Text lblUsername;

    @FXML
    private Text lblPassword;

    @FXML
    private Button btnLogin;

    @FXML
    private Text lblRudyCom;

    @FXML
    private Label lblClose;

    Stage stage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(() -> {
            new FadeInRightTransition(lblUserLogin).play();
            new FadeInLeftTransition(lblWelcome).play();
            new FadeInLeftTransition1(lblPassword).play();
            new FadeInLeftTransition1(lblUsername).play();
            new FadeInLeftTransition1(txtUsername).play();
            new FadeInLeftTransition1(txtPassword).play();
            new FadeInRightTransition(btnLogin).play();

            lblClose.setOnMouseClicked((MouseEvent event) -> Platform.exit());
        });

    }

    @FXML
    void aksiLogin() {
        Config2 c = new Config2();
        c.newStage((Stage) lblClose.getScene().getWindow(), "/fxml/formMenu.fxml", "ERP Solutions", true, StageStyle.UNDECORATED, false);

    }

    public TextField getTxtUsername() {
        return txtUsername;
    }

    public void setTxtUsername(TextField txtUsername) {
        this.txtUsername = txtUsername;
    }

    public PasswordField getTxtPassword() {
        return txtPassword;
    }

    public void setTxtPassword(PasswordField txtPassword) {
        this.txtPassword = txtPassword;
    }

    public Text getLblWelcome() {
        return lblWelcome;
    }

    public void setLblWelcome(Text lblWelcome) {
        this.lblWelcome = lblWelcome;
    }

    public Text getLblUserLogin() {
        return lblUserLogin;
    }

    public void setLblUserLogin(Text lblUserLogin) {
        this.lblUserLogin = lblUserLogin;
    }

    public Text getLblUsername() {
        return lblUsername;
    }

    public void setLblUsername(Text lblUsername) {
        this.lblUsername = lblUsername;
    }

    public Text getLblPassword() {
        return lblPassword;
    }

    public void setLblPassword(Text lblPassword) {
        this.lblPassword = lblPassword;
    }

    public Button getBtnLogin() {
        return btnLogin;
    }

    public void setBtnLogin(Button btnLogin) {
        this.btnLogin = btnLogin;
    }

    public Text getLblRudyCom() {
        return lblRudyCom;
    }

    public void setLblRudyCom(Text lblRudyCom) {
        this.lblRudyCom = lblRudyCom;
    }

    public Label getLblClose() {
        return lblClose;
    }

    public void setLblClose(Label lblClose) {
        this.lblClose = lblClose;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

}
