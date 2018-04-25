package tn.esprit.b1.esprit1718b1erp.services.amine;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import javafx.collections.FXCollections;
import tn.esprit.b1.esprit1718b1erp.entities.Category;
import tn.esprit.b1.esprit1718b1erp.entities.Contact;
import tn.esprit.b1.esprit1718b1erp.entities.Item;
import tn.esprit.b1.esprit1718b1erp.entities.User;
import tn.esprit.b1.esprit1718b1erp.utilities.GenericDAO;

/**
 * Session Bean implementation class ItemService
 */
@Stateless
public class ItemService extends GenericDAO<Item> implements ItemServiceRemote, ItemServiceLocal {

    @PersistenceContext
    private EntityManager entityManager;

    public ItemService() {
        super(Item.class);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void addItemWithCategoryAndSupplier(Item i, Category c, Contact s,User u) {
        if (c.getId() != null) {
            entityManager.merge(c);
        } else {
            entityManager.persist(c);
        }
        if (s.getId() != null) {
            entityManager.merge(s);
        } else {
            entityManager.persist(s);
        }
//        if (u.getCode() != null) {
//            entityManager.merge(u);
//        } else {
//            entityManager.persist(u);
//        }
        // entityManager.find(Category.class, c.getId());
        // entityManager.find(Contact.class, s.getId());
        i.setSupplier(s);
        i.setCategory(c);
        i.setUser(u);
        entityManager.persist(i);
    }

    @Override
    public void updateItemWithCategoryAndSupplier(Item i, Category c, Contact s,User u) {
        if (c.getId() != null) {
            entityManager.merge(c);
        } else {
            entityManager.persist(c);
        }
        if (s.getId() != null) {
            entityManager.merge(s);
        } else {
            entityManager.persist(s);
        }
        
        System.out.println(u);
//        if (u.getCode()!= null) {
//            entityManager.merge(u);
//        } else {
//            entityManager.persist(u);
//        }
        // entityManager.find(Category.class, c.getId());
        // entityManager.find(Contact.class, s.getId());
        
        i.setUser(u);
        i.setCategory(c);
        i.setSupplier(s);
        entityManager.merge(i);

    }

    @Override
    public List<String> getItemNamesList() {
        List<String> listNames = new ArrayList<String>();
        listNames = entityManager.createQuery("select i.name from Item i", String.class).getResultList();
        return listNames;
    }

    @Override
    public List<Integer> getItemBarcodeList() {
        List<Integer> listBarcodes = new ArrayList<Integer>();
        listBarcodes = entityManager.createQuery("select i.barcode from Item i", Integer.class).getResultList();
        return listBarcodes;
    }

    @Override
    public void deleteItemWithCategoryAndSupplier(Item i) {
        entityManager.remove(entityManager.contains(i) ? i : entityManager.merge(i));
        i.setCategory(null);
        i.setSupplier(null);
        i.setUser(null);
        // entityManager.remove(i);

    }

    @Override
    public List<Item> getMachineList(String cat) {

        TypedQuery<Item> query = entityManager.createQuery("select c from Item c where c.category.name=:i", Item.class);
        query.setParameter("i", cat);
        return query.getResultList();
    }

    @Override
    public Item getMachine(String cat) {
        TypedQuery<Item> query = entityManager.createQuery("select c from Item c where c.category.name=:i", Item.class);
        query.setParameter("i", cat);
        return query.getSingleResult();
    }
    @Override
    public List<Item> ListStock(String cat) {

        TypedQuery<Item> query = entityManager.createQuery("select c from Item c where c.category.name=:i", Item.class);
        query.setParameter("i", cat);
        return query.getResultList();
    }

}
