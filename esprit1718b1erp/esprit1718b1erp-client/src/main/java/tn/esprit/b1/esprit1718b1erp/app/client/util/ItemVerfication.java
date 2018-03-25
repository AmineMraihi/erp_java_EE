package tn.esprit.b1.esprit1718b1erp.app.client.util;

public class ItemVerfication {
    public static boolean verifyTypes(boolean a, boolean b, boolean c) {
        return (a && b && c) || (a && b) || (a && c) || (b && c);
    }
}
