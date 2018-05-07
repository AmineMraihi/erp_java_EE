package tn.esprit.b1.esprit1718b1erp.mbeans;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import tn.esprit.b1.esprit1718b1erp.entities.Depot;
import tn.esprit.b1.esprit1718b1erp.services.amine.DepotService;

@ManagedBean
@SessionScoped
public class DepotBean {

    private String name;
    
    private String place;
    
    @EJB
    DepotService depotService;
    
    
    public void addDepot() {
        Depot d=new Depot();
        d.setName(this.name);
        d.setPlace(this.place);
        
        System.out.println(this.name);
        System.out.println(this.place);
        depotService.save(d);
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
    
    
    
}
