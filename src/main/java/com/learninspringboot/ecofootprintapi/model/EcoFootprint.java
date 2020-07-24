package com.learninspringboot.ecofootprintapi.model;

import org.springframework.data.annotation.Id;

import java.util.List;

public class EcoFootprint {
	@Id
	public String id;

	public String footprintId;
	public String firstName;
	public String lastName;
	public List<EcoAction> ecoActions;

	public EcoFootprint() {}

	public EcoFootprint(String firstName, String lastName, String footprintId, List<EcoAction> ecoActions) {
		this.firstName = firstName;
	    this.lastName = lastName;
	    this.footprintId = footprintId;
	    this.ecoActions = ecoActions;
	}
	
	public String getFootprintId() {
		return footprintId;
	}
	public void setFootprintId(String footPrintId) {
		this.footprintId = footPrintId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	@Override
	public String toString() {
	  return String.format(
	      "Footprint[footprintId=%S, firstName='%s', lastName='%s']",
	      footprintId, firstName, lastName);
	}
}
