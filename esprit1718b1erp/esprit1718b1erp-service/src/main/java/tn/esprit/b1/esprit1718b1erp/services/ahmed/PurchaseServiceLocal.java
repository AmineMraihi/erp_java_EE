package tn.esprit.b1.esprit1718b1erp.services.ahmed;

import java.util.Map;

import javax.ejb.Local;

import tn.esprit.b1.esprit1718b1erp.entities.Purchase;
import tn.esprit.b1.esprit1718b1erp.utilities.IGenericDAO;

@Local
public interface PurchaseServiceLocal extends IGenericDAO<Purchase> {
   Map<String, Number> sommetot_purchase();
}
