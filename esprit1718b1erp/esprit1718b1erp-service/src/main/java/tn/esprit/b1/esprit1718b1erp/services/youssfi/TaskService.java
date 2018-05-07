package tn.esprit.b1.esprit1718b1erp.services.youssfi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.esprit.b1.esprit1718b1erp.entities.Contact;
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
   
    
    
    
    
    
    
    
    @SuppressWarnings("unchecked") 
    public Map<String, Number> Somme_TimeSpend_OnProject() {
        Map<String, Number> results = new HashMap<String, Number>();
 

        String jpaQuery = "SELECT p.projectName , SUM(DATEDIFF(t.dateFin, t.dateDebut)) FROM task t ,project p"
                + " WHERE p.projectName=(select p.projectName from project where p.id=t.idProject limit 1) GROUP BY p.projectName Limit 2";
       
        List<Object[]> resultList = entityManager.createNativeQuery(jpaQuery).getResultList();

        for (Object[] borderTypes : resultList) {
            results.put((String) borderTypes[0], (Number) borderTypes[1]);
        }
        return results;
    }
    
    
    @SuppressWarnings("unchecked") 
    public Map<String, Number> Somme_Task_projectName() {
        Map<String, Number> results = new HashMap<String, Number>();
 

        String jpaQuery = "SELECT p.projectName ,SUM(t.somme_task) FROM task t ,project p WHERE"
                + " p.projectName=(select p.projectName from project where p.id=t.idProject limit 1) GROUP BY p.projectName Limit 2";
       
        List<Object[]> resultList = entityManager.createNativeQuery(jpaQuery).getResultList();

        for (Object[] borderTypes : resultList) {
            results.put((String) borderTypes[0], (Number) borderTypes[1]);
        }
        return results;
    }
    
    
   
    

}
