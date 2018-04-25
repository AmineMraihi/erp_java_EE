package tn.esprit.b1.esprit1718b1erp.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "entreprise")
public class Entreprise extends Contact implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public Entreprise() {

    }

}
