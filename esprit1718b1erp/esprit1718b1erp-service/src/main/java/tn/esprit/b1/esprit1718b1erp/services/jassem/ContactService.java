package tn.esprit.b1.esprit1718b1erp.services.jassem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import javafx.collections.ObservableList;
import tn.esprit.b1.esprit1718b1erp.entities.Contact;
import tn.esprit.b1.esprit1718b1erp.entities.Entreprise;
import tn.esprit.b1.esprit1718b1erp.entities.Intervention;
import tn.esprit.b1.esprit1718b1erp.entities.Particular;
import tn.esprit.b1.esprit1718b1erp.entities.Product;
import tn.esprit.b1.esprit1718b1erp.utilities.GenericDAO;

/**
 * Session Bean implementation class ContactService
 */
@Stateless
@LocalBean
public class ContactService extends GenericDAO<Contact> implements ContactServiceRemote, ContactServiceLocal {

    @PersistenceContext
    private EntityManager entityManager;

    public ContactService() {
        super(Contact.class);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Entreprise findCompanyByname(String name) {
        try {
            return entityManager.createQuery("SELECT e FROM Entreprise e WHERE e.name  =?", Entreprise.class)
                    .setParameter(1, name).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<String> findAllCompaniesNames() {

        List<String> companies = new ArrayList<String>();

        companies.addAll(entityManager.createQuery("SELECT e.name FROM Entreprise e", String.class).getResultList());
        return companies;

    }

    public List<Particular> VerifierEntreprise(Entreprise e) {
        List<Particular> particulars = new ArrayList<Particular>();

        particulars.addAll(entityManager.createQuery("SELECT p FROM Particular p WHERE p.company = ?", Particular.class)
                .setParameter(1, e).getResultList());
        /*
         * if(particulars.equals(null)) { return true; }else { return false; }
         */
        return particulars;
    }

    @Override
    public List<String> findAllParticularsNames() {
        List<String> particulars = new ArrayList<String>();

        particulars.addAll(entityManager.createQuery("SELECT CONCAT(p.name,' ',p.first_name) FROM Particular p", String.class).getResultList());
        return particulars;
    }

    @Override
    public Particular findParticularByNameFirstName(String NFirstName) {
        try {
            return entityManager.createQuery("SELECT p FROM Particular p WHERE CONCAT(p.name,' ',p.first_name)=?", Particular.class)
                    .setParameter(1, NFirstName).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Particular> findAllParticular() {
        List<Particular> particulars = new ArrayList<Particular>();

        particulars.addAll(entityManager.createQuery("SELECT p FROM Particular p", Particular.class).getResultList());
        return particulars;
    }

    @Override
    public List<Entreprise> findAllCompanies() {
        List<Entreprise> companies = new ArrayList<Entreprise>();

        companies.addAll(entityManager.createQuery("SELECT e FROM Entreprise e", Entreprise.class).getResultList());
        return companies;
    }

    @Override
    public Integer findSuggestionForProduct(Product prod) {
       Integer bestContactId;

        String myQuery = "SELECT DISTINCT(id) FROM contact JOIN sale ON contact.id=sale.contact_id JOIN"+
        " sale_product ON sale.Id_Sale=sale_product.sale_id JOIN product ON sale_product.product_id=product.Id_Product"+
                " WHERE type=? AND Somme_products=(SELECT MAX(sale.Somme_products) FROM sale)";
        
       bestContactId=(Integer) entityManager.createNativeQuery(myQuery).setParameter(1,prod.getType()).getSingleResult();
       
        return bestContactId;
    }

}
