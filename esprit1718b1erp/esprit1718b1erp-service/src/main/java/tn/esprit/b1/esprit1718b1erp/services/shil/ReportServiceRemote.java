package tn.esprit.b1.esprit1718b1erp.services.shil;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.b1.esprit1718b1erp.entities.Project;
import tn.esprit.b1.esprit1718b1erp.entities.Report;
import tn.esprit.b1.esprit1718b1erp.utilities.IGenericDAO;
@Remote
public interface ReportServiceRemote extends IGenericDAO<Report> {
    List<Report> findByDescription(String s);
}
