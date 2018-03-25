package tn.esprit.b1.esprit1718b1erp.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ItemRequest implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer quantityNeeded;

    @OneToOne
    private Item item;

    @OneToOne
    private Contact supplier;

    @Enumerated(EnumType.STRING)
    private ItemRequestStatus itemRequestStatus;

    public Integer getId() {
        return id;
    }

    public Integer getQuantityNeeded() {
        return quantityNeeded;
    }

    public void setQuantityNeeded(Integer quantityNeeded) {
        this.quantityNeeded = quantityNeeded;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Contact getSupplier() {
        return supplier;
    }

    public void setSupplier(Contact supplier) {
        this.supplier = supplier;
    }

    public ItemRequestStatus getItemRequestStatus() {
        return itemRequestStatus;
    }

    public void setItemRequestStatus(ItemRequestStatus itemRequestStatus) {
        this.itemRequestStatus = itemRequestStatus;
    }

    @Override
    public String toString() {
        return "ItemRequest [item=" + item + "]";
    }
    
    

}
