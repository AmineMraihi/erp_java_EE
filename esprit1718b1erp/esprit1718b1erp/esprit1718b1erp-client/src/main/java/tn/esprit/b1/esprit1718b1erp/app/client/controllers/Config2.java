package tn.esprit.b1.esprit1718b1erp.app.client.controllers;
import java.io.IOException;

import org.apache.log4j.Logger;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Config2 {

    private static final Logger LOGGER = Logger.getLogger(Config2.class);

    public Config2() {
        //
    }
    

    public static void dialog(Alert.AlertType alertType, String s) {
        Alert alert = new Alert(alertType, s);
        alert.initStyle(StageStyle.UTILITY);
        alert.setTitle("Info");
        alert.showAndWait();
    }

    public void newStage(Stage stage, String load, String judul, boolean resize, StageStyle style, boolean maximized) {
        try {
            Stage st = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource(load));
            Scene scene = new Scene(root);
            st.initStyle(style);
            st.setResizable(resize);
            st.setMaximized(maximized);
            st.setTitle(judul);
            st.setScene(scene);
            st.show();
            stage.close();
        } catch (Exception e) {
            LOGGER.info("from newStage", e);
        }
    }

   
    public void loadAnchorPane(AnchorPane ap, String a) {
        try {
            AnchorPane p = FXMLLoader.load(getClass().getResource("/fxml/" + a));
            ap.getChildren().setAll(p);
        } catch (IOException e) {
            LOGGER.info("from loadAnchorPane", e);
        }
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static void setModelColumn(TableColumn tb, String a) {
        tb.setCellValueFactory(new PropertyValueFactory(a));
    }
}
