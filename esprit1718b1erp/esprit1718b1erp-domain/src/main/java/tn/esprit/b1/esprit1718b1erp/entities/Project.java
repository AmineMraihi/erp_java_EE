package tn.esprit.b1.esprit1718b1erp.entities;

import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
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
    private int id;
    
    private String projectName;
    
    private String description;
    
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    
    @Temporal(TemporalType.DATE)
    private Date startDate;
    
    @Temporal(TemporalType.DATE)
    private Date finDate;
    @Temporal(TemporalType.DATE)
    private Date interruptionDate;
    
    private Long duration;
    private float bugdet;
    
    @OneToOne
    private User responsable;
    
    private int retard;
    
    private String reason;
    
    @Enumerated(EnumType.STRING)
    private StateProject etat;
    
    private int annule;
    
    @OneToMany
    private List<Contact> sponsor;
    
    private String emplacement;
    @OneToOne(fetch=FetchType.EAGER ,cascade=CascadeType.REMOVE)
    private Product product;

    @OneToMany(mappedBy="project",fetch=FetchType.EAGER,cascade=CascadeType.REMOVE)
    private List<Task> tasks;
    
    
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

    public Long getDuration() {
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

    public StateProject isEtat() {
        return etat;
    }

    public void setEtat(StateProject etat) {
        this.etat = etat;
    }

    public int isAnnule() {
        return annule;
    }

    public void setAnnule(int annule) {
        this.annule = annule;
    }

    
    public List<Contact> getSponsor() {
        return sponsor;
    }

    public void setSponsor(List<Contact> sponsor) {
        this.sponsor = sponsor;
    }
    
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public StateProject getEtat() {
        return etat;
    }

    public int getAnnule() {
        return annule;
    }

    public Date getInterruptionDate() {
        return interruptionDate;
    }

    public void setInterruptionDate(Date interruptionDate) {
        this.interruptionDate = interruptionDate;
    }
    
}