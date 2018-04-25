package tn.esprit.b1.esprit1718b1erp.services.shil;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.b1.esprit1718b1erp.entities.Campaign;
import tn.esprit.b1.esprit1718b1erp.entities.Project;
import tn.esprit.b1.esprit1718b1erp.utilities.GenericDAO;

/**
 * Session Bean implementation class CampaignService
 */
@Stateless
@LocalBean
public class CampaignService extends GenericDAO<Campaign> implements CampaignServiceRemote, CampaignServiceLocal {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Default constructor.
     */
    public CampaignService() {
        super(Campaign.class);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Map<String, Number> sommetot_campaign() {
        Map<String, Number> results = new HashMap<String, Number>();
//////        String jpaQuery = "SELECT p.productsCampaign_Id_Product, SUM(c.budget) FROM campaign c , campaign_product p GROUP BY p.productsCampaign_Id_Product ORDER BY `SUM(c.budget)` DESC";

        String jpaQuery = "SELECT g.nomProduit, SUM(c.budget) FROM campaign c"
                + " , campaign_product p, product g WHERE "
                + "g.nomProduit=(select g.nomProduit from product where g.Id_Product=p.productsCampaign_Id_Product LIMIT 1)"
                + " GROUP BY g.nomProduit ORDER BY `SUM(c.budget)`";
        List<Object[]> resultList = entityManager.createNativeQuery(jpaQuery).getResultList();

        for (Object[] borderTypes: resultList) {
               results.put((String) borderTypes[0], (Number)borderTypes[1]);
           
            }
          return results;
    }

    @Override
    public Double SommeBudgetOfCampaigns() {
    /*    Float f ;
        f= entityManager.createQuery("select SUM(c.budget)  from campaign c", Float.class).getSingleResult();
        return f ;*/
        
        Query query = entityManager
                .createNativeQuery("select SUM(c.budget)  from campaign c");
        return (Double)query.getSingleResult();
    }
}
