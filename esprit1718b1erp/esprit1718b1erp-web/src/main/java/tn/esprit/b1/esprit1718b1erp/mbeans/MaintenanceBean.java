package tn.esprit.b1.esprit1718b1erp.mbeans;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.flow.FlowScoped;
import javax.faces.model.SelectItem;
import javax.servlet.RequestDispatcher;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tn.esprit.b1.esprit1718b1erp.mbeans.Identity;
import tn.esprit.b1.esprit1718b1erp.entities.Breakdown;
import tn.esprit.b1.esprit1718b1erp.entities.BreakdownState;
import tn.esprit.b1.esprit1718b1erp.entities.Category;
import tn.esprit.b1.esprit1718b1erp.entities.Contact;
import tn.esprit.b1.esprit1718b1erp.entities.Intervention;
import tn.esprit.b1.esprit1718b1erp.entities.InterventionPriority;
import tn.esprit.b1.esprit1718b1erp.entities.InterventionStatus;
import tn.esprit.b1.esprit1718b1erp.entities.InterventionType;
import tn.esprit.b1.esprit1718b1erp.entities.Item;
import tn.esprit.b1.esprit1718b1erp.entities.Item_Type;
import tn.esprit.b1.esprit1718b1erp.entities.MachineType;
import tn.esprit.b1.esprit1718b1erp.entities.User;
import tn.esprit.b1.esprit1718b1erp.entities.UserFunction;
import tn.esprit.b1.esprit1718b1erp.services.UserService;
import tn.esprit.b1.esprit1718b1erp.services.amine.CategoryService;
import tn.esprit.b1.esprit1718b1erp.services.amine.ItemService;
import tn.esprit.b1.esprit1718b1erp.services.jassem.ContactService;
import tn.esprit.b1.esprit1718b1erp.services.malek.InterventionService;
import tn.esprit.b1.esprit1718b1erp.services.malek.BreakdownService;

@ManagedBean
@SessionScoped
public class MaintenanceBean {

	private String observation;

	private String description;

	private InterventionType interventiontype;

	private InterventionPriority priority;

	private InterventionStatus interventionstatus;

	private UserFunction userfunction;

	private String category;

	private String itemname;

	private Integer itemId;
	
	private Long usercode;
	private List<Number> productsname_sale = new ArrayList<>();


	private List<User> users;
	private List<Intervention> interventions;
	private List<Breakdown> breakdowns;
	private List<Breakdown> filteredbreakdown;

	private MachineType machinetype;

	private List<Item> items;

	private List<Item> maintain;

	private List<Item> maintainselected;

	private Date desireddate;

	private Boolean availability;

	private Date requestdate;
	
	private Date nextmaintenance;
	
	private Date durationguarantee;
	
	private Date Breakdowndate;

	private Intervention interventionDetails;
	
	private Item itemDetails;

	private Breakdown breakdownDetails;

	private Item item;

	private User repairer;

	private Integer userid;

	private Intervention i;

	private Breakdown b;

	@EJB
	InterventionService interventionService;

	@EJB
	BreakdownService breakdownService;

	@EJB
	ItemService itemService;

	@EJB
	UserService userService;
    List<String> xvaluefor_axis;

	Set<Item> maintainselectedset = new HashSet<Item>();
    List<String> ordredProdNames;

	 private List<SelectItem> cars;
	    private Item[] selectedCars;
	 


	@PostConstruct
	void init() {
		// String cat;
		users = userService.findByFunction(userfunction.TECHNICIAN);
		items = itemService.getMachineList("Machine");
		maintain = itemService.getMachineList("For maintain");
		

		breakdowns = breakdownService.findAll();
		System.out.println(items);
		requestdate = new Date();
		desireddate = new Date();
		durationguarantee = new Date();
		nextmaintenance = new Date();
		

		i = new Intervention();
		b = new Breakdown();
		itemDetails = new Item();
	}

	public void addIntervention() {
		/*
		 * i.setDescription(this.description);
		 * 
		 * // items = itemService.getMachineList("Machine"); // Item item =
		 * itemService.getMachine(cat)
		 * i.setInterventiontype(this.interventiontype);
		 * i.setPriority(this.priority);
		 * 
		 * i.setDesireddate(this.desireddate); // i.setApplicant();
		 */ 
		i.setItem(itemService.find(itemId));
		i.setDescription(this.description);
		i.setItemname(itemService.find(itemId).getName());
		i.setDesireddate(this.desireddate);
		i.setInterventionstatus(this.interventionstatus);
		i.setInterventiontype(this.interventiontype);
		i.setPriority(this.priority);
		i.setRequestdate(this.requestdate);
		/*Identity id = new Identity();
		i.setApplicant(id.getUser());*/

		interventionService.save(i);

	}

	public boolean filterByPrice(Object value, Object filter, Locale locale) {
		String filterText = (filter == null) ? null : filter.toString().trim();
		if (filterText == null || filterText.equals("")) {
			return true;
		}

		if (value == null) {
			return false;
		}

		return ((Comparable) value).compareTo(Integer.valueOf(filterText)) > 0;
	}

	public void addBreakdown() {
		Breakdowndate = new Date();
		b.setObjecttomaintain(interventionDetails.getItem());
		b.setRegistrationdate(Breakdowndate);
		b.setBreakdowndate(interventionDetails.getRequestdate());
		if (interventionDetails.getInterventionstatus().toString().equals("UNTREATED")) {
			b.setBreakdownstate(BreakdownState.UNTREATED);
		} else if (interventionDetails.getInterventionstatus().toString().equals("TREATED")) {
			b.setBreakdownstate(BreakdownState.TREATED);
		}
		// b.setRepairer(interventionDetails.getRepairer());
		breakdownService.save(b);
	}

	public void updateItem() {

		interventionService.update(interventionDetails);
	}
	public void updateItem2() {
		interventionDetails.setRepairer(userService.findByCode(usercode));
		interventionService.update(interventionDetails);
	}

	public void updateItem1(Item item) {

		itemService.update(item);
	}

	public void updateBreakdownitem() {

		
		 breakdownDetails.setItems(maintainselectedset);
		  breakdownService.update(breakdownDetails);
		 
		System.out.println(maintainselectedset + "YE NAAAAAAAAAWFEL");

	}
	 public List itemBreakdownCost(){
		        List<String> sub2 = new ArrayList<>();
		        List<Integer> fg = new ArrayList<>();
		       // Map<String, Number> hhh = new HashMap<String, Number>(purchaseService.sommetot_purchase());
		        Map<String, Number> aaaa = new HashMap<String, Number>(breakdownService.itemBreakdownCost());
		        HashMap<String, Integer> thisistheone = new HashMap<String, Integer>();

		        List<String> ordredProdNames;
		        double kk;
		        Integer ab = null;
		        xvaluefor_axis = new ArrayList<>();

		  
		        Set finalset = aaaa.entrySet();
		        Iterator iter = finalset.iterator();
		        ordredProdNames = new ArrayList<>();
		        while (iter.hasNext()) {

		            Map.Entry me = (Map.Entry) iter.next();

		            ///// System.out.print("key s is: " + me.getKey() + " & Value S is:
		            ///// " + me.getValue() + "\n");

		            ordredProdNames.add((String) me.getKey());
		        }

		        sub2 = ordredProdNames.subList(0, 2);
		        return sub2;

		    	    }
	 
	 public List itemBreakdownCost1(){
	        List<Double> sub1 = new ArrayList<>();
	        List<Integer> fg = new ArrayList<>();
	       // Map<String, Number> hhh = new HashMap<String, Number>(purchaseService.sommetot_purchase());
	        Map<String, Number> aaaa = new HashMap<String, Number>(breakdownService.itemBreakdownCost());
	        HashMap<String, Integer> thisistheone = new HashMap<String, Integer>();

	        List<Double> ordredProdNames1;
	        double kk;
	        Integer ab = null;
	        xvaluefor_axis = new ArrayList<>();

	  
	        Set finalset = aaaa.entrySet();
	        Iterator iter = finalset.iterator();
	        ordredProdNames1 = new ArrayList<>();
	        while (iter.hasNext()) {

	            Map.Entry me = (Map.Entry) iter.next();

	            ///// System.out.print("key s is: " + me.getKey() + " & Value S is:
	            ///// " + me.getValue() + "\n");

	            ordredProdNames1.add((Double) me.getValue());
	        }

	        sub1 = ordredProdNames1.subList(0, 2);
	        return sub1;

	    	    }
	 
	public Number calculprice(){
		List<Number> productsname_sale = new ArrayList<>();
		List<Float> prix=new ArrayList<>();

        Map<Number, Number> hhh = new HashMap<Number, Number>(breakdownService.sommetot_purchase());
        System.out.println(hhh+"YALLAAAAAAAAH");
        Set set = hhh.entrySet();
        Iterator iterator = set.iterator();

        Map.Entry mentrysale;
        while (iterator.hasNext()) {

            mentrysale = (Map.Entry) iterator.next();

            System.out.print("key s is: " + mentrysale.getKey() + " & Value S is: " + mentrysale.getValue() + "\n");
            if(mentrysale.getKey().equals(breakdownDetails.getId())){
            productsname_sale.add( (Number) mentrysale.getValue());}
        }
        System.out.println(productsname_sale.get(0).floatValue()+"SALUTWIW");
        breakdownDetails.setPrice(productsname_sale.get(0).floatValue());
      breakdownService.update(breakdownDetails);
		return productsname_sale.get(0);
	}

	public String updateBreakdown() {

		breakdownService.update(breakdownDetails);
		return "/breakdownPrice?faces-redirect=true\"";

	}

	public String toInterventionDetails(int i) {
		interventionDetails = interventionService.find(i);
		return "/interventionDetails?faces-redirect=true\"";
	}

	public String toInterventionEdit(Integer i) {
		interventionDetails = interventionService.find(i);
		if (interventionDetails.getItem().getAvailability() == null) {
			return "/itemavailability?faces-redirect=true\"";
		} else {
			return "/interventionedit?faces-redirect=true\"";
		}
	}

	public String toBreakdownEdit(Integer i) {
		breakdownDetails = breakdownService.find(i);
		return "/breakdownedit?faces-redirect=true\"";

	}
	
	public String itemstat(Integer i) {
		itemDetails = itemService.find(i);
		return "/itembreak?faces-redirect=true\"";

	}
	public BigInteger ItemBreakdownPerMonth1()
    {
        return breakdownService.itemBreakdownPerMonth(1,itemDetails);
    }
    public BigInteger ItemBreakdownPerMonth2()
    {
        return breakdownService.itemBreakdownPerMonth(2,itemDetails);
    }
    public BigInteger ItemBreakdownPerMonth3()
    {
        return breakdownService.itemBreakdownPerMonth(3,itemDetails);
    }
    public BigInteger ItemBreakdownPerMonth4()
    {
    	System.out.println(breakdownService.itemBreakdownPerMonth(5,itemDetails)+"AFIICHIII WOOY2222");
        return breakdownService.itemBreakdownPerMonth(4,itemDetails);
    }
    public BigInteger ItemBreakdownPerMonth5()
    {
    	System.out.println(breakdownService.itemBreakdownPerMonth(5,itemDetails)+"AFIICHIII WOOY");
        return breakdownService.itemBreakdownPerMonth(5,itemDetails);
    	//return 2.0;
    }
    public BigInteger ItemBreakdownPerMonth6()
    {
        return breakdownService.itemBreakdownPerMonth(6,itemDetails);
    }
    public BigInteger ItemBreakdownPerMonth7()
    {
        return breakdownService.itemBreakdownPerMonth(7,itemDetails);
    }
	public void fillItemEdit(int i) {
		System.out.println(i);
		interventionDetails = interventionService.find(i);
		this.itemname = interventionDetails.getItemname();

	}

	public void deleteIntervention(Integer i) {
		interventionService.deleteInterventionById(i);
	}

	public void deleteBreakdown(Integer i) {
		breakdownService.deleteBreakdownById(i);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ItemService getItemService() {
		return itemService;
	}

	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}

	public List<Item> getItems() {
		return itemService.findAll();
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public void setI(Intervention i) {
		this.i = i;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public InterventionType getInterventiontype() {
		return interventiontype;
	}

	public void setInterventiontype(InterventionType interventiontype) {
		this.interventiontype = interventiontype;
	}

	public InterventionPriority getPriority() {
		return priority;
	}

	public void setPriority(InterventionPriority priority) {
		this.priority = priority;
	}

	public InterventionStatus getInterventionstatus() {
		return interventionstatus;
	}

	public void setInterventionstatus(InterventionStatus interventionstatus) {
		this.interventionstatus = interventionstatus;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public MachineType getMachinetype() {
		return machinetype;
	}

	public void setMachinetype(MachineType machinetype) {
		this.machinetype = machinetype;
	}

	public Date getDesireddate() {
		return desireddate;
	}

	public void setDesireddate(Date desireddate) {
		this.desireddate = desireddate;
	}

	public Intervention getInterventionDetails() {
		return interventionDetails;
	}

	public UserFunction getUserfunction() {
		return userfunction;
	}

	public void setUserfunction(UserFunction userfunction) {
		this.userfunction = userfunction;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public Boolean getAvailability() {
		return availability;
	}

	public void setAvailability(Boolean availability) {
		this.availability = availability;
	}

	public void setInterventionDetails(Intervention interventionDetails) {
		this.interventionDetails = interventionDetails;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public User getRepairer() {
		return repairer;
	}

	public void setRepairer(User repairer) {
		this.repairer = repairer;
	}

	public InterventionService getInterventionService() {
		return interventionService;
	}

	public void setInterventionService(InterventionService interventionService) {
		this.interventionService = interventionService;
	}

	public BreakdownService getBreakdownService() {
		return breakdownService;
	}

	public void setBreakdownService(BreakdownService breakdownService) {
		this.breakdownService = breakdownService;
	}

	public Intervention getI() {
		return i;
	}

	public List<Intervention> getInterventions() {
		interventions = interventionService.findAll();
		return interventions;
	}

	public void setInterventions(List<Intervention> interventions) {
		this.interventions = interventions;
	}

	public List<Breakdown> getBreakdowns() {
		breakdowns = breakdownService.findAll();
		return breakdowns;
	}

	public void setBreakdowns(List<Breakdown> breakdowns) {
		this.breakdowns = breakdowns;
	}

	public Date getBreakdowndate() {
		return Breakdowndate;
	}

	public void setBreakdowndate(Date breakdowndate) {
		Breakdowndate = breakdowndate;
	}

	public Breakdown getB() {
		return b;
	}

	public void setB(Breakdown b) {
		this.b = b;
	}

	public Date getRequestdate() {
		return requestdate;
	}

	public void setRequestdate(Date requestdate) {
		this.requestdate = requestdate;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Breakdown getBreakdownDetails() {
		return breakdownDetails;
	}

	public void setBreakdownDetails(Breakdown breakdownDetails) {
		this.breakdownDetails = breakdownDetails;
	}

	public List<Breakdown> getFilteredbreakdown() {
		return filteredbreakdown;
	}

	public void setFilteredbreakdown(List<Breakdown> filteredbreakdown) {
		this.filteredbreakdown = filteredbreakdown;
	}

	public List<Item> getMaintain() {
		return maintain;
	}

	public void setMaintain(List<Item> maintain) {
		this.maintain = maintain;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public List<Item> getMaintainselected() {
		return maintainselected;
	}

	public void setMaintainselected(List<Item> maintainselected) {
		this.maintainselected = maintainselected;
	}

	public Long getUsercode() {
		return usercode;
	}

	public void setUsercode(Long usercode) {
		this.usercode = usercode;
	}

	public List<Number> getProductsname_sale() {
		return productsname_sale;
	}

	public void setProductsname_sale(List<Number> productsname_sale) {
		this.productsname_sale = productsname_sale;
	}

	public Set<Item> getMaintainselectedset() {
		return maintainselectedset;
	}

	public void setMaintainselectedset(Set<Item> maintainselectedset) {
		this.maintainselectedset = maintainselectedset;
	}

	public Item getItemDetails() {
		return itemDetails;
	}

	public void setItemDetails(Item itemDetails) {
		this.itemDetails = itemDetails;
	}

	public Date getNextmaintenance() {
		return nextmaintenance;
	}

	public void setNextmaintenance(Date nextmaintenance) {
		this.nextmaintenance = nextmaintenance;
	}

	public Date getDurationguarantee() {
		return durationguarantee;
	}

	public void setDurationguarantee(Date durationguarantee) {
		this.durationguarantee = durationguarantee;
	}

	public List<SelectItem> getCars() {
		return cars;
	}

	public void setCars(List<SelectItem> cars) {
		this.cars = cars;
	}

	public Item[] getSelectedCars() {
		return selectedCars;
	}

	public void setSelectedCars(Item[] selectedCars) {
		this.selectedCars = selectedCars;
	}

	
	
	
}
