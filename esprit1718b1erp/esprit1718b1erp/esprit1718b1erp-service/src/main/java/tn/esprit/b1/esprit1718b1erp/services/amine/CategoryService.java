package tn.esprit.b1.esprit1718b1erp.services.amine;

import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javafx.collections.ObservableList;
import tn.esprit.b1.esprit1718b1erp.entities.Category;
import tn.esprit.b1.esprit1718b1erp.entities.Item;
import tn.esprit.b1.esprit1718b1erp.utilities.GenericDAO;

/**
 * Session Bean implementation class CategoryService
 */
@Stateless
public class CategoryService extends GenericDAO<Category> implements CategoryServiceRemote, CategoryServiceLocal {

    @PersistenceContext
    private EntityManager entityManager;

    public CategoryService() {
        super(Category.class);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void addCategoryAmine(Category c) {
        entityManager.persist(c);        

    }
    
    public void delete(Category c) {
        Category entityToBeRemoved = entityManager.merge(c);
        entityManager.remove(entityToBeRemoved);
    }

   

  

}
