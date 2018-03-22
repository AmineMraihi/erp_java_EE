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
public class Breakdown implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String description;

    
    private Date breakdowndate;
    
    private Date registrationdate;
    
    @ManyToOne
    private Item objecttomaintain;
    @Enumerated(EnumType.STRING)
    private BreakdownState breakdownstate;

    public Integer getId() {
        
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getBreakdowndate() {
        return breakdowndate;
    }

    public void setBreakdowndate(Date breakdowndate) {
        this.breakdowndate = breakdowndate;
    }

    public Date getRegistrationdate() {
        return registrationdate;
    }

    public void setRegistrationdate(Date registrationdate) {
        this.registrationdate = registrationdate;
    }

    public Item getObjecttomaintain() {
        return objecttomaintain;
    }

    public void setObjecttomaintain(Item objecttomaintain) {
        this.objecttomaintain = objecttomaintain;
    }

    public BreakdownState getBreakdownstate() {
        return breakdownstate;
    }

    public void setBreakdownstate(BreakdownState breakdownstate) {
        this.breakdownstate = breakdownstate;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    
    
    
}