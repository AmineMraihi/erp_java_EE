package tn.esprit.b1.esprit1718b1erp.app.client.gui;
import java.net.URI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class TestChat extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        URI uri = new URI("ws://localhost:18080/esprit1718b1erp-web/chat");
        WebView webview = new WebView();
        webview.getEngine().load(
                "http://localhost:18080/esprit1718b1erp-web/index2.jsf"
        );
        webview.setPrefSize(640, 600);

        stage.setScene(new Scene(webview));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}