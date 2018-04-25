package tn.esprit.b1.esprit1718b1erp.services.malek;

import javax.ejb.Remote;

import tn.esprit.b1.esprit1718b1erp.entities.Breakdown;
import tn.esprit.b1.esprit1718b1erp.utilities.IGenericDAO;

@Remote
public interface BreakdownServiceRemote extends IGenericDAO<Breakdown>{

}
