package tn.esprit.b1.esprit1718b1erp.services.amine;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.b1.esprit1718b1erp.entities.Item;
import tn.esprit.b1.esprit1718b1erp.entities.ItemOffer;
import tn.esprit.b1.esprit1718b1erp.utilities.IGenericDAO;

@Remote
public interface ItemOfferServiceRemote  extends IGenericDAO<ItemOffer> {
    void deleteItemOffersByItemId(int i);
   public List<ItemOffer> getItemOffersByItem(int i); 
   public ItemOffer getItemOfferBestItemPrice(int i);
    
}
