package tn.esprit.b1.esprit1718b1erp.services.jassem;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.b1.esprit1718b1erp.entities.Event;
import tn.esprit.b1.esprit1718b1erp.entities.Meeting;
import tn.esprit.b1.esprit1718b1erp.entities.Schedule;
import tn.esprit.b1.esprit1718b1erp.utilities.IGenericDAO;

@Remote
public interface ScheduleServiceRemote extends IGenericDAO<Schedule> {
    public Schedule findScheduleByName(String name);
    public List<Meeting> findAllMeetings();
    public List<Event> findAllEvents();
}
