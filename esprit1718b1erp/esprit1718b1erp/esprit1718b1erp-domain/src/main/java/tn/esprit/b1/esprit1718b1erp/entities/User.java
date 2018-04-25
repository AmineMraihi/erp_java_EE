
package tn.esprit.b1.esprit1718b1erp.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class User implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USR_CODE")
    private Long code;
    @Column(name = "USR_NAME")
    private String name;
    @Column(name = "USR_LOGIN")
    private String login;
    @Column(name = "USR_PWD")
    private String password;
    @Column(name = "USR_EMAIL")
    private String email;
    
    @Temporal(TemporalType.DATE)
    private Date HiringDate;

    @Temporal(TemporalType.DATE)
    private Date InterviewDate;
    
    private Integer Functional;
    private float Salary;
    
    private String photo;
    private long CIN;
    
    private String CV ;
    
    @Enumerated(EnumType.STRING)
    private UserFunction userFct;
    
    private String grade;
    
    

    @OneToMany(mappedBy = "user")
    private List<Item> items;
    @OneToMany(mappedBy = "applicant")

    private List<Intervention> interventions;

    
    
    public User(Long code, String name, String login, String password, String email, Date hiringDate,
            Date interviewDate, Integer functional, float salary, String photo, long cIN, String cV,
            UserFunction userFct, List<Item> items, List<Intervention> interventions, List<Task> tasks,
            List<Purchase> purchases) {
        super();
        this.code = code;
        this.name = name;
        this.login = login;
        this.password = password;
        this.email = email;
        HiringDate = hiringDate;
        InterviewDate = interviewDate;
        Functional = functional;
        Salary = salary;
        this.photo = photo;
        CIN = cIN;
        CV = cV;
        this.userFct = userFct;
        this.items = items;
        this.interventions = interventions;
        this.tasks = tasks;
        this.purchases = purchases;
    }

    public Date getHiringDate() {
        return HiringDate;
    }

    public void setHiringDate(Date hiringDate) {
        HiringDate = hiringDate;
    }

    public Date getInterviewDate() {
        return InterviewDate;
    }

    public void setInterviewDate(Date interviewDate) {
        InterviewDate = interviewDate;
    }

    public Integer getFunctional() {
        return Functional;
    }

    public void setFunctional(Integer functional) {
        Functional = functional;
    }

    @OneToMany(mappedBy= "responsableTache")
    private List<Task> tasks;
    
    @OneToMany(mappedBy="user2")
    private List<Purchase> purchases ;
    
    @OneToMany(mappedBy="employee")
    private List<Conge> leaves;
    
    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public String getCV() {
        return CV;
    }

    public void setCV(String cV) {
        CV = cV;
    }

    public UserFunction getUserFct() {
        return userFct;
    }

    public void setUserFct(UserFunction userFct) {
        this.userFct = userFct;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public User() {
        super();
    }

    public User(String name, String login, String password, String email) {
        super();
        this.name = name;
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Intervention> getInterventions() {
        return interventions;
    }

    public void setInterventions(List<Intervention> interventions) {
        this.interventions = interventions;
    }

    public float getSalary() {
        return Salary;
    }

    public void setSalary(float salary) {
        Salary = salary;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public long getCIN() {
        return CIN;
    }

    public void setCIN(long cIN) {
        CIN = cIN;
    }

    @Override
    public String toString() {
        return "User [code=" + code + ", name=" + name + ", login=" + login + ", password=" + password + ", email="
                + email + ", HiringDate=" + HiringDate + ", InterviewDate=" + InterviewDate + ", Functional="
                + Functional + ", Salary=" + Salary + ", photo=" + photo + ", CIN=" + CIN + ", CV=" + CV + ", userFct="
                + userFct  + "]";
    }
    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
