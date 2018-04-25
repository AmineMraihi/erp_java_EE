package tn.esprit.b1.esprit1718b1erp.services.ahmed;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.b1.esprit1718b1erp.entities.Contact;
import tn.esprit.b1.esprit1718b1erp.entities.Sale;
import tn.esprit.b1.esprit1718b1erp.utilities.GenericDAO;

/**
 * Session Bean implementation class SaleService
 */
@Stateless
@LocalBean
public class SaleService extends GenericDAO<Sale> implements SaleServiceRemote, SaleServiceLocal {
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Default constructor.
     */
    public SaleService() {
        super(Sale.class);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Map<String, Number> sommetot_sale() {
        Map<String, Number> results = new HashMap<String, Number>();
        ////// String jpaQuery = "SELECT p.product_id, SUM(s.Somme_products)
        ////// FROM sale s , sale_product p GROUP BY p.product_id ORDER BY
        ////// `SUM(s.Somme_products)` DESC";

        String jpaQuery = "SELECT g.nomProduit, SUM(s.Somme_products) FROM sale s , sale_product p ,product g WHERE g.nomProduit=(select g.nomProduit from"
                + " product where g.Id_Product=p.product_id limit 1) GROUP BY g.nomProduit ORDER BY `SUM(s.Somme_products)` DESC";
        List<Object[]> resultList = entityManager.createNativeQuery(jpaQuery).getResultList();

        for (Object[] borderTypes : resultList) {
            results.put((String) borderTypes[0], (Number) borderTypes[1]);

        }
        return results;
    }

    @Override
    public Double ContactSalesPerMonth(Integer i, Contact c) {
        Double s = (double) 0;
        try {
            Query query = entityManager.createQuery(
                    "SELECT SUM(u.Somme_products) FROM Sale u WHERE MONTH(u.dateSale)=:l and u.contact=:p GROUP BY u.contact");
            query.setParameter("l", i);
            query.setParameter("p", c);
            s = (Double) query.getSingleResult();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return s;
    }
}
