package tn.esprit.b1.esprit1718b1erp.mbeans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import tn.esprit.b1.esprit1718b1erp.entities.BreakdownState;

@ManagedBean
@ApplicationScoped
public class breakdownStateData {
	public BreakdownState[] getRoles() {
		return BreakdownState.values();
	}
	public BreakdownState getTreated(){
		return BreakdownState.TREATED;
	}
public BreakdownState getUntreated(){
	return BreakdownState.UNTREATED;
}
}
