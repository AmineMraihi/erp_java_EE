package tn.esprit.b1.esprit1718b1erp.services.shil;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.b1.esprit1718b1erp.entities.SaleOpportunity;
import tn.esprit.b1.esprit1718b1erp.utilities.GenericDAO;

/**
 * Session Bean implementation class SaleOpportunityService
 */
@Stateless
@LocalBean
public class SaleOpportunityService extends GenericDAO<SaleOpportunity> implements SaleOpportunityServiceRemote, SaleOpportunityServiceLocal {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Default constructor.
     */
    public SaleOpportunityService() {
        super(SaleOpportunity.class);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
