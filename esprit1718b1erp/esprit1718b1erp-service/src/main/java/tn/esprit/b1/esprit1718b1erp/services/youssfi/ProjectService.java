package tn.esprit.b1.esprit1718b1erp.services.youssfi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.esprit.b1.esprit1718b1erp.entities.Contact;
import tn.esprit.b1.esprit1718b1erp.entities.Entreprise;
import tn.esprit.b1.esprit1718b1erp.entities.Product;
import tn.esprit.b1.esprit1718b1erp.entities.Project;
import tn.esprit.b1.esprit1718b1erp.entities.StateProject;
import tn.esprit.b1.esprit1718b1erp.entities.User;
import tn.esprit.b1.esprit1718b1erp.utilities.GenericDAO;

/**
 * Session Bean implementation class ProjectService
 */
@Stateless
@LocalBean
public class ProjectService extends GenericDAO<Project> implements ProjectServiceRemote, ProjectServiceLocal {

    /**
     * Default constructor.
     */

    @PersistenceContext
    private EntityManager entityManager;

    public ProjectService() {
        super(Project.class);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Project> findByStateProject(StateProject stateProject) {
        // TODO Auto-generated method stub
        TypedQuery<Project> query = entityManager.createQuery("select m from Project m where m.etat=:etat ",
                Project.class);
        query.setParameter("etat", stateProject);
        return query.getResultList();
    }

    @Override
    public Project findResponsablesProjects(User code) {

        TypedQuery<Project> query = entityManager
                .createQuery("select m from Project m join m.responsable u where u.code=:responsable ", Project.class);
        query.setParameter("responsable", code.getCode());
        return query.getSingleResult();
    }

    @Override
    public Project findProjectByName(String name) {
        try {
            return entityManager.createQuery("SELECT p FROM Project p WHERE p.projectName  =?", Project.class)
                    .setParameter(1, name).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<String> findAllProjectsNames() {
        List<String> projects = new ArrayList<String>();

        projects.addAll(entityManager.createQuery("SELECT p.projectName FROM Project p", String.class).getResultList());
        return projects;
    }

    @Override
    public Long countProjects() {
        TypedQuery<Long> query = entityManager
                .createQuery("select COUNT(m) from Project m", Long.class);
        return query.getSingleResult();        
    }

    @Override
    public Long countProgressProjects() {
        TypedQuery<Long> query = entityManager
                .createQuery("select COUNT(m) from Project m where m.etat=:etat", Long.class);
        query.setParameter("etat", StateProject.IN_PROGRESS);
        return query.getSingleResult();       
    }

    @Override
    public Long countFinishedProjects() {
        TypedQuery<Long> query = entityManager
                .createQuery("select COUNT(m) from Project m where m.etat=:etat", Long.class);
        query.setParameter("etat", StateProject.FINISHED);
        return query.getSingleResult();  
    }

    @Override
    public Long countInterruptedProjects() {
        TypedQuery<Long> query = entityManager
                .createQuery("select COUNT(m) from Project m where m.etat=:etat", Long.class);
        query.setParameter("etat", StateProject.INTERRUPTED);
        return query.getSingleResult();  
    }

    @Override
    public List<Long> numberProjectsByMonth() {
        TypedQuery<Long> query = entityManager
                .createQuery("select COUNT(m) from Project m group by MONTH(m.creationDate)", Long.class);
        
        return query.getResultList();
    }
    @Override
    public Long ProjectPerMonth(Integer i) {
        Long s = (long) 0;
        try {
            Query query = entityManager.createQuery(
                    "select COUNT(m) from Project m where MONTH(m.startDate)=:l ");
            query.setParameter("l", i);
            s = (Long) query.getSingleResult();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return s;
    }
    @Override
    public Map<String, Long> projectsBymonth(){
        TypedQuery<Long> query = entityManager
                .createQuery("select COUNT(m) from Project m group by MONTH(m.creationDate)", Long.class);
        List<String> names = Arrays.asList("January","February","Mars","April");
        List<Long> things = query.getResultList();
        Map<String,Long> map = new HashMap<String, Long>();  // ordered

        for (int i=0; i<names.size(); i++) {
           
                map.put(names.get(i), things.get(i));
           
        }

        System.out.println(map);
        return map;
      }
    
    @Override
    public Product getProductById(int id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public Date ClosestProject() {
        TypedQuery<Date> query = entityManager
                .createQuery("select MIN(m.finDate) from Project m where m.etat=:etat", Date.class);
        query.setParameter("etat", StateProject.IN_PROGRESS);
        return query.getSingleResult();  
        
    }
    @Override
    public Project findByDate(Date date){
      return (Project) entityManager
                .createNativeQuery("select * from project  where finDate=? LIMIT 1",Project.class).setParameter(1, date).getSingleResult();
    }

    @Override
    public Double SommeBudgets() {
        TypedQuery<Double> query = entityManager
                .createQuery("select SUM(m.bugdet) from Project m", Double.class);
        return query.getSingleResult();
        
    }

}
