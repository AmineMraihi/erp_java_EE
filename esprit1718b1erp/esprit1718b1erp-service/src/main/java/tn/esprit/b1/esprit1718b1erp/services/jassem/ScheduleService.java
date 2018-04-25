package tn.esprit.b1.esprit1718b1erp.services.jassem;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.b1.esprit1718b1erp.entities.Contact;
import tn.esprit.b1.esprit1718b1erp.entities.Entreprise;
import tn.esprit.b1.esprit1718b1erp.entities.Event;
import tn.esprit.b1.esprit1718b1erp.entities.Meeting;
import tn.esprit.b1.esprit1718b1erp.entities.Schedule;
import tn.esprit.b1.esprit1718b1erp.utilities.GenericDAO;

/**
 * Session Bean implementation class ScheduleService
 */
@Stateless
@LocalBean
public class ScheduleService extends GenericDAO<Schedule> implements ScheduleServiceRemote, ScheduleServiceLocal {

    /**
     * Default constructor.
     */
    @PersistenceContext
    private EntityManager entityManager;

    public ScheduleService() {
        super(Schedule.class);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Schedule findScheduleByName(String name) {
        try {
            return  entityManager
                    .createQuery("SELECT s FROM Meeting s WHERE s.meetingName  =?", Meeting.class)
                    .setParameter(1, name).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Meeting> findAllMeetings() {
        List<Meeting> meetings = new ArrayList<Meeting>();

        meetings.addAll(entityManager.createQuery("SELECT m FROM Meeting m", Meeting.class).getResultList());
        return meetings;
    }

    @Override
    public List<Event> findAllEvents() {
        List<Event> events = new ArrayList<Event>();

        events.addAll(entityManager.createQuery("SELECT e FROM Event e", Event.class).getResultList());
        return events;
    }
}
