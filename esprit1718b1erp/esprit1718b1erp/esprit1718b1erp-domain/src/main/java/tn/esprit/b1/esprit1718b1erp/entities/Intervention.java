package tn.esprit.b1.esprit1718b1erp.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Intervention implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private InterventionPriority priority;
    
    @Enumerated(EnumType.STRING)
    private InterventionType interventiontype;
    
    private Date requestdate;

    @Enumerated(EnumType.STRING)
    private InterventionStatus interventionstatus;
    
   
    private Date desireddate;
    
    private String description;
    
    @OneToOne 
    private Item item;
    
    @Enumerated(EnumType.STRING)
    private MachineType machinetype;
    
    private String itemname;
    
    @OneToOne
    private User repairer;
    
    
    @ManyToOne
    private User applicant;
    
    private String observation;

    public Integer getId() {
        return id;
    }

  

    public InterventionPriority getPriority() {
        return priority;
    }



    public void setPriority(InterventionPriority priority) {
        this.priority = priority;
    }



    public Date getRequestdate() {
        return requestdate;
    }

    public void setRequestdate(Date requestdate) {
        this.requestdate = requestdate;
    }

  

   

    public InterventionType getInterventiontype() {
        return interventiontype;
    }



    public void setInterventiontype(InterventionType interventiontype) {
        this.interventiontype = interventiontype;
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



   



    public Item getItem() {
        return item;
    }



    public void setItem(Item item) {
        this.item = item;
    }



    public String getItemname() {
        return itemname;
    }



    public void setItemname(String itemname) {
        this.itemname = itemname;
    }



    public MachineType getMachinetype() {
        return machinetype;
    }



    public void setMachinetype(MachineType machinetype) {
        this.machinetype = machinetype;
    }



    public String getObservation() {
        return observation;
    }



    public void setObservation(String observation) {
        this.observation = observation;
    }



    public User getRepairer() {
        return repairer;
    }



    public void setRepairer(User repairer) {
        this.repairer = repairer;
    }



   

   

}
