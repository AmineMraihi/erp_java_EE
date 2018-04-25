package tn.esprit.b1.esprit1718b1erp.services.shil;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.b1.esprit1718b1erp.entities.OrderCom;
import tn.esprit.b1.esprit1718b1erp.utilities.GenericDAO;

/**
 * Session Bean implementation class OrderComService
 */
@Stateless
@LocalBean
public class OrderComService extends GenericDAO<OrderCom> implements OrderComServiceRemote, OrderComServiceLocal {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Default constructor.
     */
    public OrderComService() {
        super(OrderCom.class);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
