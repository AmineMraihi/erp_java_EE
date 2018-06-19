package tn.esprit.b1.esprit1718b1erp.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
   
    @OneToOne
    private User repairer;
    
    private String report ;
    
    private float price;
    
 
    
    @ManyToMany
   @JoinTable(name = "item_for_breakdown",
   joinColumns = { @JoinColumn(name = "breakdown_id")},
   inverseJoinColumns = { @JoinColumn(name = "item_id")})
    private Set<Item> items = new HashSet<Item>();
    
    
    
    

    
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

    public User getRepairer() {
        return repairer;
    }

    public void setRepairer(User repairer) {
        this.repairer = repairer;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }
    
    
    
    
}