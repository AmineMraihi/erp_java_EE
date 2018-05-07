package tn.esprit.b1.esprit1718b1erp.services.amine;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.esprit.b1.esprit1718b1erp.entities.Depot;
import tn.esprit.b1.esprit1718b1erp.entities.Row;
import tn.esprit.b1.esprit1718b1erp.entities.Tier;
import tn.esprit.b1.esprit1718b1erp.utilities.GenericDAO;

/**
 * Session Bean implementation class TierService
 */
@Stateless
@LocalBean
public class TierService extends GenericDAO<Tier> implements TierServiceRemote {

    @PersistenceContext
    private EntityManager entityManager;

    public TierService() {
        super(Tier.class);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Tier> gettiersByRowId(int id) {
        TypedQuery<Tier> query = entityManager.createQuery("select r from Tier r where r.row.id=:i", Tier.class);
        query.setParameter("i", id);
        return query.getResultList();
    }

    public List<Tier> gettiersByRowIdForAdd(int id) {
        List<Integer> query = entityManager.createNativeQuery(
                "SELECT tier.id FROM `tier` left join item on tier.id = item.tier_id where item.tier_id is null and tier.row_id="
                        + id)
                .getResultList();
        List<Tier> finalList = new ArrayList<>();
        for (Integer i : query) {
            finalList.add(find(i));
        }
        return finalList;
    }
    
    public BigInteger  getNumberOfTiersByDepotId(int i) {
        return (BigInteger) entityManager.createNativeQuery("select COUNT(*) from tier left join row on tier.row_id=row.id left join depot on depot.id=row.depot_id where depot.id=?").setParameter(1, i).getSingleResult();
     }

}
