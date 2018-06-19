package tn.esprit.b1.esprit1718b1erp.services.ahmed;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.Query;
import tn.esprit.b1.esprit1718b1erp.entities.Campaign;
import tn.esprit.b1.esprit1718b1erp.entities.Contact;
import tn.esprit.b1.esprit1718b1erp.entities.Item;
import tn.esprit.b1.esprit1718b1erp.entities.Needa;
import tn.esprit.b1.esprit1718b1erp.entities.Sale;
import tn.esprit.b1.esprit1718b1erp.entities.User;
import tn.esprit.b1.esprit1718b1erp.utilities.GenericDAO;

/**
 * Session Bean implementation class NeedService
 */
@Stateless
@LocalBean
public class NeedService extends GenericDAO<Needa> implements NeedServiceRemote, NeedServiceLocal {

    /**
     * Default constructor.
     */
    public NeedService() {
        super(Needa.class);
    }

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Default constructor.
     */

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


 
    
    
    @Override
    public Double SommeSalesiPhoneX(Integer i)   { 
        Double  B = (double) 0;
       try {
           Query query = entityManager.createQuery("SELECT DISTINCT SUM(u.somme) FROM Needa u WHERE MONTH(u.SaleDate)=:l and u.nom_prod=:p GROUP BY u.nom_prod");
           query.setParameter("l", i);
           query.setParameter("p", "iPhone X");
             B = (Double) query.getSingleResult();
            
              
    } catch (Exception e) {
       
    }
      
       return B;
       
    }

    @Override
    public Double SommeSalesiPhone8(Integer i) {
        Double  B = (double) 0;
        try {
            Query query = entityManager.createQuery("SELECT DISTINCT SUM(u.somme) FROM Needa u WHERE MONTH(u.SaleDate)=:l and u.nom_prod=:p GROUP BY u.nom_prod");
            query.setParameter("l", i);
            query.setParameter("p", "iPhone 8");
              B = (Double) query.getSingleResult();
             
               
     } catch (Exception e) {
         
     }
       
        return B;
    }

    
    
    @Override
    public Double SommeSalesiPhone8Plus(Integer i) {
        Double  B = (double) 0;
        try {
            Query query = entityManager.createQuery("SELECT DISTINCT SUM(u.somme) FROM Needa u WHERE MONTH(u.SaleDate)=:l and u.nom_prod=:p GROUP BY u.nom_prod");
            query.setParameter("l", i);
            query.setParameter("p", "iPhone 8 Plus");
              B = (Double) query.getSingleResult();
             
               
     } catch (Exception e) {
         
     }
       
        return B;
    }
    
    
    
    @Override
    public Double SommeSalesiPhone7(Integer i) {
        Double  B = (double) 0;
        try {
            Query query = entityManager.createQuery("SELECT DISTINCT SUM(u.somme) FROM Needa u WHERE MONTH(u.SaleDate)=:l and u.nom_prod=:p GROUP BY u.nom_prod");
            query.setParameter("l", i);
            query.setParameter("p", "iPhone 7");
              B = (Double) query.getSingleResult();
             
               
     } catch (Exception e) {
        
     }
       
        return B;
    }
    
    
    @Override
    public Map<String, Number> Need_somme() {
        Map<String, Number> results = new HashMap<String, Number>();
        ////// String jpaQuery = "SELECT p.product_id, SUM(s.Somme_products)
        ////// FROM sale s , sale_product p GROUP BY p.product_id ORDER BY
        ////// `SUM(s.Somme_products)` DESC";

        String jpaQuery = "SELECT DISTINCT nom_prod , SUM(somme) from needa GROUP BY nom_prod ORDER BY SUM(somme)";
        List<Object[]> resultList = entityManager.createNativeQuery(jpaQuery).getResultList();

        for (Object[] borderTypes : resultList) {
            results.put((String) borderTypes[0], (Number) borderTypes[1]);

        }
        return results;
    }
    

    public List<Double> Somme_Sales_inLast5Years() {
        //////DISTINCT year(SaleDate) 
        Query query = entityManager.createNativeQuery("SELECT ROUND(SUM(somme),0) from needa "
                + "GROUP BY year(SaleDate) ORDER BY year(SaleDate) asc  LIMIT 5");

        List<Double> result = query.getResultList();

        return result;
    }

}
