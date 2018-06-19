package tn.esprit.b1.esprit1718b1erp.services.ahmed;

import java.util.Map;

import javax.ejb.Remote;

import tn.esprit.b1.esprit1718b1erp.entities.Contact;
import tn.esprit.b1.esprit1718b1erp.entities.Needa;
import tn.esprit.b1.esprit1718b1erp.utilities.IGenericDAO;

@Remote
public interface NeedServiceRemote extends IGenericDAO<Needa>{

    Double SommeSalesiPhoneX(Integer i);
    Double SommeSalesiPhone8(Integer i);
    Double SommeSalesiPhone8Plus(Integer i);
    Double SommeSalesiPhone7(Integer i);
    Map<String, Number> Need_somme();
    
}
