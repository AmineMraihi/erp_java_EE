package tn.esprit.b1.esprit1718b1erp.mbeans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import tn.esprit.b1.esprit1718b1erp.entities.Event;
import tn.esprit.b1.esprit1718b1erp.entities.Meeting;
import tn.esprit.b1.esprit1718b1erp.entities.Project;
import tn.esprit.b1.esprit1718b1erp.entities.Schedule;
import tn.esprit.b1.esprit1718b1erp.services.jassem.ScheduleService;
import tn.esprit.b1.esprit1718b1erp.services.youssfi.ProjectService;

@ManagedBean
@ViewScoped
public class ScheduleBean {
    private String title;
    private String description;
    private Float budget;
    private String place;
    private Integer projectId;
    private List<Project> projects;
    private String targetDate;
    private Event e;
    private Meeting m;
    private List<Schedule> schedules;
    @EJB
    ScheduleService scheduleservice;
    @EJB
    ProjectService projectservice;

    @PostConstruct
    void init() {
        projects=projectservice.findAll();
        e=new Event();
        m=new Meeting();
    }
    
    public void addEvent() throws ParseException
    {
        e.setEventName(this.title);
        e.setDescription(this.description);
        e.setBudget(this.budget);
        e.setPlace(this.place);
        e.setIdProject(projectservice.find(projectId));
        e.setTargetDate(convert(this.targetDate));
        e.setLogo("");
        scheduleservice.save(e);
        this.title=null;
        this.description=null;
        this.budget=null;
        this.place=null;
        this.projectId=null;
        this.targetDate=null;
        

    }
    public void addMeeting() throws ParseException
    {
        m.setMeetingName(this.title);
        m.setDescription(this.description);
        m.setBudget(this.budget);
        m.setPlace(this.place);
        m.setIdProject(projectservice.find(projectId));
        m.setTargetDate(convert(this.targetDate));
        
        scheduleservice.save(m);
        this.title=null;
        this.description=null;
        this.budget=null;
        this.place=null;
        this.projectId=null;
        this.targetDate=null;
        
        
    }
    public static Date convert(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date d1 = sdf.parse(date);
        return d1;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getBudget() {
        return budget;
    }

    public void setBudget(Float budget) {
        this.budget = budget;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

   
    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    

    public String getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(String targetDate) {
        this.targetDate = targetDate;
    }

    public ScheduleService getScheduleservice() {
        return scheduleservice;
    }

    public void setScheduleservice(ScheduleService scheduleservice) {
        this.scheduleservice = scheduleservice;
    }

    public ProjectService getProjectservice() {
        return projectservice;
    }

    public void setProjectservice(ProjectService projectservice) {
        this.projectservice = projectservice;
    }

    public Event getE() {
        return e;
    }

    public void setE(Event e) {
        this.e = e;
    }

    public Meeting getM() {
        return m;
    }

    public void setM(Meeting m) {
        this.m = m;
    }

    public List<Schedule> getSchedules() {
        return scheduleservice.findAll();
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }
    
}
