package tn.esprit.b1.esprit1718b1erp.services.amine;

import java.math.BigInteger;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.b1.esprit1718b1erp.entities.Depot;
import tn.esprit.b1.esprit1718b1erp.entities.Item;
import tn.esprit.b1.esprit1718b1erp.entities.Row;
import tn.esprit.b1.esprit1718b1erp.utilities.GenericDAO;

/**
 * Session Bean implementation class RowService
 */
@Stateless
@LocalBean
public class RowService extends GenericDAO<Row> implements RowServiceRemote {

    @PersistenceContext
    private EntityManager entityManager;
    
    public RowService() {
        super(Row.class);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    public List<Row> getRowsByDepotId(int id){
        TypedQuery<Row> query = entityManager.createQuery("select r from Row r where r.depot.id=:i", Row.class);
        query.setParameter("i", id);
        return query.getResultList();
    }
    
    public BigInteger  getNumberOfRowsByDepotId(int i) {
       return (BigInteger) entityManager.createNativeQuery("select COUNT(*) from row WHERE row.depot_id=?").setParameter(1, i).getSingleResult();
    }
    

}
