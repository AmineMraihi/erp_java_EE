package tn.esprit.b1.esprit1718b1erp.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Row implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String abcRows;

    @ManyToOne
    private Depot depot;
    
    @OneToMany(mappedBy="row")
    private List<Tier> rowTiers;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Depot getDepot() {
        return depot;
    }

    public void setDepot(Depot depot) {
        this.depot = depot;
    }

    public List<Tier> getRowTiers() {
        return rowTiers;
    }

    public void setRowTiers(List<Tier> rowTiers) {
        this.rowTiers = rowTiers;
    }

    public String getAbcRows() {
        return abcRows;
    }

    public void setAbcRows(String abcRows) {
        this.abcRows = abcRows;
    }

    @Override
    public String toString() {
        return "Row [abcRows=" + abcRows + "]";
    }

   

  

}
