package tn.esprit.b1.esprit1718b1erp.services.amine;

import javax.ejb.Remote;

import tn.esprit.b1.esprit1718b1erp.entities.Item;
import tn.esprit.b1.esprit1718b1erp.utilities.IGenericDAO;

@Remote
public interface ItemServiceRemote extends IGenericDAO<Item> {

}
