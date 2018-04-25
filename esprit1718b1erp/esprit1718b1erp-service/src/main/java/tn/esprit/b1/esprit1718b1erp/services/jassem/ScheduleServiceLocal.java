package tn.esprit.b1.esprit1718b1erp.services.jassem;

import javax.ejb.Local;

import tn.esprit.b1.esprit1718b1erp.entities.Schedule;
import tn.esprit.b1.esprit1718b1erp.utilities.IGenericDAO;

@Local
public interface ScheduleServiceLocal extends IGenericDAO<Schedule> {

}
