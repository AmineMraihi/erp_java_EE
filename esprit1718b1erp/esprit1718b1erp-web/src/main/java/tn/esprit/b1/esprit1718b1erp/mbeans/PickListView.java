package tn.esprit.b1.esprit1718b1erp.mbeans;
 
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
 
import org.primefaces.event.TransferEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.DualListModel;

import tn.esprit.b1.esprit1718b1erp.entities.Item;
import tn.esprit.b1.esprit1718b1erp.services.amine.ItemService;

 
@ManagedBean
public class PickListView {
     
	@EJB
	ItemService service;
    
    private Item item;
     
    private DualListModel<String> cities;
    private DualListModel<Item> themes;
     
    @PostConstruct
    public void init() {
        //Cities
        List<String> citiesSource = new ArrayList<String>();
        List<String> citiesTarget = new ArrayList<String>();
         
        citiesSource.add("San Francisco");
        citiesSource.add("London");
        citiesSource.add("Paris");
        citiesSource.add("Istanbul");
        citiesSource.add("Berlin");
        citiesSource.add("Barcelona");
        citiesSource.add("Rome");
         
        cities = new DualListModel<String>(citiesSource, citiesTarget);
         
        //Themes
        List<Item> themesSource = service.getMachineList("For maintain");
        List<Item> themesTarget = new ArrayList<Item>();
         
        themes = new DualListModel<Item>(themesSource, themesTarget);
         
    }
 
    public DualListModel<String> getCities() {
        return cities;
    }
 
    public void setCities(DualListModel<String> cities) {
        this.cities = cities;
    }
 
 
     
    public ItemService getService() {
		return service;
	}

	public void setService(ItemService service) {
		this.service = service;
	}

	public DualListModel<Item> getThemes() {
		return themes;
	}

	public void setThemes(DualListModel<Item> themes) {
		this.themes = themes;
	}

	public void onTransfer(TransferEvent event) {
        StringBuilder builder = new StringBuilder();
        for(Object item : event.getItems()) {
            builder.append(((Item) item).getName()).append("<br />");
        }
         
        FacesMessage msg = new FacesMessage();
        msg.setSeverity(FacesMessage.SEVERITY_INFO);
        msg.setSummary("Items Transferred");
        msg.setDetail(builder.toString());
         
        FacesContext.getCurrentInstance().addMessage(null, msg);
    } 
 
    public void onSelect(SelectEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Item Selected", event.getObject().toString()));
    }
     
    public void onUnselect(UnselectEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Item Unselected", event.getObject().toString()));
    }
     
    public void onReorder() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "List Reordered", null));
    }

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
    
}