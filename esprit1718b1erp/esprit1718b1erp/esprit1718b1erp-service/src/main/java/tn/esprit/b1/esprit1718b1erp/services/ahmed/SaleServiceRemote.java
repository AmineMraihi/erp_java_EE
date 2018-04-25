package tn.esprit.b1.esprit1718b1erp.services.ahmed;

import java.util.Map;

import javax.ejb.Remote;

import tn.esprit.b1.esprit1718b1erp.entities.Contact;
import tn.esprit.b1.esprit1718b1erp.entities.Sale;
import tn.esprit.b1.esprit1718b1erp.utilities.IGenericDAO;

@Remote
public interface SaleServiceRemote extends IGenericDAO<Sale>{
    Map<String, Number> sommetot_sale();
    Double ContactSalesPerMonth(Integer i,Contact c);
}
