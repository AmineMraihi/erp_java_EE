package tn.esprit.b1.esprit1718b1erp.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Sale implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id_Sale;

    @Enumerated(EnumType.STRING)
    private TypePayementPurchase typePayementPurchase;

    private String Description;
    private Integer quantity_products;
    private Float Somme_products;
    @Temporal(TemporalType.DATE)
    private Date dateSale;

    @OneToOne
    private Commande commandesale;

    @ManyToOne
    private General_Ledeger general_Ledeger_sale;

    @OneToMany(mappedBy = "sale")
    private List<Product> product;

    public Sale() {

    }

    public Integer getId_Sale() {
        return Id_Sale;
    }

    public void setId_Sale(Integer id_Sale) {
        Id_Sale = id_Sale;
    }

    public TypePayementPurchase getTypePayementPurchase() {
        return typePayementPurchase;
    }

    public void setTypePayementPurchase(TypePayementPurchase typePayementPurchase) {
        this.typePayementPurchase = typePayementPurchase;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Integer getQuantity_products() {
        return quantity_products;
    }

    public void setQuantity_products(Integer quantity_products) {
        this.quantity_products = quantity_products;
    }

    public Float getSomme_products() {
        return Somme_products;
    }

    public void setSomme_products(Float somme_products) {
        Somme_products = somme_products;
    }

    public Date getDateSale() {
        return dateSale;
    }

    public void setDateSale(Date dateSale) {
        this.dateSale = dateSale;
    }

    public Commande getCommandesale() {
        return commandesale;
    }

    public void setCommandesale(Commande commandesale) {
        this.commandesale = commandesale;
    }

    public General_Ledeger getGeneral_Ledeger_sale() {
        return general_Ledeger_sale;
    }

    public void setGeneral_Ledeger_sale(General_Ledeger general_Ledeger_sale) {
        this.general_Ledeger_sale = general_Ledeger_sale;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    
    

}
