package tn.esprit.b1.esprit1718b1erp.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class SaleOpportunity implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String nameSaleOpportunity;
    
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    
    @ManyToOne
    private Product produit ;
    
    @OneToOne
    private Report report ;
    
    private String region;
    
    private double lat;
    
    private double lng;
    
    private float budgetNeeded ;
    
    @ManyToOne
    private User responsable ; 




   

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public User getResponsable() {
        return responsable;
    }

    public void setResponsable(User responsable) {
        this.responsable = responsable;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameSaleOpportunity() {
        return nameSaleOpportunity;
    }

    public void setNameSaleOpportunity(String nameSaleOpportunity) {
        this.nameSaleOpportunity = nameSaleOpportunity;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Product getProduit() {
        return produit;
    }

    public void setProduit(Product produit) {
        this.produit = produit;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }

    public float getBudgetNeeded() {
        return budgetNeeded;
    }

    public void setBudgetNeeded(float budgetNeeded) {
        this.budgetNeeded = budgetNeeded;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
    

}
