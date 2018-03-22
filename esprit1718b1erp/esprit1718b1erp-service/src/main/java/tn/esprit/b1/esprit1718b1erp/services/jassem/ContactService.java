package tn.esprit.b1.esprit1718b1erp.services.jassem;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.b1.esprit1718b1erp.entities.Contact;
import tn.esprit.b1.esprit1718b1erp.utilities.GenericDAO;

/**
 * Session Bean implementation class ContactService
 */
@Stateless
@LocalBean
public class ContactService extends GenericDAO<Contact> implements ContactServiceRemote, ContactServiceLocal {

    @PersistenceContext
    private EntityManager entityManager;

    public ContactService() {
        super(Contact.class);
    }
    
    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
   
}
