package tn.esprit.b1.esprit1718b1erp.services.ahmed;

import java.math.BigDecimal;
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
import tn.esprit.b1.esprit1718b1erp.entities.Intervention;
import tn.esprit.b1.esprit1718b1erp.entities.Item;
import tn.esprit.b1.esprit1718b1erp.entities.ItemOffer;
import tn.esprit.b1.esprit1718b1erp.entities.Product;
import tn.esprit.b1.esprit1718b1erp.entities.Purchase;
import tn.esprit.b1.esprit1718b1erp.utilities.GenericDAO;

/**
 * Session Bean implementation class PurchaseService
 */
@Stateless
@LocalBean
public class PurchaseService extends GenericDAO<Purchase> implements PurchaseServiceRemote, PurchaseServiceLocal {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Default constructor.
     */
    public PurchaseService() {
        super(Purchase.class);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }



    @Override
    public List<Purchase> aaaa() {
        Query query = entityManager.createNativeQuery(
                "SELECT product_Id_Product FROM purchase GROUP BY product_Id_Product ORDER BY `product_Id_Product` DESC");

        List<Purchase> result = query.getResultList();

        return result;
    }

    @Override
    public Double ContactPurchasesPerMonth(Integer i, Contact c) {
        Double s = (double) 0;
        try {
            Query query = entityManager.createQuery(
                    "SELECT SUM(u.Somme) FROM Purchase u WHERE MONTH(u.dateRecu)=:l and u.contact=:p GROUP BY u.contact");
            query.setParameter("l", i);
            query.setParameter("p", c);
            s = (Double) query.getSingleResult();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return s;
    }

    @Override
    public List<Item> getlistItem(int i) {
        // TODO Auto-generated method stub
        return null;
    }

    // List<String> departementNames = em
    // .createQuery("select d.name from Departement d where
    // d.entreprise.id=:entrepriseId", String.class)
    // .setParameter("entrepriseId", i).getResultList();
    // return departementNames;

    //// SELECT DISTINCT product_Id_Product ,SUM(Quantite)FROM purchase GROUP BY
    //// product_Id_Product ORDER BY `SUM(Quantite)` DESC
    
    
    public Contact getSupplierById(int i) {
        return entityManager.find(Contact.class, i);
    }
    public Product getProductbyID(int i) {
        return entityManager.find(Product.class, i);
    }
    public void deletePurchase(int i) {
        entityManager.remove(entityManager.find(Purchase.class, i));
    }
    
    
    @SuppressWarnings("unchecked")
    public Map<String, Number> sommetot_purchase() {
        Map<String, Number> results = new HashMap<String, Number>();
        ////////// String jpaQuery = "SELECT DISTINCT product_Id_Product
        ////////// ,SUM(Quantite)FROM purchase GROUP BY product_Id_Product ORDER
        ////////// BY `SUM(Quantite)` DESC LIMIT 5";

        String jpaQuery = "SELECT DISTINCT g.nomProduit ,SUM(p.Somme)FROM purchase p ,product g"
                + " WHERE g.nomProduit=(select g.nomProduit from product where g.Id_Product=p.product_Id_Product limit 1) GROUP BY g.nomProduit ORDER BY `SUM(p.Somme)`";
        List<Object[]> resultList = entityManager.createNativeQuery(jpaQuery).getResultList();

        for (Object[] borderTypes : resultList) {
            results.put((String) borderTypes[0], (Number) borderTypes[1]);
        }
        return results;
    }
    
    
    public List<Double> Somme_Pur_intheLast5Years() {
        /////DISTINCT year(dateDemande) ,
        Query query = entityManager.createNativeQuery(
                "SELECT ROUND(SUM(somme),0) from purchase GROUP BY "
                + "year(dateDemande) ORDER BY year(dateDemande) asc  LIMIT 5");

        List<Double> result = query.getResultList();

        return result;
    }
}
