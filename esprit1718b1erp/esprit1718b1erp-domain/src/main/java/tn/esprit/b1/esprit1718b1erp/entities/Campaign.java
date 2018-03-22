package tn.esprit.b1.esprit1718b1erp.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Campaign implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    private String nameCampaign;
    
    private String description;
    
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    
    @Temporal(TemporalType.DATE)
    private Date beginningDate;
    
    @Temporal(TemporalType.DATE)
    private Date endingDate;
    
    private float budget;
    
    private String region;
    
    private float revenue;
    
    private String photo;
    
    @Enumerated(EnumType.STRING)
    private Campaign_Type type;

    public Integer getId() {
        return id;
    }

   

    public static long getSerialversionuid() {
        return serialVersionUID;
    }



    public String getNameCampaign() {
        return nameCampaign;
    }



    public void setNameCampaign(String nameCampaign) {
        this.nameCampaign = nameCampaign;
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



    public Date getBeginningDate() {
        return beginningDate;
    }



    public void setBeginningDate(Date beginningDate) {
        this.beginningDate = beginningDate;
    }



    public Date getEndingDate() {
        return endingDate;
    }



    public void setEndingDate(Date endingDate) {
        this.endingDate = endingDate;
    }



    public float getBudget() {
        return budget;
    }



    public void setBudget(float budget) {
        this.budget = budget;
    }



    public String getRegion() {
        return region;
    }



    public void setRegion(String region) {
        this.region = region;
    }



    public float getRevenue() {
        return revenue;
    }



    public void setRevenue(float revenue) {
        this.revenue = revenue;
    }



    public String getPhoto() {
        return photo;
    }



    public void setPhoto(String photo) {
        this.photo = photo;
    }



    public Campaign_Type getType() {
        return type;
    }



    public void setType(Campaign_Type type) {
        this.type = type;
    }
    
    

}
