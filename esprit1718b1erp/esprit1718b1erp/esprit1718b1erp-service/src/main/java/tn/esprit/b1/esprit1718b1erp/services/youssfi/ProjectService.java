package tn.esprit.b1.esprit1718b1erp.services.youssfi;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.b1.esprit1718b1erp.entities.Entreprise;
import tn.esprit.b1.esprit1718b1erp.entities.Project;
import tn.esprit.b1.esprit1718b1erp.entities.StateProject;
import tn.esprit.b1.esprit1718b1erp.entities.User;
import tn.esprit.b1.esprit1718b1erp.utilities.GenericDAO;

/**
 * Session Bean implementation class ProjectService
 */
@Stateful
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

}
