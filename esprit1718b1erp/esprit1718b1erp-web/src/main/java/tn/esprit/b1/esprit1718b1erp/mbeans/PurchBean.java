package tn.esprit.b1.esprit1718b1erp.mbeans;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.chart.PieChartModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tn.esprit.b1.esprit1718b1erp.entities.Contact;
import tn.esprit.b1.esprit1718b1erp.entities.Item;
import tn.esprit.b1.esprit1718b1erp.entities.Product;
import tn.esprit.b1.esprit1718b1erp.entities.Project;
import tn.esprit.b1.esprit1718b1erp.entities.Purchase;
import tn.esprit.b1.esprit1718b1erp.entities.Purchase_type;
import tn.esprit.b1.esprit1718b1erp.entities.Statupurchase;
import tn.esprit.b1.esprit1718b1erp.entities.TypePayementPurchase;
import tn.esprit.b1.esprit1718b1erp.services.ahmed.PurchaseService;
import tn.esprit.b1.esprit1718b1erp.services.amine.ItemService;
import tn.esprit.b1.esprit1718b1erp.services.UserService;
import tn.esprit.b1.esprit1718b1erp.services.ahmed.IntangiblesService;
import tn.esprit.b1.esprit1718b1erp.services.ahmed.NeedService;
import tn.esprit.b1.esprit1718b1erp.services.jassem.ContactService;
import tn.esprit.b1.esprit1718b1erp.services.shil.ProductService;
import tn.esprit.b1.esprit1718b1erp.services.youssfi.ProjectService;
import tn.esprit.b1.esprit1718b1erp.services.youssfi.TaskService;

@ManagedBean
@SessionScoped
public class PurchBean {
    private List<Contact> suppliers;
    private List<Product> Products;
    private Set<Item> items;
    private Date dateDemande;
    private Date dateRecu;

    private Integer Quantite;
    private TypePayementPurchase paymenttype;
    private Statupurchase statuspurch;
    private Float Somme;

    private String Dsecription;

    private Purchase_type typePurchase;
    private List<Purchase> purchases;

    private Integer supplierId;
    private Integer ProductId;

    private List<Integer> aze;

    private Purchase pp;

    private Purchase PurchaseDetails;

    private List <Project> listepROJECTS ;
    @EJB
    private PurchaseService purchaseService;
    @EJB
    ContactService contactService;
    @EJB
    ProductService productService;
    @EJB
    NeedService NeedService;
    @EJB
    TaskService taskService;
    @EJB
    ProjectService projectService ; 
    @EJB
    UserService userService;
    @EJB 
    ItemService itemService;
    @EJB 
    IntangiblesService intangiblesService ;
    List<String> xvaluefor_axis;
    List<Integer> azqs = new ArrayList<>();

    List<Integer> aazeee = new ArrayList<>();
    
    List <Double>  Sales_inLast5Years= new ArrayList<>();
    
    List <Double>  Purchase_inLast5Years= new ArrayList<>();
    List <Double>  CashTotal= new ArrayList<>();
    List <Double>  Inventory= new ArrayList<>();
    List <Double>  Net_Plan_Equipment= new ArrayList<>();
    List <Double>  Intagible= new ArrayList<>();
    List <String>  asset= new ArrayList<>();
    List <Double>  asset_pourcentage= new ArrayList<>();
    List <String>  cash_Vertical= new ArrayList<>();
    List <String>  Inventory_Vertical= new ArrayList<>(); 
    List <String>  Net_PlanV= new ArrayList<>(); 
    List <String>  IntagibleVert= new ArrayList<>();
    List <String>  assetVer= new ArrayList<>();
    
    public List listofprofitableonMoney() {

        List<Integer> sub = new ArrayList<>();
        List<Integer> fg = new ArrayList<>();
        Map<String, Number> hhh = new HashMap<String, Number>(purchaseService.sommetot_purchase());
        Map<String, Number> aaaa = new HashMap<String, Number>(NeedService.Need_somme());

        double kk;
        Integer ab = null;

        for (String key : hhh.keySet()) {
            if (aaaa.containsKey(key)) {

                double salett = aaaa.get(key).doubleValue();
                double purchasett = hhh.get(key).doubleValue();
                kk = salett - purchasett;
                ab = (int) kk;
                fg.add((int) kk);
                azqs.add(ab);

                Collections.sort(azqs);///// filtrer la liste
                Collections.reverse(azqs); /// pour l'ordre decroissant

            }
        }

        sub = azqs.subList(0, 4); /// prendre les 5 element de la liste

        ///// System.out.println(sub + "the final in the chart");

        return sub;

    }

    public List profitabl_prod_Names() {
        List<String> sub2 = new ArrayList<>();
        List<Integer> fg = new ArrayList<>();
        Map<String, Number> hhh = new HashMap<String, Number>(purchaseService.sommetot_purchase());
        Map<String, Number> aaaa = new HashMap<String, Number>(NeedService.Need_somme());
        HashMap<String, Integer> thisistheone = new HashMap<String, Integer>();

        List<String> ordredProdNames;
        double kk;
        Integer ab = null;
        xvaluefor_axis = new ArrayList<>();

        for (String key : hhh.keySet()) {
            if (aaaa.containsKey(key)) {
                //// System.out.println(aaaa.get(key) + "sale prod");
                /// System.out.println(hhh.get(key) + "purchase prod");
                ///// System.out.println(key + "mykey is");
                double salett = aaaa.get(key).doubleValue();
                double purchasett = hhh.get(key).doubleValue();
                kk = salett - purchasett;
                ab = (int) kk;
                fg.add((int) kk);
                aazeee.add(ab);
                thisistheone.put(key, ab);

                xvaluefor_axis.add(key);

            }
        }
        Set finalset = triAvecValeur(thisistheone).entrySet();
        Iterator iter = finalset.iterator();
        ordredProdNames = new ArrayList<>();
        while (iter.hasNext()) {

            Map.Entry me = (Map.Entry) iter.next();

            ///// System.out.print("key s is: " + me.getKey() + " & Value S is:
            ///// " + me.getValue() + "\n");

            ordredProdNames.add((String) me.getKey());
        }

        sub2 = ordredProdNames.subList(0, 4);
        return sub2;

    }

    @PostConstruct
    void init() throws ParseException {
     
        items = new HashSet<Item>();
        pp = new Purchase();
       
      
        suppliers = contactService.findAll();
        Products = productService.findAll();
        dateDemande = new Date();
        dateRecu = new Date();
        aze = new ArrayList<>(listofprofitableonMoney());

        System.out.println(profitabl_prod_Names() + "profitabl_prod_Names(");
        System.out.println(aze + "bbbbbbbbbbbbbbbbbbbbbbbbbbbb");
        System.out.println(ProjectNames ()+"ProjectNames ()");
        System.out.println(Somme_Tasks_parproject ()+"Somme_Tasks_parproject ()");
        System.out.println(Somme_TimeSpend_parproject()+"Somme_TimeSpend_parproject");
   
        Date date1 =new SimpleDateFormat("yyyy-mm-dd").parse("2014-12-31");
        Double D4= Math.abs(userService.Totalpay_Employee_parYear(date1,"2014"));
        Date date2 =new SimpleDateFormat("yyyy-mm-dd").parse("2015-12-31");
        Double D5= Math.abs(userService.Totalpay_Employee_parYear(date2,"2014"));
        Date date3 =new SimpleDateFormat("yyyy-mm-dd").parse("2016-12-31");
        Double D6= Math.abs(userService.Totalpay_Employee_parYear(date3,"2014"));
        Date date4 =new SimpleDateFormat("yyyy-mm-dd").parse("2017-12-31");
        Double D7= Math.abs(userService.Totalpay_Employee_parYear(date4,"2014"));
        Date date5 =new SimpleDateFormat("yyyy-mm-dd").parse("2018-12-31");
        Double D8= Math.abs(userService.Totalpay_Employee_parYear(date5,"2014"));
      
        Purchase_inLast5Years = purchaseService.Somme_Pur_intheLast5Years();
        Sales_inLast5Years = NeedService.Somme_Sales_inLast5Years();
        Double somme2014 = Sales_inLast5Years.get(0) - Purchase_inLast5Years.get(0)- D4;
        Double somme2015 = Sales_inLast5Years.get(1) - Purchase_inLast5Years.get(1)- D5;
        Double somme2016 = Sales_inLast5Years.get(2) - Purchase_inLast5Years.get(2)- D6;
        Double somme2017 = Sales_inLast5Years.get(3) - Purchase_inLast5Years.get(3)- D7;
        Double somme2018 = Sales_inLast5Years.get(4) - Purchase_inLast5Years.get(4)- D8;
 
       CashTotal.add(somme2014);CashTotal.add(somme2015);CashTotal.add(somme2016);CashTotal.add(somme2017);CashTotal.add(somme2018);
        Inventory=productService.Somme_ProductPrix_InStock();
        Net_Plan_Equipment = itemService.Somme_Item_intheLast5Years();
        Intagible = intangiblesService.Somme_Pur_Itagibles_in_Last5Years();
        java.text.DecimalFormat df = new java.text.DecimalFormat("0.##");
        Double dd4 = somme2014 + Inventory.get(0)+ Net_Plan_Equipment.get(0)+Intagible.get(0);
        Double dd5 = somme2015 + Inventory.get(1)+ Net_Plan_Equipment.get(1)+Intagible.get(1);
        Double dd6 = somme2016 + Inventory.get(2)+ Net_Plan_Equipment.get(2)+Intagible.get(2);
        Double dd7 = somme2017 + Inventory.get(3)+ Net_Plan_Equipment.get(3)+Intagible.get(3);
        Double dd8 = somme2018 + Inventory.get(4)+ Net_Plan_Equipment.get(4)+Intagible.get(4);
        asset_pourcentage.add(dd4);asset_pourcentage.add(dd5);asset_pourcentage.add(dd6);asset_pourcentage.add(dd7);
        asset_pourcentage.add(dd8);
        asset.add(df.format(dd4)); asset.add(df.format(dd5)); asset.add(df.format(dd6)); asset.add(df.format(dd7));
        asset.add(df.format(dd8));
        java.text.DecimalFormat dff = new java.text.DecimalFormat("0.##");
    ;

        cash_Vertical.add(dff.format(((somme2015*100)/somme2014)));Inventory_Vertical.add(dff.format((Inventory.get(1)*100)/(Inventory.get(0))));
        cash_Vertical.add(dff.format((somme2016*100)/somme2014));Inventory_Vertical.add(dff.format((Inventory.get(2)*100)/(Inventory.get(0))));
        cash_Vertical.add(dff.format((somme2017*100)/somme2014));Inventory_Vertical.add(dff.format((Inventory.get(3)*100)/(Inventory.get(0))));
        cash_Vertical.add(dff.format((somme2018*100)/somme2014));Inventory_Vertical.add(dff.format((Inventory.get(4)*100)/(Inventory.get(0))));

        
        Net_PlanV.add(dff.format((Net_Plan_Equipment.get(1)*100)/(Net_Plan_Equipment.get(0)))); IntagibleVert.add(dff.format((Intagible.get(1)*100)/(Intagible.get(0))));
        Net_PlanV.add(dff.format((Net_Plan_Equipment.get(2)*100)/(Net_Plan_Equipment.get(0))));IntagibleVert.add(dff.format((Intagible.get(2)*100)/(Intagible.get(0))));
        Net_PlanV.add(dff.format((Net_Plan_Equipment.get(3)*100)/(Net_Plan_Equipment.get(0))));IntagibleVert.add(dff.format((Intagible.get(3)*100)/(Intagible.get(0))));
        Net_PlanV.add(dff.format((Net_Plan_Equipment.get(4)*100)/(Net_Plan_Equipment.get(0))));IntagibleVert.add(dff.format((Intagible.get(4)*100)/(Intagible.get(0))));
        assetVer.add(dff.format((asset_pourcentage.get(1)*100)/(asset_pourcentage.get(0))));assetVer.add(dff.format((asset_pourcentage.get(2)*100)/(asset_pourcentage.get(0))));
        assetVer.add(dff.format((asset_pourcentage.get(3)*100)/(asset_pourcentage.get(0))));assetVer.add(dff.format((asset_pourcentage.get(4)*100)/(asset_pourcentage.get(0))));

        
    }
    
    ///////////hgfdgs
    public void cash() throws ParseException{
      /*  Date date =new SimpleDateFormat("yyyy-mm-dd").parse("2014-12-31");
       Double D= Math.abs(userService.Totalpay_Employee_parYear(date,"2014"));
       double hj;
       FFFFFF = NeedService.Somme_Sales_inLast5Years();
      hj= FFFFFF.get(2)+D;
      System.out.println(hj+"hj");
      System.out.println(D+"hj");*/
    }
    
    public List ProjectNames (){
        Map<String, Number> aaaa = new HashMap<String, Number>(taskService.Somme_Task_projectName());
       List <String> affff = new ArrayList<>();
        Set setsALE = aaaa.entrySet();
        
        Iterator iter = setsALE.iterator();
        affff = new ArrayList<>();
        while (iter.hasNext()) {

            Map.Entry me = (Map.Entry) iter.next();

            ///// System.out.print("key s is: " + me.getKey() + " & Value S is:
            ///// " + me.getValue() + "\n");

            affff.add((String) me.getKey());
        }
        return affff;
    }
    
    
    
    public List Somme_Tasks_parproject (){
        Map<String, Number> aaaa = new HashMap<String, Number>(taskService.Somme_Task_projectName());
       List <Double> affff = new ArrayList<>();
        Set setsALE = aaaa.entrySet();
        
        Iterator iter = setsALE.iterator();
        affff = new ArrayList<>();
        while (iter.hasNext()) {

            Map.Entry me = (Map.Entry) iter.next();

            ///// System.out.print("key s is: " + me.getKey() + " & Value S is:
            ///// " + me.getValue() + "\n");

            affff.add((Double) me.getValue());
        }
        return affff;
    }
    
    public List Somme_TimeSpend_parproject (){
        Map<String, Number> aaaa = new HashMap<String, Number>(taskService.Somme_TimeSpend_OnProject());
       List <Number> affff = new ArrayList<>();
        Set setsALE = aaaa.entrySet();
        
        Iterator iter = setsALE.iterator();
        affff = new ArrayList<>();
        while (iter.hasNext()) {

            Map.Entry me = (Map.Entry) iter.next();

            ///// System.out.print("key s is: " + me.getKey() + " & Value S is:
            ///// " + me.getValue() + "\n");

            affff.add((Number) me.getValue());
        }
        return affff;
    }
    
    public String showProjects() {
        listepROJECTS = projectService.findAll();
        return "http://localhost:18080/esprit1718b1erp-web/ahmedprodetails.jsf";
        
    }
  
    public List<String> getXvaluefor_axis() {
        return xvaluefor_axis;
    }

    public void setXvaluefor_axis(List<String> xvaluefor_axis) {
        this.xvaluefor_axis = xvaluefor_axis;
    }

    public List<Integer> getAzqs() {
        return azqs;
    }


    public void setAzqs(List<Integer> azqs) {
        this.azqs = azqs;
    }

    public List<Integer> getAazeee() {
        return aazeee;
    }

    public List<Double> getInventory() {
        return Inventory;
    }

    public void setInventory(List<Double> inventory) {
        Inventory = inventory;
    }

    public void setAazeee(List<Integer> aazeee) {
        this.aazeee = aazeee;
    }

    //////// filtrer le hashmap en ordre decroissant : pour filtrer les nom des
    //////// produits
    public static HashMap<String, Integer> triAvecValeur(HashMap<String, Integer> map) {
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        HashMap<String, Integer> map_apres = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : list)
            map_apres.put(entry.getKey(), entry.getValue());
        return map_apres;
    }

    /*
     * private List<Contact> findAllContact() { List<Contact> contacts = new
     * ArrayList<>(); contacts = contactService.findAll(); return contacts; }
     * public List<Contact> filterSupplierList() { List<Contact> SuplierList =
     * new ArrayList<>(); for (Contact c : findAllContact()) { try { if
     * (c.getRole().equals("supplier")) SuplierList.add(c); } catch
     * (NullPointerException e) { } } return SuplierList; }
     */
    public void ajouterpurchase() {

        Contact supplier = purchaseService.getSupplierById(supplierId);
        Product prod = purchaseService.getProductbyID(ProductId);
        pp.setStatupurchase(statuspurch);
        pp.setPurchase_type(typePurchase);
        pp.setContact(supplier);
        pp.setProduct(prod);
        pp.setDsecription(Dsecription);
        pp.setTypePayementPurchase(paymenttype);
        pp.setQuantite(Quantite);
        pp.setSomme(Somme);

        ///// SimpleDateFormat simpleFormat = new
        ///// SimpleDateFormat("dd-MM-yyyy");
         pp.setDateDemande(dateDemande);
         pp.setDateRecu(dateRecu);
        purchaseService.save(pp);
        //////// System.out.println(getPurchases());

    }

    public void deletePurchase(Integer i) {
        purchaseService.deletePurchase(i);
    }
    

    public String updatePurchase() {
        purchaseService.update(PurchaseDetails);
        return "/PurchaseAffiche?faces-redirect=true\"";
    }

    public String toPurchaseEdit(int i) {
        PurchaseDetails = purchaseService.find(i);
        return "/purchaseEdit?faces-redirect=true\"";
    }

    public Set<Item> getItems() {
        return items;
    }

    public List<Double> getCashTotal() {
        return CashTotal;
    }

    public void setCashTotal(List<Double> cashTotal) {
        CashTotal = cashTotal;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public TypePayementPurchase getPaymenttype() {
        return paymenttype;
    }

    public void setPaymenttype(TypePayementPurchase paymenttype) {
        this.paymenttype = paymenttype;
    }

    public Date getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande(Date dateDemande) {
        this.dateDemande = dateDemande;
    }

    public Date getDateRecu() {
        return dateRecu;
    }

    public List<Project> getListepROJECTS() {
        return listepROJECTS;
    }

  

    public List<Double> getSales_inLast5Years() {
        return Sales_inLast5Years;
    }

    public void setSales_inLast5Years(List<Double> sales_inLast5Years) {
        Sales_inLast5Years = sales_inLast5Years;
    }

    public void setListepROJECTS(List<Project> listepROJECTS) {
        this.listepROJECTS = listepROJECTS;
    }

    public List<Purchase> getPurchases() {
        purchases = purchaseService.findAll();
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }

    public void setDateRecu(Date dateRecu) {
        this.dateRecu = dateRecu;
    }

    public Purchase getPurchaseDetails() {
        return PurchaseDetails;
    }

    public void setPurchaseDetails(Purchase purchaseDetails) {
        PurchaseDetails = purchaseDetails;
    }

    public Integer getQuantite() {
        return Quantite;
    }

    public void setQuantite(Integer quantite) {
        Quantite = quantite;
    }

  

    public List<Product> getProducts() {
        return Products;
    }

    public void setProducts(List<Product> products) {
        Products = products;
    }

    public Integer getProductId() {
        return ProductId;
    }

    public void setProductId(Integer productId) {
        ProductId = productId;
    }

    public List<Double> getPurchase_inLast5Years() {
        return Purchase_inLast5Years;
    }

    public void setPurchase_inLast5Years(List<Double> purchase_inLast5Years) {
        Purchase_inLast5Years = purchase_inLast5Years;
    }

    public Float getSomme() {
        return Somme;
    }

    public void setSomme(Float somme) {
        Somme = somme;
    }

    public String getDsecription() {
        return Dsecription;
    }

    public void setDsecription(String dsecription) {
        Dsecription = dsecription;
    }

    public Statupurchase getStatuspurch() {
        return statuspurch;
    }

    public void setStatuspurch(Statupurchase statuspurch) {
        this.statuspurch = statuspurch;
    }

    public Purchase_type getTypePurchase() {
        return typePurchase;
    }

    public void setTypePurchase(Purchase_type typePurchase) {
        this.typePurchase = typePurchase;
    }

    public Purchase getPp() {
        return pp;
    }

    public void setPp(Purchase pp) {
        this.pp = pp;
    }

    public ContactService getContactService() {
        return contactService;
    }

    public void setContactService(ContactService contactService) {
        this.contactService = contactService;
    }

    public List<String> getAsset() {
        return asset;
    }

    public void setAsset(List<String> asset) {
        this.asset = asset;
    }

    public ProductService getProductService() {
        return productService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public List<Contact> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<Contact> suppliers) {
        this.suppliers = suppliers;
    }

    public List<Integer> getAze() {

        return aze;

    }

    public List<Double> getAsset_pourcentage() {
        return asset_pourcentage;
    }

    public void setAsset_pourcentage(List<Double> asset_pourcentage) {
        this.asset_pourcentage = asset_pourcentage;
    }

    public List<Double> getNet_Plan_Equipment() {
        return Net_Plan_Equipment;
    }

    public void setNet_Plan_Equipment(List<Double> net_Plan_Equipment) {
        Net_Plan_Equipment = net_Plan_Equipment;
    }

    public void setAze(List<Integer> aze) {
        this.aze = aze;
    }

    public List<Double> getIntagible() {
        return Intagible;
    }

    public void setIntagible(List<Double> intagible) {
        Intagible = intagible;
    }

    public IntangiblesService getIntangiblesService() {
        return intangiblesService;
    }

    public void setIntangiblesService(IntangiblesService intangiblesService) {
        this.intangiblesService = intangiblesService;
    }

    public List<String> getCash_Vertical() {
        return cash_Vertical;
    }

    public void setCash_Vertical(List<String> cash_Vertical) {
        this.cash_Vertical = cash_Vertical;
    }

    public List<String> getInventory_Vertical() {
        return Inventory_Vertical;
    }

    public void setInventory_Vertical(List<String> inventory_Vertical) {
        Inventory_Vertical = inventory_Vertical;
    }

    public List<String> getNet_PlanV() {
        return Net_PlanV;
    }

    public void setNet_PlanV(List<String> net_PlanV) {
        Net_PlanV = net_PlanV;
    }

    public List<String> getIntagibleVert() {
        return IntagibleVert;
    }

    public void setIntagibleVert(List<String> intagibleVert) {
        IntagibleVert = intagibleVert;
    }

    public List<String> getAssetVer() {
        return assetVer;
    }

    public void setAssetVer(List<String> assetVer) {
        this.assetVer = assetVer;
    }

}
