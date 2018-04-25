package tn.esprit.b1.esprit1718b1erp.services.malek;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.b1.esprit1718b1erp.entities.Breakdown;
import tn.esprit.b1.esprit1718b1erp.utilities.GenericDAO;


/**
 * Session Bean implementation class BreakdownService
 */
@Stateless
public class BreakdownService extends GenericDAO<Breakdown> implements BreakdownServiceRemote, BreakdownServiceLocal {

    @PersistenceContext
    private EntityManager entityManager;

    public BreakdownService() {
        super(Breakdown.class);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}