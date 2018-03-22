package tn.esprit.b1.esprit1718b1erp.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue(value = "meeting")
public class Meeting extends Schedule implements Serializable {
    private static final long serialVersionUID = 1L;

    private String meetingName;
    private String place;
    @ManyToOne
    @JoinColumn(name = "id_contact")
    private Contact contact;

    protected Meeting() {
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

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

}
