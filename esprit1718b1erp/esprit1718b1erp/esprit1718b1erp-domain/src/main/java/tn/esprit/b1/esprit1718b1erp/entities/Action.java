package tn.esprit.b1.esprit1718b1erp.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "action")
public class Action extends Schedule implements Serializable {
    private static final long serialVersionUID = 1L;

    private String actionName;
    private String file;

    public Action() {
        super();
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

}
