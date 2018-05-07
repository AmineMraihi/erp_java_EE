package tn.esprit.b1.esprit1718b1erp.services.youssfi;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.b1.esprit1718b1erp.entities.Product;
import tn.esprit.b1.esprit1718b1erp.entities.Project;
import tn.esprit.b1.esprit1718b1erp.entities.StateProject;
import tn.esprit.b1.esprit1718b1erp.entities.User;
import tn.esprit.b1.esprit1718b1erp.utilities.GenericDAO;
import tn.esprit.b1.esprit1718b1erp.utilities.IGenericDAO;

@Remote
public interface ProjectServiceRemote extends IGenericDAO<Project> {

    public List<Project> findByStateProject(StateProject stateProject);
    public Project findResponsablesProjects(User code);
    public Project findProjectByName(String name);
    public List<String> findAllProjectsNames();
    public Long countProjects();
    public Long countProgressProjects();
    public Long countFinishedProjects();
    public Long countInterruptedProjects();
    public List<Long> numberProjectsByMonth();
    public Product getProductById(int id);
}
