package tn.esprit.b1.esprit1718b1erp.services.amine;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.b1.esprit1718b1erp.entities.Item;
import tn.esprit.b1.esprit1718b1erp.utilities.GenericDAO;

/**
 * Session Bean implementation class ItemService
 */
@Stateless
public class ItemService extends GenericDAO<Item> implements ItemServiceRemote, ItemServiceLocal {

    @PersistenceContext
    private EntityManager entityManager;
    
    public ItemService() {
        super(Item.class);
    }
    
    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    

}
