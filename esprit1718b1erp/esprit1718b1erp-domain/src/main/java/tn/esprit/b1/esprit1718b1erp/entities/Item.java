package tn.esprit.b1.esprit1718b1erp.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Item implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    
    private String description;

    @ManyToOne
    private Category category;

    private Integer barcode;

    @Enumerated(EnumType.STRING)
    private Item_Type type;

    private Integer quantity;

    private Float byingPrice;

    private Float sellingPrice;
    
    private Float totalPrice;
    
    private String currency;

    @ManyToOne
    private Contact supplier;

    private String picture;

    @ManyToOne
    private User user;


    @ManyToMany(mappedBy = "item",cascade ={CascadeType.PERSIST})
    private List<Purchase> purchase;
    
    
    private Integer minimumQuanity;

    @Temporal(TemporalType.DATE)
    private Date expirationDate;

    private Boolean showAlertOnQuantity = true;

    private Boolean showAlertOnExpirationDate = true;
    @OneToMany
    private List<Breakdown> breakdowns;

    public List<Breakdown> getBreakdowns() {
        return breakdowns;
    }

    public void setBreakdowns(List<Breakdown> breakdowns) {
        this.breakdowns = breakdowns;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    
    

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getBarcode() {
        return barcode;
    }

    public void setBarcode(Integer barcode) {
        this.barcode = barcode;
    }

    public Item_Type getType() {
        return type;
    }

    public void setType(Item_Type type) {
        this.type = type;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getByingPrice() {
        return byingPrice;
    }

    public void setByingPrice(Float byingPrice) {
        this.byingPrice = byingPrice;
    }

    public Float getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Float sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public Contact getSupplier() {
        return supplier;
    }

    public void setSupplier(Contact supplier) {
        this.supplier = supplier;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getMinimumQuanity() {
        return minimumQuanity;
    }

    public void setMinimumQuanity(Integer minimumQuanity) {
        this.minimumQuanity = minimumQuanity;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Boolean getShowAlertOnQuantity() {
        return showAlertOnQuantity;
    }

    public void setShowAlertOnQuantity(Boolean showAlertOnQuantity) {
        this.showAlertOnQuantity = showAlertOnQuantity;
    }

    public Boolean getShowAlertOnExpirationDate() {
        return showAlertOnExpirationDate;
    }

    public void setShowAlertOnExpirationDate(Boolean showAlertOnExpirationDate) {
        this.showAlertOnExpirationDate = showAlertOnExpirationDate;
    }



    public List<Purchase> getPurchase() {
        return purchase;
    }

    public void setPurchase(List<Purchase> purchase) {
        this.purchase = purchase;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Item other = (Item) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    public Item(String name) {
        super();
        this.name = name;
    }

    public Item(Integer id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public Item() {
        super();
    }


    
    

}
