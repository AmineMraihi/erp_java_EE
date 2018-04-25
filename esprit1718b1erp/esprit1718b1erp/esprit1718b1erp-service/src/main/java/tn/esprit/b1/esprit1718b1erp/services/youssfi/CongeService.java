package tn.esprit.b1.esprit1718b1erp.services.youssfi;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.b1.esprit1718b1erp.entities.Conge;
import tn.esprit.b1.esprit1718b1erp.entities.Project;
import tn.esprit.b1.esprit1718b1erp.entities.User;
import tn.esprit.b1.esprit1718b1erp.utilities.GenericDAO;

@Stateless
@LocalBean
public class CongeService extends GenericDAO<Conge> implements CongeServiceRemote{
    
    

    @PersistenceContext
    private EntityManager entityManager;
    
    public CongeService() {
        super(Conge.class);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Conge> findByEmployee(User user) {
        TypedQuery<Conge> query = entityManager.createQuery("select m from Conge m where m.employee=:employee ",
                Conge.class);
        query.setParameter("employee", user);
        return query.getResultList();
    }

    @Override
    public List<Conge> findByEtat(int i) {
        TypedQuery<Conge> query = entityManager.createQuery("select m from Conge m where m.confirmed=:confirmed ",
                Conge.class);
        query.setParameter("confirmed", i);
        return query.getResultList();
    }
    
    
}
