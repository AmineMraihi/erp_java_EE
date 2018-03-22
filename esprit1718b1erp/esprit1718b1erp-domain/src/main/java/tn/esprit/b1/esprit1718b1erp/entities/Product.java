package tn.esprit.b1.esprit1718b1erp.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id_Product;
    String nomProduit;
    Date dateCreation;
    Project project;
    float prixUnitaire;
    int qte;
    float prixQuantite;

    @ManyToOne
    private Sale sale;
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public Product() {
    }

    public int getId() {
        return Id_Product;
    }

    public void setId(int id) {
        this.Id_Product = id;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public float getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(float prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public float getPrixQuantite() {
        return prixQuantite;
    }

    public void setPrixQuantite(float prixQuantite) {
        this.prixQuantite = prixQuantite;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

}
