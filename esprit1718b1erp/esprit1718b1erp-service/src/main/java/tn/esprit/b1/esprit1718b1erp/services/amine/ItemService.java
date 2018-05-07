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
@LocalBean
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
    public void addItemWithCategoryAndSupplier(Item i, Category c, Contact s, User u) {
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
        i.setSupplier(s);
        i.setCategory(c);
        i.setUser(u);
        entityManager.persist(i);
    }

    @Override
    public void updateItemWithCategoryAndSupplier(Item i, Category c, Contact s, User u) {
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

    public Long sumOfQuantities() {
        TypedQuery<Long> query = entityManager.createQuery("select SUM(x.quantity) from Item x ", Long.class);
        return query.getSingleResult();
    }

    public Category getCategoryById(int i) {
        return entityManager.find(Category.class, i);
    }

    public Contact getSupplierById(int i) {
        return entityManager.find(Contact.class, i);
    }

    public Item getItemById(int i) {
        return entityManager.find(Item.class, i);
    }

    public void deleteItemById(int i) {
        entityManager.remove(entityManager.find(Item.class, i));
    }

    public List<Item> getItemsByTierId(int cat) {

        TypedQuery<Item> query = entityManager.createQuery("select c from Item c where c.tier.id=:i", Item.class);
        query.setParameter("i", cat);
        return query.getResultList();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //////////////addded by ahmed////////
    public List<Double> Somme_Item_intheLast5Years() {
        /////DISTINCT year(durationguarantee),
        Query query = entityManager.createNativeQuery(
"SELECT ROUND(SUM(byingPrice),0) from item GROUP BY year(durationguarantee) ORDER BY year(durationguarantee) asc LIMIT 5");

        List<Double> result = query.getResultList();

        return result;
    }

    public List<Item> getItemsByDepotId(int i) {
        return entityManager.createNativeQuery(
                "SELECT DISTINCT * FROM item  " + "JOIN tier on item.tier_id=tier.id  "
                        + "JOIN row on tier.row_id=row.id  " + "JOIN depot on row.depot_id=depot.id WHERE depot.id=?",
                Item.class).setParameter(1, i).getResultList();

    }

    public BigInteger getNumberOfItemsByDepotId(int i) {
        return (BigInteger) entityManager.createNativeQuery(
                "SELECT count(*) FROM item  JOIN tier on item.tier_id=tier.id  JOIN row on tier.row_id=row.id  JOIN depot on row.depot_id=depot.id WHERE depot.id=?")
                .setParameter(1, i).getSingleResult();
    }

    public List<Item> getItemsOnAlert() {
        return entityManager.createNativeQuery(
                "select * from item where item.minimumQuanity>item.quantity",
                Item.class).getResultList();
    }

}
