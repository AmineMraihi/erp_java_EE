package tn.esprit.b1.esprit1718b1erp.app.client.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.b1.esprit1718b1erp.entities.Category;
import tn.esprit.b1.esprit1718b1erp.entities.Contact;
import tn.esprit.b1.esprit1718b1erp.entities.Item;
import tn.esprit.b1.esprit1718b1erp.entities.User;
import tn.esprit.b1.esprit1718b1erp.services.amine.ItemServiceRemote;
import tn.esprit.b1.esprit1718b1erp.services.jassem.ContactServiceRemote;

public class ItemUtil {
    private final static String jndiNameItem = "esprit1718b1erp-ear/esprit1718b1erp-service/ItemService!tn.esprit.b1.esprit1718b1erp.services.amine.ItemServiceRemote";

    static ItemServiceRemote itemService;
    private static InitialContext ctx = null;

    public static List<String> getItemNames() {
        List<String> list = new ArrayList<String>();
        try {
            ctx = new InitialContext();
            itemService = (ItemServiceRemote) ctx.lookup(jndiNameItem);
            list = itemService.getItemNamesList();
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }
        return list;
    }

    public static List<Integer> getItemBarcodesList() {
        List<Integer> list = new ArrayList<Integer>();
        try {
            ctx = new InitialContext();
            itemService = (ItemServiceRemote) ctx.lookup(jndiNameItem);
            list = itemService.getItemBarcodeList();
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }
        return list;
    }

    public static void saveOrUpdateItemWithCategoryAndSupplier(Item i, Category c, Contact s,User u) {
        try {
            ctx = new InitialContext();
            itemService = (ItemServiceRemote) ctx.lookup(jndiNameItem);
            if (i.getId() == null) {
                itemService.addItemWithCategoryAndSupplier(i, c, s,u);
            } else {
                itemService.updateItemWithCategoryAndSupplier(i, c, s,u);
            }
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }
    }
    
    
}
