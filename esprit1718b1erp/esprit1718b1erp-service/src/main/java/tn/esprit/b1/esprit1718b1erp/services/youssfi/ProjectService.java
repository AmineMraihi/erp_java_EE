package tn.esprit.b1.esprit1718b1erp.services.youssfi;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.b1.esprit1718b1erp.entities.Project;
import tn.esprit.b1.esprit1718b1erp.entities.Purchase;
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

}
