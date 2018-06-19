package tn.esprit.b1.esprit1718b1erp.mbeans;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;


import tn.esprit.b1.esprit1718b1erp.entities.Product;
import tn.esprit.b1.esprit1718b1erp.entities.Project;
import tn.esprit.b1.esprit1718b1erp.entities.StateProject;
import tn.esprit.b1.esprit1718b1erp.entities.User;
import tn.esprit.b1.esprit1718b1erp.entities.taskID;
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
    private List<Project> Finished;
    private List<Project> Interrupted;
    private List<Long> projectsBymonth;
    private String NbrProjects;
    private Project p;
    private int id_product;
    private long id_responsible;
    private Project projectDetails;
    private String textReport;
    private Map<String, Long> statistics;
    private Project closestProject;
    private Double sommeBudget;
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
    public String toFinishedProjectDetails(int i) {
        projectDetails = projectService.find(i);
        
        return "/DetailsFinishedProjects?faces-redirect=true\"";
    }
    public String toInterruptedProjectDetails(int i) {
        projectDetails = projectService.find(i);
        return "/DetailsInterrupted?faces-redirect=true\"";
    }
    public String InterruptProject(){
        Date date = new Date();
        projectDetails.setAnnule(1);
        projectDetails.setInterruptionDate(date);
        projectDetails.setEtat(StateProject.INTERRUPTED);
        projectDetails.setReason(reason);
        projectService.update(projectDetails);
        return "/ProjectManagment?faces-redirect=true\"";
    }
    public String ContinueProject(){
        projectDetails.setAnnule(1);
        projectDetails.setEtat(StateProject.IN_PROGRESS);
        projectDetails.setReason(null);
        projectService.update(projectDetails);
        return "/ProjectManagment?faces-redirect=true\"";
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
    
    public Double getSommeBudget() {
        sommeBudget = projectService.SommeBudgets();
        return sommeBudget;
    }
    public void setSommeBudget(Double sommeBudget) {
        this.sommeBudget = sommeBudget;
    }
    public Project getClosestProject() {
        closestProject =projectService.findByDate(projectService.ClosestProject()) ;
        return closestProject;
    }
    public void setClosestProject(Project closestProject) {
        this.closestProject = closestProject;
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
    
    public long getId_responsible() {
        return id_responsible;
    }
    public void setId_responsible(long id_responsible) {
        this.id_responsible = id_responsible;
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
        User user = projectService.getUserById(id_responsible);
        p.setResponsable(user);
        p.setProduct(product);
        p.setBugdet(this.bugdet);
        p.setDescription(this.description);
        p.setRetard(0);
        projectService.save(p);
        
    }
    public String updateProject(){
        Product product = projectService.getProductById(id_product);
        User user = projectService.getUserById(id_responsible);
        projectDetails.setProduct(product);
        projectDetails.setResponsable(user);
        projectService.update(projectDetails);
        return "/ProjectManagment?faces-redirect=true";
    }
    public String toProjectUpdate(int i) {
        projectDetails = projectService.find(i);
        return "/updateProject?faces-redirect=true";
    }
    public String deleteProject(){
        
        projectService.delete(projectDetails);
        return "/ProjectManagment?faces-redirect=true";
    }
    public void writePdf() throws FileNotFoundException, DocumentException
    {
        System.out.println("hello");
        Document document = new Document();

        try {
            document.open();

            Paragraph p = new Paragraph();
            p.add("This is my paragraph 1");
            p.setAlignment(Element.ALIGN_CENTER);

            document.add(p);

            Paragraph p2 = new Paragraph();
            p2.add("This is my paragraph 2"); //no alignment

            document.add(p2);

            Font f = new Font();
            f.setStyle(Font.BOLD);
            f.setSize(8);

            document.add(new Paragraph("This is my paragraph 3", f));

            //close
            document.close();
            PdfWriter.getInstance(document, new FileOutputStream(new File("/resources/ErpReport.pdf")));

            //open
            
           
            System.out.println("Done");
        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        }
    
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
    public List<Project> getFinished() {
        Finished = projectService.findByStateProject(StateProject.FINISHED);
        return Finished;
    }
    public void setFinished(List<Project> finished) {
        Finished = finished;
    }
    public List<Project> getInterrupted() {
        Interrupted = projectService.findByStateProject(StateProject.INTERRUPTED);
        return Interrupted;
    }
    public void setInterrupted(List<Project> interrupted) {
        Interrupted = interrupted;
    }
    public String getTextReport() {
        return textReport;
    }
    public void setTextReport(String textReport) {
        this.textReport = textReport;
    }
    public Map<String, Long> getStatistics() {
        statistics = projectService.projectsBymonth();
        return statistics;
    }
    public void setStatistics(Map<String, Long> statistics) {
        this.statistics = statistics;
    }
    ///////////////// statistics ///////////////////
    public Long ProjectPerMonth1()
    {
        return projectService.ProjectPerMonth(1);
    }
    public Long ProjectPerMonth2()
    {
        return projectService.ProjectPerMonth(2);
    }
    public Long ProjectPerMonth3()
    {
        return projectService.ProjectPerMonth(3);
    }
    public Long ProjectPerMonth4()
    {
        return projectService.ProjectPerMonth(4);
    }
    public Long ProjectPerMonth5()
    {
        return projectService.ProjectPerMonth(5);
    }
    public Long ProjectPerMonth6()
    {
        return projectService.ProjectPerMonth(6);
    }
    public Long ProjectPerMonth7()
    {
        return projectService.ProjectPerMonth(7);
    }
    public Long ProjectPerMonth8()
    {
        return projectService.ProjectPerMonth(8);
    }
    public Long ProjectPerMonth9()
    {
        return projectService.ProjectPerMonth(9);
    }
    public Long ProjectPerMonth10()
    {
        return projectService.ProjectPerMonth(10);
    }
    public Long ProjectPerMonth11()
    {
        return projectService.ProjectPerMonth(11);
    }
    public Long ProjectPerMonth12()
    {
        return projectService.ProjectPerMonth(12);
    }
    ////////////////// fin statistics
}
