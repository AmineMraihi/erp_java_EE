package tn.esprit.b1.esprit1718b1erp.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Report implements Serializable {

    
    int id;
    String reportName;
    Date dateReport;
    Project reportedProject;
    String descrpiton;
    User responsable;
    List<Schedule> schedules;
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Report() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public Date getDateReport() {
        return dateReport;
    }

    public void setDateReport(Date dateReport) {
        this.dateReport = dateReport;
    }

    public Project getReportedProject() {
        return reportedProject;
    }

    public void setReportedProject(Project reportedProject) {
        this.reportedProject = reportedProject;
    }

    public String getDescrpiton() {
        return descrpiton;
    }

    public void setDescrpiton(String descrpiton) {
        this.descrpiton = descrpiton;
    }

    public User getResponsable() {
        return responsable;
    }

    public void setResponsable(User responsable) {
        this.responsable = responsable;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    

}
