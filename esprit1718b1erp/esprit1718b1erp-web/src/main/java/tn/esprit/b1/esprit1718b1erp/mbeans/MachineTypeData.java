package tn.esprit.b1.esprit1718b1erp.mbeans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import tn.esprit.b1.esprit1718b1erp.entities.MachineType;

@ManagedBean
@ApplicationScoped
public class MachineTypeData {
	public MachineType[] getRoles() {
		return MachineType.values();
	}
}
