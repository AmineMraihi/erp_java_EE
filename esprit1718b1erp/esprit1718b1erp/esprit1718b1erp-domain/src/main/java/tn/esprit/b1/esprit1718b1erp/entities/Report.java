package tn.esprit.b1.esprit1718b1erp.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Report implements Serializable {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    String reportName;
    Date dateReport;
    @OneToOne
    Project reportedProject;
    @Lob
    String descrpiton;
    @ManyToOne
    User responsable;
    
    //private List<Schedule> schedules;
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    
    @Override
    public String toString() {
        return "Report [id=" + id + ", reportName=" + reportName + ", dateReport=" + dateReport + ", reportedProject="
                + reportedProject + ", descrpiton=" + descrpiton + ", responsable=" + responsable + "]";
    }


    public void setId(Integer id) {
        this.id = id;
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

  

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    

}
