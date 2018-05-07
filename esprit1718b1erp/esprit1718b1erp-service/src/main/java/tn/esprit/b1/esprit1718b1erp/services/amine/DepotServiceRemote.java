package tn.esprit.b1.esprit1718b1erp.services.amine;

import javax.ejb.Remote;

import tn.esprit.b1.esprit1718b1erp.entities.Category;
import tn.esprit.b1.esprit1718b1erp.entities.Depot;
import tn.esprit.b1.esprit1718b1erp.utilities.IGenericDAO;

@Remote
public interface DepotServiceRemote extends IGenericDAO<Depot> {

}
