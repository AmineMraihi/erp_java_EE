package tn.esprit.b1.esprit1718b1erp.services.shil;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.b1.esprit1718b1erp.entities.ItemRequest;
import tn.esprit.b1.esprit1718b1erp.entities.Project;
import tn.esprit.b1.esprit1718b1erp.entities.Report;
import tn.esprit.b1.esprit1718b1erp.utilities.GenericDAO;

/**
 * Session Bean implementation class SaleOpportunityService
 */
@Stateless
@LocalBean
public class ReportService extends GenericDAO<Report> implements ReportServiceRemote, ReportServiceLocal {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Default constructor.
     */
    public ReportService() {
        super(Report.class);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Report> findByDescription(String s) {
        TypedQuery<Report> query=entityManager.createQuery(
                "select c from Report c where c.descrpiton=:i",Report.class
                );        query.setParameter("i", s);
        return query.getResultList();
    }
}
