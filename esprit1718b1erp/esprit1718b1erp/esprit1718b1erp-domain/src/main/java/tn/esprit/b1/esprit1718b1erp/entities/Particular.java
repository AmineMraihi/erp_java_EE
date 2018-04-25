package tn.esprit.b1.esprit1718b1erp.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue(value = "particular")
public class Particular extends Contact implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String first_name;
    private String positionHeld;
    private String civility;

    @ManyToOne
    private Entreprise company;

    public Particular() {

    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getPositionHeld() {
        return positionHeld;
    }

    public void setPositionHeld(String positionHeld) {
        this.positionHeld = positionHeld;
    }

    public String getCivility() {
        return civility;
    }

    public void setCivility(String civility) {
        this.civility = civility;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Entreprise getCompany() {
        return company;
    }

    public void setCompany(Entreprise company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Particular [first_name=" + first_name + ", positionHeld=" + positionHeld + ", civility=" + civility
                + "]";
    }

}
