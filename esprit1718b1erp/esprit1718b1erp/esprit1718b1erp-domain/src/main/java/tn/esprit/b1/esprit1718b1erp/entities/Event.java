package tn.esprit.b1.esprit1718b1erp.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
@DiscriminatorValue(value = "event")
public class Event extends Schedule implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String eventName;
    private Integer participantNumber;
    private String place;
    private String logo;
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "event_contact", joinColumns = { @JoinColumn(name = "event_id") }, inverseJoinColumns = {
            @JoinColumn(name = "contact_id") })
    private Set<Particular> contacts = new HashSet<Particular>();

    public Event() {
        super();
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Integer getParticipantNumber() {
        return participantNumber;
    }

    public void setParticipantNumber(Integer participantNumber) {
        this.participantNumber = participantNumber;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Set<Particular> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Particular> contacts) {
        this.contacts = contacts;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "Event [eventName=" + eventName + ", participantNumber=" + participantNumber + ", place=" + place
                + ", logo=" + logo + "]";
    }

}
