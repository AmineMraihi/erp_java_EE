package tn.esprit.b1.esprit1718b1erp.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class General_Ledeger implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id_General_Ledeger;

    @OneToMany(mappedBy = "general_Ledeger_sale")
    private List<Sale> sale;

    @OneToMany(mappedBy = "general_Ledeger")
    private List<Purchase> purchases;

}
