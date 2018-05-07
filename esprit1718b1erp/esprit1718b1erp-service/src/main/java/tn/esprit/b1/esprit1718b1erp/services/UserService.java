package tn.esprit.b1.esprit1718b1erp.services;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;

import tn.esprit.b1.esprit1718b1erp.entities.User;
import tn.esprit.b1.esprit1718b1erp.entities.UserFunction;
import tn.esprit.b1.esprit1718b1erp.utilities.GenericDAO;

/**
 * Session Bean implementation class UserService
 */
@Stateless
@LocalBean

public class UserService extends GenericDAO<User> implements UserServiceRemote, UserServiceLocal {
    @PersistenceContext
    private EntityManager entityManager;
    private static final Logger LOGGER = Logger.getLogger(UserService.class);

    /**
     * Default constructor.
     */
    public UserService() {
        super(User.class);
    }

    @Override
    public User login(String login, String password) {
        User user = null;
        try {
            user = entityManager.createQuery("SELECT u FROM User u WHERE u.login=:l AND u.password=:p", User.class)
                    .setParameter("l", login).setParameter("p", password).getSingleResult();
        } catch (Exception e) {
            LOGGER.error("Error while selecting from table user ", e);
        }
        return user;
    }

    @Override
    public List<User> findByFunction(UserFunction function) {
        TypedQuery<User> query = entityManager.createQuery("select m from User m where m.userFct=:userFct ",
                User.class);
        query.setParameter("userFct", function);
        return query.getResultList();
    }

    @Override
    public User findByCode(long code) {
        TypedQuery<User> query = entityManager.createQuery("select m from User m where m.code=:code ", User.class);
        query.setParameter("code", code);
        return query.getSingleResult();
    }

    @Override
    public List<User> findCondidates(Integer Functional) {
        TypedQuery<User> query = entityManager.createQuery("select m from User m where m.Functional=:Functional ",
                User.class);
        query.setParameter("Functional", Functional);
        return query.getResultList();
    }

    @Override
    public Double TotalpayementbyGrade(String poste) {
        Double B = (double) 0;
        try {
            Query query = entityManager
                    .createQuery("SELECT SUM(u.Salary) FROM User u WHERE u.grade=:l GROUP BY u.grade");
            query.setParameter("l", poste);

            B = (Double) query.getSingleResult();

        } catch (Exception e) {
            // TODO: handle exception
        }

        return B;
    }
    
    public Double Totalpay_Employee_parYear(Date date_fin_anee,String year) {
        Double B = (double) 0;
      
        try {
            Query query = entityManager.createNativeQuery("SELECT ROUND (SUM(((DATEDIFF(:l,u.HiringDate))/30)* Salary),0)"
                    + " from user u WHERE YEAR(u.HiringDate)=:p");
            query.setParameter("l", date_fin_anee);
            query.setParameter("p", year);

            B = (Double) query.getSingleResult();

        } catch (Exception e) {
            // TODO: handle exception
        }

        return B;
    }

    
    
}
