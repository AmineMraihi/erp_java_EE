package tn.esprit.b1.esprit1718b1erp.services.shil;

import javax.ejb.Local;

import tn.esprit.b1.esprit1718b1erp.entities.Product;
import tn.esprit.b1.esprit1718b1erp.utilities.IGenericDAO;

@Local
public interface ProductServiceLocal extends IGenericDAO<Product> {

}
