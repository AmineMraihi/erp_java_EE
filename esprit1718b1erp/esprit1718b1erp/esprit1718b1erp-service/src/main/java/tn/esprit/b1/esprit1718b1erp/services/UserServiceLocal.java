package tn.esprit.b1.esprit1718b1erp.services;

import javax.ejb.Local;

import tn.esprit.b1.esprit1718b1erp.entities.User;
import tn.esprit.b1.esprit1718b1erp.utilities.IGenericDAO;

@Local
public interface UserServiceLocal extends IGenericDAO<User> {

    User login(String login, String password);

}
