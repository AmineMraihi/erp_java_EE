package tn.esprit.b1.esprit1718b1erp.mbeans;

import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.b1.esprit1718b1erp.entities.Project;
import tn.esprit.b1.esprit1718b1erp.entities.Task;
import tn.esprit.b1.esprit1718b1erp.entities.User;
import tn.esprit.b1.esprit1718b1erp.entities.taskID;
import tn.esprit.b1.esprit1718b1erp.services.youssfi.TaskService;

@ManagedBean
@SessionScoped
public class TaskBean {

    taskID idTask ;
    String nomTache;
    Project project;
    User responsableTache;
    String descrption;
    Date dateDebut;
    Date dateFin;
    int retard;
    boolean fini;
    String feedback;
    int priorite;
    Float somme_task;
    Task t;
    private int id_responsable;
    private int id_project;
    private Task taskToUpdate;

    @EJB
    TaskService taskService;

    
    public String addTask(Project project){
        t = new Task();
        taskID taskid = new taskID();
        t.setNomTache(this.nomTache);
        t.setDateDebut(this.dateDebut);
        t.setDateFin(this.dateFin);
        t.setDescrption(this.descrption);
        t.setFini(false);
        project = taskService.findProjectById(project.getId());
        User responsable = taskService.findResponsableById(this.id_responsable);
        t.setProject(project);
        t.setResponsableTache(responsable);
        taskid.setIdProject(project.getId());
        taskid.setIdUser(responsable.getCode());
        t.setIdTask(taskid);
        taskService.save(t);
        return "/DetailsProgressProjects?faces-redirect=true\"";
        
    }
    public String deleteTask(Task task){
        taskService.delete(task);
        return "/DetailsProgressProjects?faces-redirect=true\"";
    }
    public String toTaskUpdate(taskID i) {
        taskToUpdate = taskService.findById(i);
        return "/updateTask?faces-redirect=true";
    }
    public String updateTask(){
        User responsable = taskService.findResponsableById(this.id_responsable);
        taskToUpdate.setResponsableTache(responsable);
        taskService.update(taskToUpdate);
        return "/DetailsProgressProjects?faces-redirect=true";
    }
    public taskID getIdTask() {
        return idTask;
    }

    public void setIdTask(taskID idTask) {
        this.idTask = idTask;
    }

    public String getNomTache() {
        return nomTache;
    }

    public void setNomTache(String nomTache) {
        this.nomTache = nomTache;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public User getResponsableTache() {
        return responsableTache;
    }

    public void setResponsableTache(User responsableTache) {
        this.responsableTache = responsableTache;
    }

    public String getDescrption() {
        return descrption;
    }

    public void setDescrption(String descrption) {
        this.descrption = descrption;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public int getRetard() {
        return retard;
    }

    public void setRetard(int retard) {
        this.retard = retard;
    }

    public boolean isFini() {
        return fini;
    }

    public void setFini(boolean fini) {
        this.fini = fini;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getPriorite() {
        return priorite;
    }

    public void setPriorite(int priorite) {
        this.priorite = priorite;
    }

    public Float getSomme_task() {
        return somme_task;
    }

    public void setSomme_task(Float somme_task) {
        this.somme_task = somme_task;
    }

    public TaskService getTaskService() {
        return taskService;
    }

    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }
    public int getId_responsable() {
        return id_responsable;
    }
    public void setId_responsable(int id_responsable) {
        this.id_responsable = id_responsable;
    }
    public int getId_project() {
        return id_project;
    }
    public void setId_project(int id_project) {
        this.id_project = id_project;
    }
    public Task getTaskToUpdate() {
        return taskToUpdate;
    }
    public void setTaskToUpdate(Task taskToUpdate) {
        this.taskToUpdate = taskToUpdate;
    }
///////////////// statistics ///////////////////
    public Long TaskPerMonth1(Project project)
    {
        return taskService.TaskPerMonth(1, project);
    }
    public Long TaskPerMonth2(Project project)
    {
        return taskService.TaskPerMonth(2, project);
    }
    public Long TaskPerMonth3(Project project)
    {
        return taskService.TaskPerMonth(3, project);
    }
    public Long TaskPerMonth4(Project project)
    {
        return taskService.TaskPerMonth(4, project);
    }
    public Long TaskPerMonth5(Project project)
    {
        return taskService.TaskPerMonth(5, project);
    }
    public Long TaskPerMonth6(Project project)
    {
        return taskService.TaskPerMonth(6, project);
    }
    public Long TaskPerMonth7(Project project)
    {
        return taskService.TaskPerMonth(7, project);
    }
    public Long TaskPerMonth8(Project project)
    {
        return taskService.TaskPerMonth(8, project);
    }
    public Long TaskPerMonth9(Project project)
    {
        return taskService.TaskPerMonth(9, project);
    }
    public Long TaskPerMonth10(Project project)
    {
        return taskService.TaskPerMonth(10, project);
    }
    public Long TaskPerMonth11(Project project)
    {
        return taskService.TaskPerMonth(11, project);
    }
    public Long TaskPerMonth12(Project project)
    {
        return taskService.TaskPerMonth(12, project);
    }
////////////////// fin statistics
    

}
