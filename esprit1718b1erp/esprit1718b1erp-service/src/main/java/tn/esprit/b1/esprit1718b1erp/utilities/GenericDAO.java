package tn.esprit.b1.esprit1718b1erp.utilities;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import org.apache.log4j.Logger;

public abstract class GenericDAO<T> {
    private static final String UNIT_NAME = "CrudPU";
    // @PersistenceContext(unitName = UNIT_NAME)
    @PersistenceContext
    private EntityManager em;
    private static final Logger LOGGER = Logger.getLogger(GenericDAO.class);

    private Class<T> entityClass;

    public GenericDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public void save(T entity) {
        em.persist(entity);
    }

    public void delete(T entity) {
        T entityToBeRemoved = em.merge(entity);

        em.remove(entityToBeRemoved);
    }

    public T update(T entity) {
        return em.merge(entity);
    }

    public T find(int entityID) {
        return em.find(entityClass, entityID);
    }

    // Using the unchecked because JPA does not have a
    // em.getCriteriaBuilder().createQuery()<T> method
    @SuppressWarnings({ "unchecked", "rawtypes"

    })

    public List<T> findAll() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return em.createQuery(cq).getResultList();
    }

    // Using the unchecked because JPA does not have a
    // ery.getSingleResult()<T> method
    @SuppressWarnings("unchecked")
    protected T findOneResult(String namedQuery, Map<String, Object> parameters) {
        T result = null;

        try {
            Query query = em.createNamedQuery(namedQuery);

            // Method that will populate parameters if they are passed not null
            // and empty
            if (parameters != null && !parameters.isEmpty()) {
                populateQueryParameters(query, parameters);
            }

            result = (T) query.getSingleResult();

        } catch (Exception e) {

            LOGGER.error("Error while running query: " + e.getMessage(), e);
        }

        return result;
    }

    private void populateQueryParameters(Query query, Map<String, Object> parameters) {

        for (Entry<String, Object> entry : parameters.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
    }

    public String getUnitName() {
        return UNIT_NAME;
    }

}