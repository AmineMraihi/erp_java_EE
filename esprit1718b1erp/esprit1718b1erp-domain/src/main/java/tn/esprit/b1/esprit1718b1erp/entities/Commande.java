package tn.esprit.b1.esprit1718b1erp.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Commande implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_Commande;
    
    @OneToOne(mappedBy="commande")
    private Purchase purchase;
    
    @OneToOne(mappedBy="commandesale")
    private Sale sale;
    
    
}