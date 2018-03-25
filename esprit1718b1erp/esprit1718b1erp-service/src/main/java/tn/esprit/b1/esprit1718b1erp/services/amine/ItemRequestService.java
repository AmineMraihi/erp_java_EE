package tn.esprit.b1.esprit1718b1erp.services.amine;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.b1.esprit1718b1erp.entities.ItemRequest;
import tn.esprit.b1.esprit1718b1erp.utilities.GenericDAO;

/**
 * Session Bean implementation class ItemRequest
 */
@Stateless
public class ItemRequestService extends GenericDAO<ItemRequest> implements ItemRequestServiceRemote, ItemRequestServiceLocal {

    @PersistenceContext
    private EntityManager entityManager;

    public ItemRequestService() {
        super(ItemRequest.class);
    }
    
    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public ItemRequest iRExist(int i) {
        TypedQuery<ItemRequest> query=entityManager.createQuery(
                "select c from ItemRequest c where c.item.id=:i",ItemRequest.class
                );
        query.setParameter("i", i);
        return query.getSingleResult();
    }

}
