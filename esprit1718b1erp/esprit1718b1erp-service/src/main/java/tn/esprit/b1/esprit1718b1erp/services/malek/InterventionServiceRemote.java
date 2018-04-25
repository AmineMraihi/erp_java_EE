package tn.esprit.b1.esprit1718b1erp.services.malek;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.b1.esprit1718b1erp.entities.Intervention;
import tn.esprit.b1.esprit1718b1erp.entities.Item;
import tn.esprit.b1.esprit1718b1erp.utilities.IGenericDAO;

@Remote
public interface InterventionServiceRemote extends IGenericDAO<Intervention>{
   // Intervention findById(Integer n);
    List<Intervention> getInterventionList(Integer id);
    Intervention getIntervention(String id);

}
