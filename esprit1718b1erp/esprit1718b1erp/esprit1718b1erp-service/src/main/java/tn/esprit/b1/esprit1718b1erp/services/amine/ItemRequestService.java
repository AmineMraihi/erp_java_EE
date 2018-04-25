package tn.esprit.b1.esprit1718b1erp.services.amine;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.esprit.b1.esprit1718b1erp.entities.ItemRequest;
import tn.esprit.b1.esprit1718b1erp.entities.ItemRequestStatus;
import tn.esprit.b1.esprit1718b1erp.utilities.GenericDAO;

/**
 * Session Bean implementation class ItemRequest
 */
@Stateless
public class ItemRequestService extends GenericDAO<ItemRequest>
        implements ItemRequestServiceRemote, ItemRequestServiceLocal {

    @PersistenceContext
    private EntityManager entityManager;

    public ItemRequestService() {
        super(ItemRequest.class);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public ItemRequest iRExist(int i) throws NoResultException {
        TypedQuery<ItemRequest> query = entityManager.createQuery("select c from ItemRequest c where c.item.id=:i ",
                ItemRequest.class);
        query.setParameter("i", i);
//        query.setParameter("j", ItemRequestStatus.NOTDONE);
        return query.getSingleResult();
    }
    
    @Override
    public ItemRequest iRExistforImortDirect(int i) {
        TypedQuery<ItemRequest> query = entityManager.createQuery("select c from ItemRequest c where c.item.id=:i and c.itemRequestStatus=:j",
                ItemRequest.class);
        query.setParameter("i", i);
        query.setParameter("j", ItemRequestStatus.NOTDONE);
        return query.getSingleResult();
    }

    @Override
    public int addItemRequestGetId(ItemRequest i) {
        entityManager.persist(i);
        return i.getId();
    }

    @Override
    public void deleteItemRequestId(ItemRequest i) {
        entityManager.merge(i);
        try {
            entityManager.remove(i.getItem());
        } catch (Exception e) {

        }
        entityManager.remove(i);

    }

    @Override
    public List<ItemRequest> findAllNotDone() {
        TypedQuery<ItemRequest> query = entityManager.createQuery("select c from ItemRequest c where c.itemRequestStatus=:i",
                ItemRequest.class);
        query.setParameter("i", ItemRequestStatus.NOTDONE);
        return query.getResultList();
    }

    @Override
    public void deleteManyItemRequests(int i) {
        Query query=entityManager.createQuery("delete  from ItemRequest c where c.item.id=:i");
        query.setParameter("i", i).executeUpdate();
    }

   

}
