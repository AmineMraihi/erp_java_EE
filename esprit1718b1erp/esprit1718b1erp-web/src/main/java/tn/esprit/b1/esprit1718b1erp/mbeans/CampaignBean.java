package tn.esprit.b1.esprit1718b1erp.mbeans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
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

    private List<Contact> participants = new ArrayList<>();

    private float budget;

    private String region;

    private List<Product> productsCampaign;

    private float revenue;

    private String photo;

    private Report report;

    private SaleOpportunity saleOpportunity;

    private Campaign_Type type;
    
    private List<Campaign> CampaignsNamesAndBudget;
    @EJB
    CampaignService campaignService;

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
        CampaignsNamesAndBudget= campaignService.findAll();
        return CampaignsNamesAndBudget;
    }

    public void setCampaignsNamesAndBudget(List<Campaign> campaignsNamesAndBudget) {
        CampaignsNamesAndBudget = campaignsNamesAndBudget;
    }
    
    
    

}