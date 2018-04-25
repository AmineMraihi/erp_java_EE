package tn.esprit.b1.esprit1718b1erp.app.client.gui;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.b1.esprit1718b1erp.entities.Category;
import tn.esprit.b1.esprit1718b1erp.services.amine.CategoryServiceRemote;

public class Test {
    
    private Test() {
    }

    

    public static void main(String[] args) throws NamingException {
        String jndiNameEmploye = "esprit1718b1erp-ear/esprit1718b1erp-service/CategoryService!tn.esprit.b1.esprit1718b1erp.services.amine.CategoryServiceRemote";
        Context context = new InitialContext();
        CategoryServiceRemote categorieService = (CategoryServiceRemote) context.lookup(jndiNameEmploye);

        Category category = new Category();
        category.setName("test1");
        category.setDescription("description");
        

        categorieService.addCategoryAmine(category);

    }

}
