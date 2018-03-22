package tn.esprit.b1.esprit1718b1erp.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Project implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    
    String projectName;
    
    String description;
    
    @Temporal(TemporalType.DATE)
    Date creationDate;
    
    @Temporal(TemporalType.DATE)
    Date startDate;
    
    @Temporal(TemporalType.DATE)
    Date finDate;
    
    int duration;
    float bugdet;
    
    @OneToOne
    User responsable;
    
    int retard;
    boolean etat;
    boolean annule;
    
    @OneToMany
    List<Contact> sponsor;
    
    String emplacement;

    @OneToMany(mappedBy="project")
    List<Task> tasks;
    
    public int getId() {
        return id;
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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
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

    public boolean isEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public boolean isAnnule() {
        return annule;
    }

    public void setAnnule(boolean annule) {
        this.annule = annule;
    }

    
    public List<Contact> getSponsor() {
        return sponsor;
    }

    public void setSponsor(List<Contact> sponsor) {
        this.sponsor = sponsor;
    }

    public String getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return projectName;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}