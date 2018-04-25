package tn.esprit.b1.esprit1718b1erp.services.youssfi;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.b1.esprit1718b1erp.entities.Conge;
import tn.esprit.b1.esprit1718b1erp.entities.User;
import tn.esprit.b1.esprit1718b1erp.utilities.IGenericDAO;

@Remote
public interface CongeServiceRemote extends IGenericDAO<Conge>{
    public List<Conge> findByEmployee(User user); 
    public List<Conge> findByEtat(int i); 
}
