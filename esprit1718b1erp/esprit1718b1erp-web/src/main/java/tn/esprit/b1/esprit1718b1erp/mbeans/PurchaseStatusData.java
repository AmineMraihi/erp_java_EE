package tn.esprit.b1.esprit1718b1erp.mbeans;

import javax.faces.bean.ManagedBean;

import tn.esprit.b1.esprit1718b1erp.entities.Statupurchase;

import javax.faces.bean.ApplicationScoped;

@ManagedBean
@ApplicationScoped
public class PurchaseStatusData {
    public Statupurchase[] getRoles() {
        return Statupurchase.values();
    }
}
