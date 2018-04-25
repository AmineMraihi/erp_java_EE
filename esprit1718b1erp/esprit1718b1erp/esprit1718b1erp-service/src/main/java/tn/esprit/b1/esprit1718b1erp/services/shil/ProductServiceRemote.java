package tn.esprit.b1.esprit1718b1erp.services.shil;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.b1.esprit1718b1erp.entities.Product;
import tn.esprit.b1.esprit1718b1erp.utilities.IGenericDAO;

@Remote
public interface ProductServiceRemote extends IGenericDAO<Product>{
List <String> productNames () ;
List <Product> findByName(String n);
List <Product> findWithoutProject();
}
