package tn.esprit.b1.esprit1718b1erp.mbeans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import tn.esprit.b1.esprit1718b1erp.entities.Purchase_type;

@ManagedBean
@ApplicationScoped
public class Purchase_typeData {
    public Purchase_type[] getRoles() {
        return Purchase_type.values();
    }

}
