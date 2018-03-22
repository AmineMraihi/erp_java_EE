package tn.esprit.b1.esprit1718b1erp.services.youssfi;

import javax.ejb.Remote;

import tn.esprit.b1.esprit1718b1erp.entities.Project;
import tn.esprit.b1.esprit1718b1erp.utilities.GenericDAO;
import tn.esprit.b1.esprit1718b1erp.utilities.IGenericDAO;

@Remote
public interface ProjectServiceRemote extends IGenericDAO<Project> {

}
