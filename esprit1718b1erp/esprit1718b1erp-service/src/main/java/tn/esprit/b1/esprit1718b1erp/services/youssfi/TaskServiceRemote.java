package tn.esprit.b1.esprit1718b1erp.services.youssfi;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.b1.esprit1718b1erp.entities.Project;
import tn.esprit.b1.esprit1718b1erp.entities.Task;
import tn.esprit.b1.esprit1718b1erp.entities.User;
import tn.esprit.b1.esprit1718b1erp.utilities.IGenericDAO;

@Remote
public interface TaskServiceRemote extends IGenericDAO<Task> {
    public List<Task> findtasksbyUser(Project project,User user);
}
