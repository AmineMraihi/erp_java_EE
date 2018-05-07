package tn.esprit.b1.esprit1718b1erp.mbeans;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import tn.esprit.b1.esprit1718b1erp.entities.Product;
import tn.esprit.b1.esprit1718b1erp.entities.Project;
import tn.esprit.b1.esprit1718b1erp.entities.StateProject;
import tn.esprit.b1.esprit1718b1erp.entities.User;
import tn.esprit.b1.esprit1718b1erp.services.youssfi.ProjectService;

@ManagedBean
@SessionScoped
public class ProjectBean {

    
    private String projectName;
    private String description;
    private Date creationDate;
    private Date startDate;
    private Date finDate;
    private Date interruptionDate;
    private Long duration;
    private float bugdet;
    private User responsable;
    private int retard;
    private String reason;
    private StateProject etat;
    private int annule;
    private List<Project> projects;
    private List<Project> InProgress;
    private List<Long> projectsBymonth;
    private String NbrProjects;
    private Project p;
    private int id_product;
    private Project projectDetails;
    
    @EJB
    ProjectService projectService;
    
   
    public List<Project> getProjects() {
        projects = projectService.findAll();
        return projects;
    }
    public String toProjectDetails(int i) {
        projectDetails = projectService.find(i);
        return "/DetailsProgressProjects?faces-redirect=true\"";
    }
    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
    public String getProjectName() {
        return projectName;
    }
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Date getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getFinDate() {
        return finDate;
    }
    public void setFinDate(Date finDate) {
        this.finDate = finDate;
    }
    public Date getInterruptionDate() {
        return interruptionDate;
    }
    public void setInterruptionDate(Date interruptionDate) {
        this.interruptionDate = interruptionDate;
    }
    public Long getDuration() {
        Date date = new Date();
        long diff = date.getTime() - creationDate.getTime() ;
        duration = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        return duration;
    }
    public void setDuration(Long duration) {
        this.duration = duration;
    }
    public float getBugdet() {
        return bugdet;
    }
    public void setBugdet(float bugdet) {
        this.bugdet = bugdet;
    }
    public User getResponsable() {
        return responsable;
    }
    public void setResponsable(User responsable) {
        this.responsable = responsable;
    }
    public int getRetard() {
        return retard;
    }
    public void setRetard(int retard) {
        this.retard = retard;
    }
    public String getReason() {
        return reason;
    }
    public void setReason(String reason) {
        this.reason = reason;
    }
    public StateProject getEtat() {
        return etat;
    }
    public void setEtat(StateProject etat) {
        this.etat = etat;
    }
    public int getAnnule() {
        return annule;
    }
    public void setAnnule(int annule) {
        this.annule = annule;
    }
    
    public ProjectService getProjectService() {
        return projectService;
    }
    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }
    public List<Long> getProjectsBymonth() {
        projectsBymonth = projectService.numberProjectsByMonth();
        return projectsBymonth;
    }
    public void setProjectsBymonth(List<Long> projectsBymonth) {
        this.projectsBymonth = projectsBymonth;
    }
   
    public String getNbrProjects() {
        for(Long l:projectsBymonth)
        {
            NbrProjects +=l+",";
        }
        return NbrProjects;
    }
    public void setNbrProjects(String nbrProjects) {
        NbrProjects = nbrProjects;
    }
    public void addProject(){
        p = new Project();
        Date date = new Date();
        p.setProjectName(this.projectName);
        p.setStartDate(this.startDate);
        p.setCreationDate(date);
        p.setAnnule(0);
        p.setEtat(StateProject.IN_PROGRESS);
        p.setFinDate(this.finDate);
        Product product = projectService.getProductById(id_product);
        p.setProduct(product);
        p.setBugdet(this.bugdet);
        p.setDescription(this.description);
        p.setRetard(0);
        projectService.save(p);
        
    }
    public Project getP() {
        return p;
    }
    public void setP(Project p) {
        this.p = p;
    }
    public int getId_product() {
        return id_product;
    }
    public void setId_product(int id_product) {
        this.id_product = id_product;
    }
    public List<Project> getInProgress() {
        InProgress = projectService.findByStateProject(StateProject.IN_PROGRESS);
        return InProgress;
    }
    public void setInProgress(List<Project> inProgress) {
        InProgress = inProgress;
    }
    public Project getProjectDetails() {
        return projectDetails;
    }
    public void setProjectDetails(Project projectDetails) {
        this.projectDetails = projectDetails;
    }
    
}
