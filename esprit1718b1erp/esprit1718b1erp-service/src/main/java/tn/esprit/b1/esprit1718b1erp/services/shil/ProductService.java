package tn.esprit.b1.esprit1718b1erp.services.shil;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.esprit.b1.esprit1718b1erp.entities.Product;
import tn.esprit.b1.esprit1718b1erp.entities.Report;
import tn.esprit.b1.esprit1718b1erp.utilities.GenericDAO;

/**
 * Session Bean implementation class ProductService
 */
@Stateless
@LocalBean
public class ProductService extends GenericDAO<Product> implements ProductServiceRemote, ProductServiceLocal {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Default constructor.
     */
    public ProductService() {
        super(Product.class);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<String> productNames() {
        TypedQuery<String> query=entityManager.createQuery(
                "select c.nomProduit from Product c",String.class
                );        
        return query.getResultList();

    }

    @Override
    public List<Product> findByName(String n) {
        TypedQuery<Product> query=entityManager.createQuery(
                "select c from product c where c.nomProduit=:i",Product.class
                );        query.setParameter("i", n);
        return query.getResultList();

    }

    @Override
    public List<Product> findWithoutProject() {
        TypedQuery<Product> query=entityManager.createQuery(
                "select c from Product c where c.dateCreation=:i",Product.class
                );        query.setParameter("i", null);
        return query.getResultList();
        
    }

    
    
    
    
    public List<Double> Somme_ProductPrix_InStock() {
        /////DISTINCT year(dateDemande) ,
        Query query = entityManager.createNativeQuery(
                "SELECT ROUND(SUM(prixQuantite),0) from product GROUP BY year(dateCreation)"
                + " ORDER by year(dateCreation) asc LIMIT 5");

        List<Double> result = query.getResultList();

        return result;
    }
}
