package tn.esprit.b1.esprit1718b1erp.services.amine;

import javax.ejb.Local;

import tn.esprit.b1.esprit1718b1erp.entities.ItemRequest;
import tn.esprit.b1.esprit1718b1erp.utilities.IGenericDAO;

@Local
public interface ItemRequestServiceLocal extends IGenericDAO<ItemRequest> {

}
