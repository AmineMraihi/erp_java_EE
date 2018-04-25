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
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue(value = "meeting")
public class Meeting extends Schedule implements Serializable {
    private static final long serialVersionUID = 1L;

    private String meetingName;
    private String place;
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "meeting_contact", joinColumns = { @JoinColumn(name = "meeting_id") }, inverseJoinColumns = {
            @JoinColumn(name = "contact_id") })
    private Set<Particular> contactsM = new HashSet<Particular>();

    public Meeting() {
        super();
    }

    public String getMeetingName() {
        return meetingName;
    }

    public void setMeetingName(String meetingName) {
        this.meetingName = meetingName;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    

    public Set<Particular> getContactsM() {
        return contactsM;
    }

    public void setContactsM(Set<Particular> contactsM) {
        this.contactsM = contactsM;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "Meeting [meetingName=" + meetingName + ", place=" + place + ", contactsM=" + "]";
    }
    

}
