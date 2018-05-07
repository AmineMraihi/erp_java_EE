package tn.esprit.b1.esprit1718b1erp.mbeans;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.flow.FlowScoped;

import tn.esprit.b1.esprit1718b1erp.entities.Category;
import tn.esprit.b1.esprit1718b1erp.entities.Contact;
import tn.esprit.b1.esprit1718b1erp.entities.Depot;
import tn.esprit.b1.esprit1718b1erp.entities.Item;
import tn.esprit.b1.esprit1718b1erp.entities.Item_Type;
import tn.esprit.b1.esprit1718b1erp.entities.MachineType;
import tn.esprit.b1.esprit1718b1erp.entities.Row;
import tn.esprit.b1.esprit1718b1erp.entities.Tier;
import tn.esprit.b1.esprit1718b1erp.services.amine.CategoryService;
import tn.esprit.b1.esprit1718b1erp.services.amine.DepotService;
import tn.esprit.b1.esprit1718b1erp.services.amine.ItemService;
import tn.esprit.b1.esprit1718b1erp.services.amine.RowService;
import tn.esprit.b1.esprit1718b1erp.services.amine.TierService;
import tn.esprit.b1.esprit1718b1erp.services.jassem.ContactService;

@ManagedBean
@SessionScoped
public class ItemBean {

    private String name;

    private String description;

    private Integer categoryId;

    private Integer barcode;

    private Item_Type type;

    private Integer quantity;

    private Float byingPrice;

    private Float sellingPrice;

    private Integer supplierId;

    private String picture;

    private List<Category> categories;

    private List<Contact> suppliers;

    private List<Item> items;

    private Date managedDate;

    private MachineType machinetype;

    private boolean availability;

    private Item itemDetails;

    private Item i;

    private List<Depot> depots;

    private List<Row> rows;

    private List<Tier> tiers;

    private Integer depotId;

    private Integer rowId;

    private Integer tierId;

    private Long overallQuantities;

    private Depot depotDetails;

    private Row rowDetails;

    private Tier tierDetails;

    @ManagedProperty(value = "#{identity}")
    private Identity identity;

    @EJB
    ItemService itemService;

    @EJB
    CategoryService categoryService;

    @EJB
    ContactService contactService;

    @EJB
    DepotService depotService;

    @EJB
    RowService rowService;

    @EJB
    TierService tierService;

    @PostConstruct
    void init() {
        categories = categoryService.findAll();
        suppliers = contactService.findAll();
        i = new Item();
        depotId = 1;
        rowId = 1;
    }

    public List<Row> trys(int i) {
        return rowService.getRowsByDepotId(i);
    }

    public List<Tier> tryss(int i) {
        return tierService.gettiersByRowId(i);
    }
    
    public List<Tier> tryssForAdd(int i) {
        return tierService.gettiersByRowIdForAdd(i);
    }
    
    public List<Item> getItemsByDepotId(int i){
        return itemService.getItemsByDepotId(i);
    }

    public List<Item> getItemsByTierId(int i) {
        return itemService.getItemsByTierId(i);
    }
    
    public BigInteger getNumberOfRowsByDepotId(int i) {
        return rowService.getNumberOfRowsByDepotId(i);
    }
    
    public BigInteger getNumberOfTiersByDepotId(int i) {
        return tierService.getNumberOfTiersByDepotId(i);
    }
    
    public BigInteger getNumberOfItemsByDepotId(int i) {
        return itemService.getNumberOfItemsByDepotId(i);
    }
    
    public List<Item> getItemAlert(){
        return itemService.getItemsOnAlert();
    }

    public void addItem() {
        i.setName(this.name);
        i.setDescription(this.description);


        Category category = itemService.getCategoryById(categoryId);
        Contact supplier = itemService.getSupplierById(supplierId);

        i.setCategory(category);
        i.setQuantity(this.quantity);
        i.setByingPrice(this.byingPrice);
        i.setSellingPrice(this.sellingPrice);
        i.setSupplier(supplier);
        i.setBarcode(this.barcode);
        i.setUser(identity.getUser());
        managedDate = new Date();
        i.setLastUpdatedDate(managedDate);

        // new funct

        Tier t = new Tier();
        t = tierService.find(tierId);
        i.setTier(t);

        // end new funct

        itemService.save(i);

    }

    public void onDepotChanged() {
        rows = new ArrayList<>();
        rows = rowService.getRowsByDepotId(depotId);
        rows.clear();
        rows = rowService.getRowsByDepotId(depotId);
    }

    public void onRowChanged() {
        tiers = new ArrayList<>();
        tiers = tierService.gettiersByRowId(rowId);
        tiers.clear();
        tiers = tierService.gettiersByRowId(rowId);
    }

    public void updateItem() {

        managedDate = new Date();

        Category category = itemService.getCategoryById(categoryId);
        Contact supplier = itemService.getSupplierById(supplierId);
        itemDetails.setCategory(category);
        itemDetails.setSupplier(supplier);
        itemDetails.setLastUpdatedDate(managedDate);
        itemService.update(itemDetails);
    }

    public String toItemDetails(int i) {
        itemDetails = itemService.find(i);
        return "/itemDetails?faces-redirect=true";
    }

    public String toItemEdit(int i) {
        itemDetails = itemService.find(i);
        return "/itemEdit?faces-redirect=true";
    }
    
    public String toItemImportPage(int i) {
        itemDetails = itemService.find(i);
        return "/importItemPage?faces-redirect=true";
    }
    
    public void updateImportedItem(int i) {
        itemDetails=itemService.find(i);
        itemDetails.setQuantity(itemDetails.getQuantity()+this.quantity);
        itemService.update(itemDetails);
    }

    public void fillItemEdit(int i) {
        itemDetails = itemService.find(i);
        this.name = itemDetails.getName();

    }

    public void deleteItem(Integer i) {
        itemService.deleteItemById(i);
    }

    public String toDepotDetails(Integer i) {
        depotDetails = depotService.find(i);
        return "/depotDetail?faces-redirect=true";
    }

    public List<Depot> getDepots() {
        return depotService.findAll();
    }

    public void setDepots(List<Depot> depots) {
        this.depots = depots;
    }

    public List<Row> getRows() {

        // if ((rowService.findAll() != null && rowService.getRowsByDepotId(depotId) !=
        // null)
        // && rowService.findAll().size() > rowService.getRowsByDepotId(depotId).size())
        // {
        // return rowService.getRowsByDepotId(depotId);
        // }

        return rowService.findAll();
    }

    public void setRows(List<Row> rows) {
        this.rows = rows;
    }

    public List<Tier> getTiers() {
        return tierService.findAll();
    }

    public void setTiers(List<Tier> tiers) {
        this.tiers = tiers;
    }

    public Integer getDepotId() {
        return depotId;
    }

    public void setDepotId(Integer depotId) {
        this.depotId = depotId;
    }

    public Integer getRowId() {
        return rowId;
    }

    public void setRowId(Integer rowId) {
        this.rowId = rowId;
    }

    public Integer getTierId() {
        return tierId;
    }

    public void setTierId(Integer tierId) {
        this.tierId = tierId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getBarcode() {
        return barcode;
    }

    public void setBarcode(Integer barcode) {
        this.barcode = barcode;
    }

    public Item_Type getType() {
        return type;
    }

    public void setType(Item_Type type) {
        this.type = type;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getByingPrice() {
        return byingPrice;
    }

    public void setByingPrice(Float byingPrice) {
        this.byingPrice = byingPrice;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public ItemService getItemService() {
        return itemService;
    }

    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Contact> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<Contact> suppliers) {
        this.suppliers = suppliers;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public List<Item> getItems() {
        return itemService.findAll();
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Date getManagedDate() {
        return managedDate;
    }

    public void setManagedDate(Date managedDate) {
        this.managedDate = managedDate;
    }

    public Item getItemDetails() {
        return itemDetails;
    }

    public void setItemDetails(Item itemDetails) {
        this.itemDetails = itemDetails;
    }

    public Item getI() {
        return i;
    }

    public void setI(Item i) {
        this.i = i;
    }

    public Identity getIdentity() {
        return identity;
    }

    public void setIdentity(Identity identity) {
        this.identity = identity;
    }

    public Float getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Float sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public Long getOverallQuantities() {
        return itemService.sumOfQuantities();
    }

    public void setOverallQuantities(Long overallQuantities) {
        this.overallQuantities = overallQuantities;
    }

    public MachineType getMachinetype() {
        return machinetype;
    }

    public void setMachinetype(MachineType machinetype) {
        this.machinetype = machinetype;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public Depot getDepotDetails() {
        return depotDetails;
    }

    public void setDepotDetails(Depot depotDetails) {
        this.depotDetails = depotDetails;
    }

    public Row getRowDetails() {
        return rowDetails;
    }

    public void setRowDetails(Row rowDetails) {
        this.rowDetails = rowDetails;
    }

    public Tier getTierDetails() {
        return tierDetails;
    }

    public void setTierDetails(Tier tierDetails) {
        this.tierDetails = tierDetails;
    }

}
