package tn.esprit.b1.esprit1718b1erp.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.b1.esprit1718b1erp.entities.User;
import tn.esprit.b1.esprit1718b1erp.entities.UserFunction;
import tn.esprit.b1.esprit1718b1erp.utilities.IGenericDAO;

@Remote
public interface UserServiceRemote extends IGenericDAO<User> {
    public List<User> findByFunction(UserFunction function);
    public User findByCode(long code);
    public List<User> findCondidates(Integer i);
    public User login(String login, String password);
    Double TotalpayementbyGrade(String poste);
}
