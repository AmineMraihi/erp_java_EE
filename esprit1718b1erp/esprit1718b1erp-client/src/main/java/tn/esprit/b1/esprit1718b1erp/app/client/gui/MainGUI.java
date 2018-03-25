package tn.esprit.b1.esprit1718b1erp.app.client.gui;


import java.lang.Thread.UncaughtExceptionHandler;
import java.security.Permission;
import java.util.concurrent.FutureTask;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class MainGUI extends Application {
   
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/splash.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }

    public static void main(String[] args) {
        System.setSecurityManager(new SecurityManager(){
            @Override
            public void checkPermission(Permission perm) {}
        });
        Thread.setDefaultUncaughtExceptionHandler(ALERT_EXCEPTION_HANDLER);
        launch(MainGUI.class,args);
    }

    public static final UncaughtExceptionHandler ALERT_EXCEPTION_HANDLER = (thread, cause) -> {
        try {
            cause.printStackTrace();
            final Runnable showDialog = () -> {
               Alert alert = new Alert(AlertType.ERROR);
//               alert.setContentText("ya bhiim :p "+cause.toString());
               alert.setContentText("hahaha ya bhiim");
               alert.showAndWait();
            };
            if (Platform.isFxApplicationThread()) {
               showDialog.run();
            } else {
               FutureTask<Void> showDialogTask = new FutureTask<Void>(showDialog, null);
               Platform.runLater(showDialogTask);
               showDialogTask.get();
            }
        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
//            System.exit(-1);
        }
    };
}
