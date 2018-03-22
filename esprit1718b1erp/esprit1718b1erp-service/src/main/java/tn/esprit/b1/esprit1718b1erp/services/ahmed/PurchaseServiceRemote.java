package tn.esprit.b1.esprit1718b1erp.services.ahmed;

import javax.ejb.Remote;

import tn.esprit.b1.esprit1718b1erp.entities.Purchase;
import tn.esprit.b1.esprit1718b1erp.utilities.IGenericDAO;

@Remote
public interface PurchaseServiceRemote extends IGenericDAO<Purchase> {

}
