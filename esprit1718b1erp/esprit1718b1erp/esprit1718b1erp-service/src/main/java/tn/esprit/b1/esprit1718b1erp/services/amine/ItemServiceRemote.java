package tn.esprit.b1.esprit1718b1erp.services.amine;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.b1.esprit1718b1erp.entities.Category;
import tn.esprit.b1.esprit1718b1erp.entities.Contact;
import tn.esprit.b1.esprit1718b1erp.entities.Item;
import tn.esprit.b1.esprit1718b1erp.entities.User;
import tn.esprit.b1.esprit1718b1erp.utilities.IGenericDAO;

@Remote
public interface ItemServiceRemote extends IGenericDAO<Item> {
    void addItemWithCategoryAndSupplier(Item i, Category c, Contact s,User u);

    void updateItemWithCategoryAndSupplier(Item i, Category c, Contact s,User u);

    void deleteItemWithCategoryAndSupplier(Item i);

    List<String> getItemNamesList();

    List<Integer> getItemBarcodeList();

    List<Item> getMachineList(String cat);

    Item getMachine(String cat);
    
    public List<Item> ListStock(String cat);
}
