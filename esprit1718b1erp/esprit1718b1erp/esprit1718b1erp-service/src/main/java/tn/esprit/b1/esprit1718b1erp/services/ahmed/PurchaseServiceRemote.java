package tn.esprit.b1.esprit1718b1erp.services.ahmed;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Remote;

import tn.esprit.b1.esprit1718b1erp.entities.Contact;
import tn.esprit.b1.esprit1718b1erp.entities.ItemOffer;
import tn.esprit.b1.esprit1718b1erp.entities.Purchase;
import tn.esprit.b1.esprit1718b1erp.entities.Item;
import tn.esprit.b1.esprit1718b1erp.utilities.IGenericDAO;

@Remote
public interface PurchaseServiceRemote extends IGenericDAO<Purchase> {

    Map<String, Number> sommetot_purchase();
  /////  List <Purchase> purchaseNames();
   List<Purchase> aaaa();
   List<Item> getlistItem(int i);
   Double ContactPurchasesPerMonth(Integer i,Contact c);
}
