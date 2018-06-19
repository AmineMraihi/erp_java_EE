package tn.esprit.b1.esprit1718b1erp.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.b1.esprit1718b1erp.entities.Contact;


@ManagedBean
@SessionScoped
public class CommandeBean {
    private List<Integer> list = new ArrayList<>();
    private Integer amount;
    public List<Integer> getList() {
        for(int i=1; i<100;i++)
            list.add(i);
        return list;
    }
    public void setList(List<Integer> list) {
        this.list = list;
    }
    public Integer getAmount() {
        return amount;
    }
    public void setAmount(Integer amount) {
        this.amount = amount;
    }





  
    
    
    
    

}