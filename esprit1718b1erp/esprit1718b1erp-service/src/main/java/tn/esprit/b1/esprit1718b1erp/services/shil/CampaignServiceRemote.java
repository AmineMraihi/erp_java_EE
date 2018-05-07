package tn.esprit.b1.esprit1718b1erp.services.shil;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.ejb.Remote;

import tn.esprit.b1.esprit1718b1erp.entities.Campaign;
import tn.esprit.b1.esprit1718b1erp.utilities.IGenericDAO;
@Remote
public interface CampaignServiceRemote extends IGenericDAO<Campaign> {
    Map<String, Number> sommetot_campaign();
    Double SommeBudgetOfCampaigns();
    public List<Campaign> findAllCampignsNamesAndBudgets();
}
