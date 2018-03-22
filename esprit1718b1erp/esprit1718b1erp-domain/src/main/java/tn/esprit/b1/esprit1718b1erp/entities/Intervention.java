package tn.esprit.b1.esprit1718b1erp.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Intervention implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Float priority;

    
    private Date requestdate;

    @Enumerated(EnumType.STRING)
    private InterventionStatus interventionstatus;
    
   
    private Date desireddate;
    
    private String description;
    
    @ManyToOne
    private User applicant;

    public Integer getId() {
        return id;
    }

    public Float getPriority() {
        return priority;
    }

    public void setPriority(Float priority) {
        this.priority = priority;
    }

    public Date getRequestdate() {
        return requestdate;
    }

    public void setRequestdate(Date requestdate) {
        this.requestdate = requestdate;
    }

  

   

    public InterventionStatus getInterventionstatus() {
        return interventionstatus;
    }

    public void setInterventionstatus(InterventionStatus interventionstatus) {
        this.interventionstatus = interventionstatus;
    }

    public Date getDesireddate() {
        return desireddate;
    }

    public void setDesireddate(Date desireddate) {
        this.desireddate = desireddate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getApplicant() {
        return applicant;
    }

    public void setApplicant(User applicant) {
        this.applicant = applicant;
    }

    public void setId(Integer id) {
        this.id = id;
    }

   

}
