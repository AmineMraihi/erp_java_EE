package tn.esprit.b1.esprit1718b1erp.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Check implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id_Check;
    @Enumerated(EnumType.STRING)
    private TypeCheck typeCheck;
    private String Description;
    @Temporal(TemporalType.DATE)
    private Date date_payement_check;
    Float Montant;

    public Integer getId_Check() {
        return Id_Check;
    }

    public void setId_Check(Integer id_Check) {
        Id_Check = id_Check;
    }

    public TypeCheck getTypeCheck() {
        return typeCheck;
    }

    public void setTypeCheck(TypeCheck typeCheck) {
        this.typeCheck = typeCheck;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Date getDate_payement_check() {
        return date_payement_check;
    }

    public void setDate_payement_check(Date date_payement_check) {
        this.date_payement_check = date_payement_check;
    }

    public Float getMontant() {
        return Montant;
    }

    public void setMontant(Float montant) {
        Montant = montant;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Check(Integer id_Check, TypeCheck typeCheck, String description, Date date_payement_check, Float montant) {
        super();
        Id_Check = id_Check;
        this.typeCheck = typeCheck;
        Description = description;
        this.date_payement_check = date_payement_check;
        Montant = montant;
    }

    public Check() {
        super();
    }

}
