package tn.esprit.b1.esprit1718b1erp.mbeans;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.b1.esprit1718b1erp.entities.User;
import tn.esprit.b1.esprit1718b1erp.entities.UserFunction;
import tn.esprit.b1.esprit1718b1erp.services.UserService;

@ManagedBean
@SessionScoped
public class UserBean {
    private String name;
    private String login;
    private String password;
    private String email;
    private Date HiringDate;
    private Date InterviewDate;
    private Integer Functional;
    private float Salary;
    private String photo;
    private long CIN;
    private String CV ;
    private UserFunction userFct;
    private String grade;
    private List<User> engineers;
    
    @EJB
    UserService userService;
    
    
    public UserService getUserService() {
        return userService;
    }
    public void setUserService(UserService userService) {
        this.userService = userService;
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
    public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
    public List<User> getEngineers() {
        engineers = userService.findByFunction(UserFunction.ENGINEER);
        return engineers;
    }
    public void setEngineers(List<User> engineers) {
        this.engineers = engineers;
    }
    
    
}
