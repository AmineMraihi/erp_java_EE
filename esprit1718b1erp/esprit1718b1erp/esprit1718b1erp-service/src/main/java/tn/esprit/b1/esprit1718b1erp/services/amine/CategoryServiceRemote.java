package tn.esprit.b1.esprit1718b1erp.services.amine;

import javax.ejb.Remote;

import javafx.collections.ObservableList;
import tn.esprit.b1.esprit1718b1erp.entities.Category;
import tn.esprit.b1.esprit1718b1erp.utilities.IGenericDAO;

@Remote
public interface CategoryServiceRemote extends IGenericDAO<Category> {
    void addCategoryAmine(Category c);
}
