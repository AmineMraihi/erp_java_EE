package tn.esprit.b1.esprit1718b1erp.mbeans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.CascadeType;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import org.primefaces.model.map.Polyline;

import tn.esprit.b1.esprit1718b1erp.entities.Campaign;
import tn.esprit.b1.esprit1718b1erp.entities.Campaign_Type;
import tn.esprit.b1.esprit1718b1erp.entities.Contact;
import tn.esprit.b1.esprit1718b1erp.entities.Product;
import tn.esprit.b1.esprit1718b1erp.entities.Project;
import tn.esprit.b1.esprit1718b1erp.entities.Report;
import tn.esprit.b1.esprit1718b1erp.entities.SaleOpportunity;
import tn.esprit.b1.esprit1718b1erp.entities.StateProject;
import tn.esprit.b1.esprit1718b1erp.entities.User;
import tn.esprit.b1.esprit1718b1erp.services.UserService;
import tn.esprit.b1.esprit1718b1erp.services.shil.CampaignService;
import tn.esprit.b1.esprit1718b1erp.services.shil.SaleOpportunityService;
import tn.esprit.b1.esprit1718b1erp.services.youssfi.ProjectService;

@ManagedBean
@SessionScoped
public class CampaignBean {

    private Integer id;

    private String nameCampaign;

    private String description;

    private Date creationDate;

    private Date beginningDate;

    private Date endingDate;

    private User responsable;

    private Campaign c;

    private List<Contact> participants = new ArrayList<>();

    private float budget;

    private String region;

    private List<Product> productsCampaign = new ArrayList<>();
    private int id_product;

    private float revenue;

    private String photo;

    private Report report;

    private Double sumBudgetOfCampaigns;

    private SaleOpportunity saleOpportunity;

    private Campaign_Type type;

    private List<Campaign> CampaignsNamesAndBudget;

    private List<Campaign> CampaignStatistcs;
    @EJB
    CampaignService campaignService;

    @EJB
    SaleOpportunityService saleOpportunityService;

    public void addCampaign() {
        c = new Campaign();
        Date date = new Date();
        c.setNameCampaign(this.nameCampaign);

        c.setCreationDate(date);
        c.setEndingDate(this.endingDate);
        c.setBudget(this.budget);
        c.setSaleOpportunity(this.saleOpportunity);
        // Product product = saleOpportunityService.getProductById(id_product);
        Product product = saleOpportunityService.getProductById(id_product);
        productsCampaign.add(product);
        c.setProductsCampaign(productsCampaign);
        c.setDescription(this.description);

        /*
         * p.setAnnule(0); p.setEtat(StateProject.IN_PROGRESS);
         * p.setFinDate(this.finDate); Product product =
         * projectService.getProductById(id_product);
         * 
         * p.setBugdet(this.bugdet); p.setDescription(this.description); p.setRetard(0);
         */
        if (this.budget > 1000 - campaignService.SommeBudgetOfCampaigns()) {
            FacesContext.getCurrentInstance().addMessage("form:budgetInput", new FacesMessage("S'il vous plait choisissez un budget inférieur a " + (1000 - campaignService.SommeBudgetOfCampaigns()) + " Million dinars"));
        } else {
            campaignService.save(c);
            FacesContext.getCurrentInstance().addMessage("form:budgetInput", new FacesMessage("Campaign Added"));
        }

    }

    public void deleteCampaign(Campaign campaign) {
        campaignService.delete(campaign);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameCampaign() {
        return nameCampaign;
    }

    public void setNameCampaign(String nameCampaign) {
        this.nameCampaign = nameCampaign;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getBeginningDate() {
        return beginningDate;
    }

    public void setBeginningDate(Date beginningDate) {
        this.beginningDate = beginningDate;
    }

    public Date getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(Date endingDate) {
        this.endingDate = endingDate;
    }

    public User getResponsable() {
        return responsable;
    }

    public void setResponsable(User responsable) {
        this.responsable = responsable;
    }

    public List<Contact> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Contact> participants) {
        this.participants = participants;
    }

    public float getBudget() {
        return budget;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public List<Product> getProductsCampaign() {
        return productsCampaign;
    }

    public void setProductsCampaign(List<Product> productsCampaign) {
        this.productsCampaign = productsCampaign;
    }

    public float getRevenue() {
        return revenue;
    }

    public void setRevenue(float revenue) {
        this.revenue = revenue;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }

    public SaleOpportunity getSaleOpportunity() {
        return saleOpportunity;
    }

    public void setSaleOpportunity(SaleOpportunity saleOpportunity) {
        this.saleOpportunity = saleOpportunity;
    }

    public Campaign_Type getType() {
        return type;
    }

    public void setType(Campaign_Type type) {
        this.type = type;
    }

    public List<Campaign> getCampaignsNamesAndBudget() {
        CampaignsNamesAndBudget = campaignService.findAll();
        return CampaignsNamesAndBudget;
    }

    public void setCampaignsNamesAndBudget(List<Campaign> campaignsNamesAndBudget) {
        CampaignsNamesAndBudget = campaignsNamesAndBudget;
    }

    public List<Campaign> getCampaignStatistcs() {
        CampaignsNamesAndBudget = campaignService.findAllCampignsNamesAndBudgets();
        return CampaignStatistcs;
    }

    public void setCampaignStatistcs(List<Campaign> campaignStatistcs) {
        CampaignStatistcs = campaignStatistcs;
    }

    public Campaign getC() {
        return c;
    }

    public void setC(Campaign c) {
        this.c = c;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public Double getSumBudgetOfCampaigns() {
        sumBudgetOfCampaigns = campaignService.SommeBudgetOfCampaigns();
        return sumBudgetOfCampaigns;
    }

    public void setSumBudgetOfCampaigns(Double sumBudgetOfCampaigns) {
        sumBudgetOfCampaigns = this.sumBudgetOfCampaigns;
    }

}