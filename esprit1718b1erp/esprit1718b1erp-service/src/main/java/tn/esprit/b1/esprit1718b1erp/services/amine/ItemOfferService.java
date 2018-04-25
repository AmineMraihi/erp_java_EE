package tn.esprit.b1.esprit1718b1erp.services.amine;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.esprit.b1.esprit1718b1erp.entities.Item;
import tn.esprit.b1.esprit1718b1erp.entities.ItemOffer;
import tn.esprit.b1.esprit1718b1erp.entities.ItemRequest;
import tn.esprit.b1.esprit1718b1erp.entities.ItemRequestStatus;
import tn.esprit.b1.esprit1718b1erp.utilities.GenericDAO;

/**
 * Session Bean implementation class ItemOfferService
 */
@Stateless
@LocalBean
public class ItemOfferService extends GenericDAO<ItemOffer> implements ItemOfferServiceRemote, ItemOfferServiceLocal {

    /**
     * Default constructor.
     */
    public ItemOfferService() {
        super(ItemOffer.class);
    }

    @PersistenceContext
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void deleteItemOffersByItemId(int i) {
        Query query = entityManager.createQuery("delete from ItemOffer c where c.item.id=:i");
        query.setParameter("i", i).executeUpdate();

    }

    @Override
    public List<ItemOffer> getItemOffersByItem(int i) {
        TypedQuery<ItemOffer> query = entityManager.createQuery("select c from ItemOffer c where c.item.id=:i",
                ItemOffer.class);
        query.setParameter("i", i);
        return query.getResultList();
    }

    @Override
    public ItemOffer getItemOfferBestItemPrice(int i) {
        TypedQuery<ItemOffer> query = entityManager.createQuery("select c from ItemOffer c where c.item.id=:i order by c.buyingPrice",
                ItemOffer.class);
        query.setParameter("i", i);
        query.setFirstResult(0);
        query.setMaxResults(1);
        return query.getSingleResult();
    }

}
