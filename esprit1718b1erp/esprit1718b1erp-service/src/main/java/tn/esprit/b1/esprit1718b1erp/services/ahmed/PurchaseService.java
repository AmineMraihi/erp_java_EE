package tn.esprit.b1.esprit1718b1erp.services.ahmed;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.b1.esprit1718b1erp.entities.Category;
import tn.esprit.b1.esprit1718b1erp.entities.ItemRequest;
import tn.esprit.b1.esprit1718b1erp.entities.Purchase;
import tn.esprit.b1.esprit1718b1erp.utilities.GenericDAO;

/**
 * Session Bean implementation class PurchaseService
 */
@Stateless
@LocalBean
public class PurchaseService extends GenericDAO<Purchase> implements PurchaseServiceRemote, PurchaseServiceLocal {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Default constructor.
     */
    public PurchaseService() {
        super(Purchase.class);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

}
