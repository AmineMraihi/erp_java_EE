package tn.esprit.b1.esprit1718b1erp.app.client.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.criteria.CriteriaBuilder.In;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import tn.esprit.b1.esprit1718b1erp.app.client.controllers.Config2;
import tn.esprit.b1.esprit1718b1erp.services.amine.ItemServiceRemote;

public class ItemVerfication {
    
    static MediaPlayer mediaplayer;
    private static InitialContext ctx = null;
    private final static String jndiNameItem = "esprit1718b1erp-ear/esprit1718b1erp-service/ItemService!tn.esprit.b1.esprit1718b1erp.services.amine.ItemServiceRemote";
    static ItemServiceRemote itemService;

    public static boolean verifyTypes(boolean a, boolean b, boolean c) {
        return (a && b && c) || (a && b) || (a && c) || (b && c);
    }

    public static void verifyItemNameDoesNotExists(TextField t) {
        for (String s : ItemUtil.getItemNames()) {
            if (t.getText().equals(s)) {
                playSound("error.mp3");
                Config2.dialog(Alert.AlertType.ERROR, "Item name already exists, please provide another one");
            }
        }
    }

    public static void verifyDoesNotContainLetterForBarcode(TextField t) {
        char[] data = t.getText().toCharArray();
        boolean valid = true, barcodeExists = false;

        for (Integer i : ItemUtil.getItemBarcodesList()) {

            try {
                if (i == Integer.parseInt(t.getText())) {
                    barcodeExists = true;
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("exception catched");
            }
        }

        if (!verifyDoesNotContainLetter(t) || barcodeExists) {
            playSound("error.mp3");
            Config2.dialog(Alert.AlertType.ERROR, "Please, Fill With a valid Number");
            t.clear();
            t.requestFocus();
        }
    }

    public static boolean verifyDoesNotContainLetter(TextField t) {
        boolean valid = true;
        char[] data = t.getText().toCharArray();
        for (char c : data) {
            if (!Character.isDigit(c)) {
                valid = false;
                break;
            }
        }

        if (!valid) {
            t.clear();
            t.requestFocus();
        }
        return valid;
    }
    
    private static void playSound(String s) {
        Media videoFile = new Media("file:///C:/wamp64/www/imagesAmine/snd/" + s);
        mediaplayer = new MediaPlayer(videoFile);
        mediaplayer.play();
    }
}
