package tn.esprit.b1.esprit1718b1erp.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class taskID implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private int idProject;
    private long idUser;
    
    public taskID() {
        // TODO Auto-generated constructor stub
    }

    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }
    

    public taskID(int idProject, int idUser) {
        super();
        this.idProject = idProject;
        this.idUser = idUser;
    }

   

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + idProject;
        result = prime * result + (int) (idUser ^ (idUser >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        taskID other = (taskID) obj;
        if (idProject != other.idProject)
            return false;
        if (idUser != other.idUser)
            return false;
        return true;
    }
    

}
