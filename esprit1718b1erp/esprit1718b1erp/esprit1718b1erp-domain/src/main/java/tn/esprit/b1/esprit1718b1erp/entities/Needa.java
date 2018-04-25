package tn.esprit.b1.esprit1718b1erp.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Needa implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_need;
    private String nom_prod ;
    private Float somme;
    @Temporal(TemporalType.DATE)
    private Date SaleDate;
    
    public Integer getID_need() {
        return ID_need;
    }

    public Needa( String nom_prod, Float somme) {
        super();
        
        this.nom_prod = nom_prod;
        this.somme = somme;
    }

    public String getNom_prod() {
        return nom_prod;
    }

    public void setNom_prod(String nom_prod) {
        this.nom_prod = nom_prod;
    }

    public Float getSomme() {
        return somme;
    }

    public void setSomme(Float somme) {
        this.somme = somme;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public void setID_need(Integer iD_need) {
        ID_need = iD_need;
    }

    public Date getSaleDate() {
        return SaleDate;
    }

    public void setSaleDate(Date saleDate) {
        SaleDate = saleDate;
    }

    public Needa(String nom_prod, Float somme, Date saleDate) {
        super();
        this.nom_prod = nom_prod;
        this.somme = somme;
        SaleDate = saleDate;
    }

    @Override
    public String toString() {
        return "Need [ID_need=" + ID_need + ", nom_prod=" + nom_prod + ", somme=" + somme + "]";
    }

    public Needa() {
        super();
    }
   
    
    
}
