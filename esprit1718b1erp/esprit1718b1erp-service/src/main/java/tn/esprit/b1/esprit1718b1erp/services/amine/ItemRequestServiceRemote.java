package tn.esprit.b1.esprit1718b1erp.services.amine;

import javax.ejb.Remote;

import tn.esprit.b1.esprit1718b1erp.entities.ItemRequest;
import tn.esprit.b1.esprit1718b1erp.utilities.IGenericDAO;

@Remote
public interface ItemRequestServiceRemote extends IGenericDAO<ItemRequest> {

}
