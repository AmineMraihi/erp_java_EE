package tn.esprit.b1.esprit1718b1erp.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

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

    protected Event() {
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

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

}
