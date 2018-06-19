package tn.esprit.b1.esprit1718b1erp.services.youssfi;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public User getUserById(long id);
    public Map<String, Long> projectsBymonth();
    public Long ProjectPerMonth(Integer i);
    public Date ClosestProject();
    public Project findByDate(Date date);
    public Double SommeBudgets();
}
