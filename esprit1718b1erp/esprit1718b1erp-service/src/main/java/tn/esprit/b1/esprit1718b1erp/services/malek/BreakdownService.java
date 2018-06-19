package tn.esprit.b1.esprit1718b1erp.services.malek;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.esprit.b1.esprit1718b1erp.entities.Breakdown;
import tn.esprit.b1.esprit1718b1erp.entities.Intervention;
import tn.esprit.b1.esprit1718b1erp.entities.Item;
import tn.esprit.b1.esprit1718b1erp.utilities.GenericDAO;


/**
 * Session Bean implementation class BreakdownService
 */
@Stateless
@LocalBean
public class BreakdownService extends GenericDAO<Breakdown> implements BreakdownServiceRemote, BreakdownServiceLocal {

    @PersistenceContext
    private EntityManager entityManager;

    public BreakdownService() {
        super(Breakdown.class);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public void deleteBreakdownById(int i) {
        entityManager.remove(entityManager.find(Breakdown.class, i));
    }
    @SuppressWarnings("unchecked")
    @Override
    public Map<Number, Number> sommetot_purchase() {
    	  Map<Number, Number> results = new HashMap<Number, Number>();
          ////// String jpaQuery = "SELECT p.product_id, SUM(s.Somme_products)
          ////// FROM sale s , sale_product p GROUP BY p.product_id ORDER BY
          ////// `SUM(s.Somme_products)` DESC";

          String jpaQuery = "SELECT g.id, SUM(s.byingPrice) FROM item s , item_for_breakdown p ,breakdown g "
          		+ "WHERE g.id=(select g.id from breakdown where g.id=p.breakdown_id limit 1) "
          		+ "AND s.byingPrice=(select s.byingPrice from item where s.id=p.item_id limit 1)"
          		+ " GROUP BY g.id ORDER BY `SUM(s.byingPrice)` DESC ";
          List<Object[]> resultList = entityManager.createNativeQuery(jpaQuery).getResultList();

          for (Object[] borderTypes : resultList) {
              results.put((Number) borderTypes[0], (Number) borderTypes[1]);

          }
          return results;
}
    
    @Override
    public BigInteger itemBreakdownPerMonth(Integer i, Item c) {
    	BigInteger s ;
        Query query = entityManager.createNativeQuery(
                    "SELECT COUNT(*) FROM breakdown u WHERE MONTH(u.breakdowndate)=:l and u.objecttomaintain_id=:p ");
            query.setParameter("l", i);
            query.setParameter("p", c);

            s = (BigInteger) query.getSingleResult();


        return s;
    }
    
    @Override
    public  Map<String, Number> itemBreakdownCost() {
  	  Map<String, Number> results = new HashMap<String, Number>();

  	String jpaQuery="SELECT i.name ,SUM(b.price) FROM breakdown b , item i "
  			+ "WHERE i.name=(SELECT i.name FROM item WHERE i.id=b.objecttomaintain_id LIMIT 1)"
  			+ " GROUP BY b.objecttomaintain_id ORDER BY `SUM(b.price)` DESC  ";
  	 List<Object[]> resultList = entityManager.createNativeQuery(jpaQuery).getResultList();

     for (Object[] borderTypes : resultList) {
         results.put((String) borderTypes[0], (Number) borderTypes[1]);

     }
     return results;
    }
    
}