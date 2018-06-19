package tn.esprit.b1.esprit1718b1erp.mbeans;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.b1.esprit1718b1erp.entities.Product;
import tn.esprit.b1.esprit1718b1erp.entities.Project;
import tn.esprit.b1.esprit1718b1erp.services.shil.ProductService;

@ManagedBean
@SessionScoped
public class ProductBean {
    private int Id_Product;
    private  String nomProduit;
    private Date dateCreation;
    private  float prixUnitaire;
    private  int qte;
    private  String type;
    private  float prixQuantite;
    private  Project project;
    private List<Product> products;
    private Product productProject;
    private Product p;
    private Product productToUpdate;
    @EJB
    ProductService productService;

    public void addProduct(){
        p = new Product();
        p.setNomProduit(this.nomProduit);
        p.setPrixUnitaire(this.prixUnitaire);
        p.setQte(this.qte);
        p.setType(this.type);
        p.setPrixQuantite(this.prixUnitaire*this.qte);
        productService.save(p);
    }
    public String UpdateProduct()
    {
        productService.update(productToUpdate);
        return "/DetailsProgressProjects?faces-redirect=true";
    }
    public String toProductUpdate(int i) {
        productToUpdate = productService.find(i);
        return "/UpdateProduct?faces-redirect=true";
    }
    public void setProductProject(Product productProject) {
        this.productProject = productProject;
    }

    public Product getP() {
        return p;
    }

    public void setP(Product p) {
        this.p = p;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public float getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(float prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrixQuantite() {
        return prixQuantite;
    }

    public void setPrixQuantite(float prixQuantite) {
        this.prixQuantite = prixQuantite;
    }

    public ProductService getProductService() {
        return productService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<Product> getProducts() {
       products = productService.findAll();
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getId_Product() {
        return Id_Product;
    }

    public void setId_Product(int id_Product) {
        Id_Product = id_Product;
    }

    public Product getProductToUpdate() {
        return productToUpdate;
    }

    public void setProductToUpdate(Product productToUpdate) {
        this.productToUpdate = productToUpdate;
    }

    public Product getProductProject() {
        return productProject;
    }
    
    
}
