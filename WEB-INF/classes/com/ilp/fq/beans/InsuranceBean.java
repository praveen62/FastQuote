package com.ilp.fq.beans;

//Bean class for Insurance registrations

public class InsuranceBean {
	private int noofmonths;
	private int coverage;
	private String startdate;
	private int vehicleid;
	private String typeofinsurance;
	private int insuranceid;
	private int premium;

	public int getInsuranceid(){
		return insuranceid;
	}
	public int getPremium(){
		return premium;
	}
	public void setPremium(int premium){
		this.premium=premium;
	}
	public void setInsuranceid(int insuranceid) {
		this.insuranceid=insuranceid;
	}
	public int getNoofmonths() {
		return noofmonths;
	}
	public void setNoofmonths(int noofmonths) {
		this.noofmonths = noofmonths;
	}
	public int getCoverage() {
		return coverage;
	}
	public void setCoverage(int coverage) {
		this.coverage = coverage;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public int getVehicleid() {
		return vehicleid;
	}
	public void setVehicleid(int vehicleid) {
		this.vehicleid = vehicleid;
	}
	public String getTypeofinsurance() {
		return typeofinsurance;
	}
	public void setTypeofinsurance(String typeofinsurance) {
		this.typeofinsurance = typeofinsurance;
	}

}
