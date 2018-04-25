package tn.esprit.b1.esprit1718b1erp.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee_payment implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id_Employee_payment;
    Integer Extra_houres;
    Float Somme_perday;
    Float Somme_permonth;

    public Integer getId_Employee_payment() {
        return Id_Employee_payment;
    }

    public void setId_Employee_payment(Integer id_Employee_payment) {
        Id_Employee_payment = id_Employee_payment;
    }

    public Integer getExtra_houres() {
        return Extra_houres;
    }

    public void setExtra_houres(Integer extra_houres) {
        Extra_houres = extra_houres;
    }

    public Float getSomme_perday() {
        return Somme_perday;
    }

    public void setSomme_perday(Float somme_perday) {
        Somme_perday = somme_perday;
    }

    public Float getSomme_permonth() {
        return Somme_permonth;
    }

    public void setSomme_permonth(Float somme_permonth) {
        Somme_permonth = somme_permonth;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

}
