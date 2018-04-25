package tn.esprit.b1.esprit1718b1erp.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id_Product;
    String nomProduit;
    Date dateCreation;
    @OneToOne(mappedBy="product",fetch=FetchType.EAGER)
    Project project;
    float prixUnitaire;
    int qte;
    String type;
    float prixQuantite;
    @ManyToMany(mappedBy = "products")
    private Set<Sale> Sales = new HashSet<Sale>();
    @ManyToOne
    private Sale sale;
    @ManyToMany(mappedBy = "productsCampaign")
    private List<Campaign> campaigns;
    private static final long serialVersionUID = 1L;

    public Integer getId_Product() {
        return Id_Product;
    }

    public void setId_Product(Integer id_Product) {
        Id_Product = id_Product;
    }



    public Set<Sale> getSales() {
        return Sales;
    }

    public void setSales(Set<Sale> sales) {
        Sales = sales;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

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

    @Override
    public String toString() {
        return nomProduit;
    }

    public List<Campaign> getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(List<Campaign> campaigns) {
        this.campaigns = campaigns;
    }

    public Product(String nomProduit, Date dateCreation) {
        super();
        this.nomProduit = nomProduit;
        this.dateCreation = dateCreation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    

}
