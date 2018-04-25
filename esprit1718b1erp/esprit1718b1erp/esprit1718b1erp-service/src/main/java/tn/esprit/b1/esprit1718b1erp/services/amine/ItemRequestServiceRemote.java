package tn.esprit.b1.esprit1718b1erp.services.amine;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.b1.esprit1718b1erp.entities.ItemRequest;
import tn.esprit.b1.esprit1718b1erp.utilities.IGenericDAO;

@Remote
public interface ItemRequestServiceRemote extends IGenericDAO<ItemRequest> {
    ItemRequest iRExist(int i);
    int addItemRequestGetId(ItemRequest i);
    void deleteItemRequestId(ItemRequest i);
    List<ItemRequest> findAllNotDone();
    void deleteManyItemRequests(int i);
    ItemRequest iRExistforImortDirect(int i);
}
