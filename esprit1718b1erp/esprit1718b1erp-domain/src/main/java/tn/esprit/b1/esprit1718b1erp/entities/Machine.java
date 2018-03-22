package tn.esprit.b1.esprit1718b1erp.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue(value = "machine")

public class Machine extends Item implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;


    private Date nextmaintenance;

    private Date lastmaintenance;

    private Boolean underguarantee;

    @Enumerated(EnumType.STRING)
    private MachineState state;

    private Date durationguarantee;

    private Boolean availability;


    public Date getNextmaintenance() {
        return nextmaintenance;
    }

    public void setNextmaintenance(Date nextmaintenance) {
        this.nextmaintenance = nextmaintenance;
    }

    public Date getLastmaintenance() {
        return lastmaintenance;
    }

    public void setLastmaintenance(Date lastmaintenance) {
        this.lastmaintenance = lastmaintenance;
    }

    public Boolean getUnderguarantee() {
        return underguarantee;
    }

    public void setUnderguarantee(Boolean underguarantee) {
        this.underguarantee = underguarantee;
    }

    public MachineState getState() {
        return state;
    }

    public void setState(MachineState state) {
        this.state = state;
    }

    public Date getDurationguarantee() {
        return durationguarantee;
    }

    public void setDurationguarantee(Date durationguarantee) {
        this.durationguarantee = durationguarantee;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

}
