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
public class Intangibles implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_intangibles;
    
    private Float Somme;
    
    @Temporal(TemporalType.DATE)
    private Date dateIntagible;

    public Integer getId_intangibles() {
        return id_intangibles;
    }

    public void setId_intangibles(Integer id_intangibles) {
        this.id_intangibles = id_intangibles;
    }

    public Float getSomme() {
        return Somme;
    }

    public void setSomme(Float somme) {
        Somme = somme;
    }

    public Date getDateIntagible() {
        return dateIntagible;
    }

    public void setDateIntagible(Date dateIntagible) {
        this.dateIntagible = dateIntagible;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "Intangibles [id_intangibles=" + id_intangibles + ", Somme=" + Somme + ", dateIntagible=" + dateIntagible
                + "]";
    }
    
    
    
    
}
