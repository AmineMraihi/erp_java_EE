package tn.esprit.b1.esprit1718b1erp.services;

import javax.ejb.Remote;

import tn.esprit.b1.esprit1718b1erp.entities.User;
import tn.esprit.b1.esprit1718b1erp.utilities.IGenericDAO;

@Remote
public interface UserServiceRemote extends IGenericDAO<User> {

}
