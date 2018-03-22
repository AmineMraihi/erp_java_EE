package tn.esprit.b1.esprit1718b1erp.services.amine;

import javax.ejb.Local;

import tn.esprit.b1.esprit1718b1erp.entities.Item;
import tn.esprit.b1.esprit1718b1erp.utilities.IGenericDAO;

@Local
public interface ItemServiceLocal extends IGenericDAO<Item> {

}
