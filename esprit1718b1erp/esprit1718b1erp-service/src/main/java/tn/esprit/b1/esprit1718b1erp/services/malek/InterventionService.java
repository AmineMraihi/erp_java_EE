package tn.esprit.b1.esprit1718b1erp.services.malek;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.b1.esprit1718b1erp.entities.Intervention;
import tn.esprit.b1.esprit1718b1erp.entities.Item;
import tn.esprit.b1.esprit1718b1erp.utilities.GenericDAO;

/**
 * Session Bean implementation class InterventionService
 */
@Stateless
@LocalBean
public class InterventionService extends GenericDAO<Intervention> implements InterventionServiceRemote, InterventionServiceLocal {

    @PersistenceContext
    private EntityManager entityManager;

    public InterventionService() {
        super(Intervention.class);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

   
   /* @Override
    public Intervention findById(Integer n) {
        TypedQuery<Intervention> query=entityManager.createQuery(
                "select c from Intervention c where c.id=:i",Intervention.class
                );
        query.setParameter("i", n);
        return query.getSingleResult();
    }*/
    @Override
    public List<Intervention> getInterventionList(Integer id) {
      
        
        
        TypedQuery<Intervention> query=entityManager.createQuery(
                "select c from Intervention c where c.item.id=:i",Intervention.class
                );        query.setParameter("i", id);
        return query.getResultList();
    }
    @Override
    public Intervention getIntervention(String id) {
        TypedQuery<Intervention> query=entityManager.createQuery(
                "select c from Intervention c where c.item.name=:i",Intervention.class
                );
        query.setParameter("i", id);
        return query.getSingleResult();
    }  
    
    public void deleteInterventionById(int i) {
        entityManager.remove(entityManager.find(Intervention.class, i));
    }
    
}
