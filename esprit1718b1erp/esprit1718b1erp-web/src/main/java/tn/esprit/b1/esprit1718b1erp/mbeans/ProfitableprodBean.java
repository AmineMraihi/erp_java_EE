package tn.esprit.b1.esprit1718b1erp.mbeans;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import javafx.collections.ObservableList;
import tn.esprit.b1.esprit1718b1erp.entities.Item;
import tn.esprit.b1.esprit1718b1erp.entities.Purchase;
import tn.esprit.b1.esprit1718b1erp.services.ahmed.NeedService;
import tn.esprit.b1.esprit1718b1erp.services.ahmed.PurchaseService;

@ManagedBean
@SessionScoped
public class ProfitableprodBean {
    
    
    
    @EJB
    private PurchaseService purchaseService;
    @EJB
    NeedService NeedService;

    
    @PostConstruct
    void init() {
        
    
        Map<String, Number> hhh = new HashMap<String, Number>(purchaseService.sommetot_purchase()); 
        System.out.println(hhh);
        System.out.println("hhhhhhhhhhhhhhhhhhhhhhh");
        
       
    }

}
