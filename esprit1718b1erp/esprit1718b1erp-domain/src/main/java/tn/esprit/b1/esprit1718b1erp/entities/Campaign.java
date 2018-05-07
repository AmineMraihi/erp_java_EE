package tn.esprit.b1.esprit1718b1erp.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
    
    @OneToOne
    private User responsable ;
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<Contact> participants = new ArrayList<>();
    
    private float budget;
    
    private String region;
    
    @ManyToMany
    private List<Product> productsCampaign ;
    
    private float revenue;
    
    private String photo;
    
    @OneToOne
    private Report report ;
    
    @OneToOne
    private SaleOpportunity saleOpportunity ;
    
    @Enumerated(EnumType.STRING)
    private Campaign_Type type;

    public Integer getId() {
        return id;
    }

   

    public List<Contact> getParticipants() {
        return participants;
    }



    public void setParticipants(List<Contact> participants) {
        this.participants = participants;
    }



    public List<Product> getProductsCampaign() {
        return productsCampaign;
    }



    public void setProductsCampaign(List<Product> productsCampaign) {
        this.productsCampaign = productsCampaign;
    }



    public User getResponsable() {
        return responsable;
    }



    public void setResponsable(User responsable) {
        this.responsable = responsable;
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



    public Report getReport() {
        return report;
    }



    public void setReport(Report report) {
        this.report = report;
    }



    public SaleOpportunity getSaleOpportunity() {
        return saleOpportunity;
    }



    public void setSaleOpportunity(SaleOpportunity saleOpportunity) {
        this.saleOpportunity = saleOpportunity;
    }
    
    

}
