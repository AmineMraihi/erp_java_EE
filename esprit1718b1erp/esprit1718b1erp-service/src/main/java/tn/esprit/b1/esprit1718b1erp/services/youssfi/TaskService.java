package tn.esprit.b1.esprit1718b1erp.services.youssfi;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.b1.esprit1718b1erp.entities.Project;
import tn.esprit.b1.esprit1718b1erp.entities.Task;
import tn.esprit.b1.esprit1718b1erp.entities.User;
import tn.esprit.b1.esprit1718b1erp.utilities.GenericDAO;

@Stateless
@LocalBean
public class TaskService extends GenericDAO<Task> implements TaskServiceRemote{

    @PersistenceContext
    private EntityManager entityManager;
    
    public TaskService() {
        super(Task.class);
        
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Task> findtasksbyUser(Project project,User user) {
        TypedQuery<Task> query = entityManager
                .createQuery("select m from Task m  where( m.responsableTache=:responsable and m.project=:project ) ", Task.class);
        query.setParameter("responsable", user);
        query.setParameter("project", project);
        return query.getResultList();
        
    }
    

}
