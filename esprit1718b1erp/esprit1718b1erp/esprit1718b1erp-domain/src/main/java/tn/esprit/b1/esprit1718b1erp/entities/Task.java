package tn.esprit.b1.esprit1718b1erp.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Task implements Serializable {

     
    @EmbeddedId
   taskID idTask ;
   
    String nomTache;
    
    @ManyToOne
    @JoinColumn(name="idProject",referencedColumnName="id",insertable=false,
    updatable=false)
    Project project;
    
    @ManyToOne
    @JoinColumn(name="idUser",referencedColumnName="USR_CODE",insertable=false,
    updatable=false)
    User responsableTache;
    
    String descrption;
    @Temporal(TemporalType.DATE)
    Date dateDebut;
    @Temporal(TemporalType.DATE)
    Date dateFin;
    int retard;
    boolean fini;
    String feedback;
    int priorite;
    Float somme_task;
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public Task() {

    }

    
  
    public Task(taskID idTask, String nomTache, Project project, User responsableTache, String descrption,
            Date dateDebut, Date dateFin, int retard, boolean fini, String feedback, int priorite) {
        super();
        this.idTask = idTask;
        this.nomTache = nomTache;
        this.project = project;
        this.responsableTache = responsableTache;
        this.descrption = descrption;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.retard = retard;
        this.fini = fini;
        this.feedback = feedback;
        this.priorite = priorite;
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

    public static long getSerialversionuid() {
        return serialVersionUID;
    }



    @Override
    public String toString() {
        return "Task [idTask=" + idTask + ", nomTache=" + nomTache + ", project=" + project + ", responsableTache="
                + responsableTache + ", descrption=" + descrption + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin
                + ", retard=" + retard + ", fini=" + fini + ", feedback=" + feedback + ", priorite=" + priorite
                + ", somme_task=" + somme_task + "]";
    }
    

}
