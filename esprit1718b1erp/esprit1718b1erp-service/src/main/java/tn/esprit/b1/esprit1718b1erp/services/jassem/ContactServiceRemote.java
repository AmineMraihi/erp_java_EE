package tn.esprit.b1.esprit1718b1erp.services.jassem;



import java.util.List;

import javax.ejb.Remote;

import javafx.collections.ObservableList;
import tn.esprit.b1.esprit1718b1erp.entities.Category;
import tn.esprit.b1.esprit1718b1erp.entities.Contact;
import tn.esprit.b1.esprit1718b1erp.entities.Entreprise;
import tn.esprit.b1.esprit1718b1erp.entities.Particular;
import tn.esprit.b1.esprit1718b1erp.entities.Product;
import tn.esprit.b1.esprit1718b1erp.utilities.IGenericDAO;

@Remote
public interface ContactServiceRemote extends IGenericDAO<Contact> {
public Entreprise findCompanyByname(String name);
public List<String> findAllCompaniesNames();
public List<Entreprise> findAllCompanies();
public List<String> findAllParticularsNames();
public List<Particular> VerifierEntreprise(Entreprise e);
public Particular findParticularByNameFirstName(String NFirstName);
public List<Particular> findAllParticular();
public Integer findSuggestionForProduct(Product p);
}
