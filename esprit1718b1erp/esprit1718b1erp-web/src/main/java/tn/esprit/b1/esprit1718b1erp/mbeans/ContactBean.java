package tn.esprit.b1.esprit1718b1erp.mbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import tn.esprit.b1.esprit1718b1erp.entities.Category;
import tn.esprit.b1.esprit1718b1erp.entities.Contact;
import tn.esprit.b1.esprit1718b1erp.entities.Entreprise;
import tn.esprit.b1.esprit1718b1erp.entities.Item;
import tn.esprit.b1.esprit1718b1erp.entities.Particular;
import tn.esprit.b1.esprit1718b1erp.entities.Product;
import tn.esprit.b1.esprit1718b1erp.services.ahmed.PurchaseService;
import tn.esprit.b1.esprit1718b1erp.services.ahmed.SaleService;
import tn.esprit.b1.esprit1718b1erp.services.jassem.ContactService;

@ManagedBean
@SessionScoped
public class ContactBean {
    private String name;
    private String street;
    private String city;
    private String region;
    private String zipCode;
    private String country;
    private Integer phone;
    private Integer mobile;
    private String email;
    private String website;
    private String language;
    private String role;
    private String picture;
    private String first_name;
    private String positionHeld;
    private String civility;
    private List<Entreprise> companies;
    private String companyName;

    private Contact c;
    private Particular p;
    private Entreprise e;
    private List<Contact> contacts;
    private Contact contactDetails;
    private Particular particularDetails;
    private Entreprise companyDetails;

    @EJB
    ContactService contactservice;
    @EJB
    SaleService saleservice;
    @EJB
    PurchaseService purchaseservice;

    @PostConstruct
    void init() {
        companies = contactservice.findAllCompanies();

        
        e = new Entreprise();
        contactDetails = new Contact();

        // p= (Particular) c;
    }

    public void addContact() {
        p = new Particular();
        p.setName(this.name);
        p.setFirst_name(this.first_name);
        p.setCivility(this.civility);
        p.setMobile(this.mobile);
        p.setPhone(this.phone);
        p.setEmail(this.email);
        p.setWebsite(this.website);
        p.setLanguage(this.language);
        p.setRole(this.role);
        p.setPositionHeld(this.positionHeld);
        p.setPicture(this.picture);
        p.setStreet(this.street);
        p.setRegion(this.region);
        p.setCountry(this.country);
        p.setZipCode(this.zipCode);
        p.setCity(this.city);
        Entreprise e = contactservice.findCompanyByname(this.companyName);

        p.setCompany(e);
        System.out.println(p);
        contactservice.save(p);
        this.name=null;
        this.first_name=null;
        this.civility=null;
        this.mobile=null;
        this.phone=null;
        this.email=null;
        this.website=null;
        this.language=null;
        this.role=null;
        this.positionHeld=null;
        this.picture=null;
        this.street=null;
        this.region=null;
        this.country=null;
        this.zipCode=null;
        this.city=null;
        this.companyName=null;
    }
    
    public void addCompany() {
        e = new Entreprise();
        e.setName(this.name);
        e.setMobile(this.mobile);
        e.setPhone(this.phone);
        e.setEmail(this.email);
        e.setWebsite(this.website);
        e.setLanguage(this.language);
        e.setRole(this.role);
        e.setPicture(this.picture);
        e.setStreet(this.street);
        e.setRegion(this.region);
        e.setCountry(this.country);
        e.setZipCode(this.zipCode);
        e.setCity(this.city);
       
        contactservice.save(e);
        
        this.name=null;
        this.first_name=null;
        this.civility=null;
        this.mobile=null;
        this.phone=null;
        this.email=null;
        this.website=null;
        this.language=null;
        this.role=null;
        this.positionHeld=null;
        this.picture=null;
        this.street=null;
        this.region=null;
        this.country=null;
        this.zipCode=null;
        this.city=null;
        this.companyName=null;

    }

    public void updateParticular() {
        particularDetails.setCompany(contactservice.findCompanyByname(this.companyName));
        contactservice.update(particularDetails);
    }

    
      public void updateCompany() {
          contactservice.update(companyDetails); 
          }
     

    public String toContactEdit(int i) {
        contactDetails = contactservice.find(i);
        if (contactDetails instanceof Particular) {
            particularDetails = new Particular();
            particularDetails = (Particular) contactDetails;

        }
        if (contactDetails instanceof Entreprise) {
            companyDetails = new Entreprise();
            companyDetails = (Entreprise) contactDetails;
        }
        return "/contactEdit?faces-redirect=true";
    }
    public Contact findBestContactSuggestion(Product prod)
    {
        return contactservice.find(contactservice.findSuggestionForProduct(prod));
    }
    public String toContactProfile(int i) {
        contactDetails = contactservice.find(i);        
        return "/profile?faces-redirect=true";
    }
    public Double ContactSalesPerMonth1()
    {
        return saleservice.ContactSalesPerMonth(1,contactDetails);
    }
    public Double ContactSalesPerMonth2()
    {
        return saleservice.ContactSalesPerMonth(2,contactDetails);
    }
    public Double ContactSalesPerMonth3()
    {
        return saleservice.ContactSalesPerMonth(3,contactDetails);
    }
    public Double ContactSalesPerMonth4()
    {
        return saleservice.ContactSalesPerMonth(4,contactDetails);
    }
    public Double ContactSalesPerMonth5()
    {
        return saleservice.ContactSalesPerMonth(5,contactDetails);
    }
    public Double ContactSalesPerMonth6()
    {
        return saleservice.ContactSalesPerMonth(6,contactDetails);
    }
    public Double ContactSalesPerMonth7()
    {
        return saleservice.ContactSalesPerMonth(7,contactDetails);
    }
    public Double ContactPurchasePerMonth1()
    {
        return purchaseservice.ContactPurchasesPerMonth(1,contactDetails);
    }
    public Double ContactPurchasePerMonth2()
    {
        return purchaseservice.ContactPurchasesPerMonth(2,contactDetails);
    }
    public Double ContactPurchasePerMonth3()
    {
        return purchaseservice.ContactPurchasesPerMonth(3,contactDetails);
    }
    public Double ContactPurchasePerMonth4()
    {
        return purchaseservice.ContactPurchasesPerMonth(4,contactDetails);
    }
    public Double ContactPurchasePerMonth5()
    {
        return purchaseservice.ContactPurchasesPerMonth(5,contactDetails);
    }
    public Double ContactPurchasePerMonth6()
    {
        return purchaseservice.ContactPurchasesPerMonth(6,contactDetails);
    }
    public Double ContactPurchasePerMonth7()
    {
        return purchaseservice.ContactPurchasesPerMonth(7,contactDetails);
    }
    public void deleteContact(Integer i) {
        contactservice.delete(contactservice.find(i));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Integer getMobile() {
        return mobile;
    }

    public void setMobile(Integer mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getPositionHeld() {
        return positionHeld;
    }

    public void setPositionHeld(String positionHeld) {
        this.positionHeld = positionHeld;
    }

    public String getCivility() {
        return civility;
    }

    public void setCivility(String civility) {
        this.civility = civility;
    }

    public List<Entreprise> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Entreprise> companies) {
        this.companies = companies;
    }

    public ContactService getContactservice() {
        return contactservice;
    }

    public void setContactservice(ContactService contactservice) {
        this.contactservice = contactservice;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Contact getC() {
        return c;
    }

    public void setC(Contact c) {
        this.c = c;
    }

    public Particular getP() {
        return p;
    }

    public void setP(Particular p) {
        this.p = p;
    }

    public List<Contact> getContacts() {
        return contactservice.findAll();
    }

    public Contact getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(Contact contactDetails) {
        this.contactDetails = contactDetails;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public Particular getParticularDetails() {
        return particularDetails;
    }

    public void setParticularDetails(Particular particularDetails) {
        this.particularDetails = particularDetails;
    }

    public Entreprise getCompanyDetails() {
        return companyDetails;
    }

    public void setCompanyDetails(Entreprise companyDetails) {
        this.companyDetails = companyDetails;
    }

}
