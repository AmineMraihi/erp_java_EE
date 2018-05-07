package tn.esprit.b1.esprit1718b1erp.services.ahmed;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.b1.esprit1718b1erp.entities.Intangibles;
import tn.esprit.b1.esprit1718b1erp.utilities.GenericDAO;

/**
 * Session Bean implementation class IntangiblesService
 */
@Stateless
@LocalBean
public class IntangiblesService extends GenericDAO<Intangibles> implements IntangiblesServiceRemote, IntangiblesServiceLocal {

    @PersistenceContext
    private EntityManager entityManager;
    
    
    public IntangiblesService() {
        super(Intangibles.class);
    }
    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    
    
    public List<Double> Somme_Pur_Itagibles_in_Last5Years() {
        /////DISTINCT year(dateDemande) ,
        Query query = entityManager.createNativeQuery(
                "SELECT ROUND (SUM(Somme),0) from intangibles GROUP BY year(dateIntagible) ORDER BY year(dateIntagible) asc LIMIT 5");

        List<Double> result = query.getResultList();

        return result;
    }
}
