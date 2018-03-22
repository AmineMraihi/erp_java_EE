package tn.esprit.b1.esprit1718b1erp.services.jassem;

import javax.ejb.Remote;

import tn.esprit.b1.esprit1718b1erp.entities.Category;
import tn.esprit.b1.esprit1718b1erp.entities.Contact;
import tn.esprit.b1.esprit1718b1erp.utilities.IGenericDAO;

@Remote
public interface ContactServiceRemote extends IGenericDAO<Contact> {

}
