package tn.esprit.b1.esprit1718b1erp.services.amine;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.b1.esprit1718b1erp.entities.Category;
import tn.esprit.b1.esprit1718b1erp.entities.Depot;
import tn.esprit.b1.esprit1718b1erp.utilities.GenericDAO;

/**
 * Session Bean implementation class DepotService
 */
@Stateless
@LocalBean
public class DepotService extends GenericDAO<Depot> implements DepotServiceRemote {

    @PersistenceContext
    private EntityManager entityManager;
    
    public DepotService() {
        super(Depot.class);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    

}
