package tn.esprit.b1.esprit1718b1erp.services.jassem;

import javax.ejb.Local;

import tn.esprit.b1.esprit1718b1erp.entities.Category;
import tn.esprit.b1.esprit1718b1erp.entities.Contact;
import tn.esprit.b1.esprit1718b1erp.utilities.IGenericDAO;

@Local
public interface ContactServiceLocal extends IGenericDAO<Contact> {

}
