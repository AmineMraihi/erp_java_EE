
package tn.esprit.b1.esprit1718b1erp.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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

    @OneToMany(mappedBy = "user")
    private List<Item> items;
    @OneToMany(mappedBy = "applicant")

    private List<Intervention> interventions;

    @OneToMany(mappedBy= "responsableTache")
    private List<Task> tasks;
    
    @OneToMany(mappedBy="user2")
    private List<Purchase> purchases ;
    
    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
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

}
