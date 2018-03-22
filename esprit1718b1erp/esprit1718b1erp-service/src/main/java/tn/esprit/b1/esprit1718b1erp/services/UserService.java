package tn.esprit.b1.esprit1718b1erp.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.log4j.Logger;
import tn.esprit.b1.esprit1718b1erp.entities.User;
import tn.esprit.b1.esprit1718b1erp.utilities.GenericDAO;

/**
 * Session Bean implementation class UserService
 */
@Stateless
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
}
