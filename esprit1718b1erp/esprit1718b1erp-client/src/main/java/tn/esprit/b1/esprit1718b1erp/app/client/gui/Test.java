package tn.esprit.b1.esprit1718b1erp.app.client.gui;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.b1.esprit1718b1erp.entities.Category;
import tn.esprit.b1.esprit1718b1erp.entities.Contact;
import tn.esprit.b1.esprit1718b1erp.entities.Particular;
import tn.esprit.b1.esprit1718b1erp.services.amine.CategoryServiceRemote;
import tn.esprit.b1.esprit1718b1erp.services.jassem.ContactServiceRemote;

public class Test {

    private Test() {
    }

    public static void main(String[] args) throws NamingException {
        String jndiNameEmploye = "esprit1718b1erp-ear/esprit1718b1erp-service/ContactService!tn.esprit.b1.esprit1718b1erp.services.jassem.ContactServiceRemote";
        Context context = new InitialContext();
        ContactServiceRemote categorieService = (ContactServiceRemote) context.lookup(jndiNameEmploye);

        // Category category = new Category();
        // category.setName("smartphone category");
        // category.setDescription("description");

        Particular c = new Particular(); 
        c.setName("smartphone provider");
        c.setRole("provider");
        categorieService.save(c);

    }

}
