package tn.esprit.b1.esprit1718b1erp.mbeans;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import org.primefaces.model.map.Polyline;

import tn.esprit.b1.esprit1718b1erp.entities.Product;
import tn.esprit.b1.esprit1718b1erp.entities.Project;
import tn.esprit.b1.esprit1718b1erp.entities.Report;
import tn.esprit.b1.esprit1718b1erp.entities.SaleOpportunity;
import tn.esprit.b1.esprit1718b1erp.entities.StateProject;
import tn.esprit.b1.esprit1718b1erp.entities.User;
import tn.esprit.b1.esprit1718b1erp.services.UserService;
import tn.esprit.b1.esprit1718b1erp.services.shil.SaleOpportunityService;
import tn.esprit.b1.esprit1718b1erp.services.youssfi.ProjectService;

@ManagedBean
@SessionScoped
public class SaleOpportunityBean {

    private Integer id;
    private String nameSaleOpportunity;
    private Date creationDate;
    private Product produit;
    private Report report;
    private String region;
    private float budgetNeeded;
    private User responsable;
    private SaleOpportunity p;
    private int id_product;

    private double lat1;

    private double lng1;
    private List<SaleOpportunity> saleOpportunities;

    @EJB
    SaleOpportunityService saleOpportunityService;

    private MapModel rectangleModel;
    Polyline polyline = new Polyline();
    private double lat = 21.424191;
    private double lng = 39.813588;
    // private LatLng latlng = new
    // LatLng(saleOpportunityService.findAll().get(0).getLat(),
    // saleOpportunityService.findAll().get(0).getLng());

    private LatLng latlng = new LatLng(lat, lng);

    public SaleOpportunityBean() {

        // System.out.println(getSaleOpportunities());
        // LatLng latlng = new
        // LatLng(saleOpportunityService.findAll().get(0).getLat(),saleOpportunityService.findAll().get(0).getLng());
        System.out.println(latlng);
        rectangleModel = new DefaultMapModel();
        polyline.getPaths().add(latlng);
        polyline.setStrokeWeight(5);
        polyline.setStrokeColor("green");
        polyline.setStrokeOpacity(0.7);
        Marker marker = new Marker(latlng);
        rectangleModel.addOverlay(marker);

        /*
         * for (SaleOpportunity saleOpportunity : saleOpportunities) { LatLng latlng1 =
         * new LatLng(saleOpportunity.getLat(), saleOpportunity.getLng()); Marker
         * marker1 = new Marker(latlng1); rectangleModel.addOverlay(marker1); }
         */

    }

    public void addSaleOpp() {
        p = new SaleOpportunity();
        Date date = new Date();
        p.setNameSaleOpportunity(this.nameSaleOpportunity);

        p.setCreationDate(date);
        p.setBudgetNeeded(this.budgetNeeded);
        Product product = saleOpportunityService.getProductById(id_product);

        p.setProduit(product);
        p.setLat(lat1);
        /*
         * p.setAnnule(0); p.setEtat(StateProject.IN_PROGRESS);
         * p.setFinDate(this.finDate); Product product =
         * projectService.getProductById(id_product);
         * 
         * p.setBugdet(this.bugdet); p.setDescription(this.description); p.setRetard(0);
         */
        saleOpportunityService.save(p);

    }

    public List<SaleOpportunity> getSaleOpportunities() {

        return saleOpportunityService.findAll();

    }

    public void setSaleOpportunities(List<SaleOpportunity> saleOpportunities) {
        this.saleOpportunities = saleOpportunities;
    }

    public SaleOpportunityService getSaleOpportunityService() {
        return saleOpportunityService;
    }

    public void setSaleOpportunityService(SaleOpportunityService saleOpportunityService) {
        this.saleOpportunityService = saleOpportunityService;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SaleOpportunity getP() {
        return p;
    }

    public double getLat1() {
        return lat1;
    }

    public void setLat1(double lat1) {
        this.lat1 = lat1;
    }

    public double getLng1() {
        return lng1;
    }

    public void setLng1(double lng1) {
        this.lng1 = lng1;
    }

    public void setP(SaleOpportunity p) {
        this.p = p;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public LatLng getLatlng() {
        return latlng;
    }

    public void setLatlng(LatLng latlng) {
        this.latlng = latlng;
    }

    public String getNameSaleOpportunity() {
        return nameSaleOpportunity;
    }

    public void setNameSaleOpportunity(String nameSaleOpportunity) {
        this.nameSaleOpportunity = nameSaleOpportunity;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Product getProduit() {
        return produit;
    }

    public void setProduit(Product produit) {
        this.produit = produit;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public float getBudgetNeeded() {
        return budgetNeeded;
    }

    public void setBudgetNeeded(float budgetNeeded) {
        this.budgetNeeded = budgetNeeded;
    }

    public User getResponsable() {
        return responsable;
    }

    public void setResponsable(User responsable) {
        this.responsable = responsable;
    }

    public Polyline getPolyline() {
        return polyline;
    }

    public void setPolyline(Polyline polyline) {
        this.polyline = polyline;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    /*
     * public LatLng getLatlng() { return latlng; }
     * 
     * public void setLatlng(LatLng latlng) { this.latlng = latlng; }
     */

    public MapModel getRectangleModel() {
        return rectangleModel;
    }

    public void setRectangleModel(MapModel rectangleModel) {
        this.rectangleModel = rectangleModel;
    }

}