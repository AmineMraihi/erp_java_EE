package tn.esprit.b1.esprit1718b1erp.services.amine;

import javax.ejb.Local;

import tn.esprit.b1.esprit1718b1erp.entities.Category;
import tn.esprit.b1.esprit1718b1erp.utilities.IGenericDAO;

@Local
public interface CategoryServiceLocal extends IGenericDAO<Category> {

}
