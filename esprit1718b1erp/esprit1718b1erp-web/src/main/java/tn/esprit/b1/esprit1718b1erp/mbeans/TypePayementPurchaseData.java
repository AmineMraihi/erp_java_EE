package tn.esprit.b1.esprit1718b1erp.mbeans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import tn.esprit.b1.esprit1718b1erp.entities.TypePayementPurchase;

@ManagedBean
@ApplicationScoped
public class TypePayementPurchaseData {
    public TypePayementPurchase[] getRoles() {
        return TypePayementPurchase.values();
    }
}
