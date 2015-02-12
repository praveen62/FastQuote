package com.ilp.fq.beans;
//Bean class for vehicle registrations
public class VehicleBean {
	private String userid,make,model,type;
	private int roadprice,vehicleid,year_of_manufacture;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getYearofManufacture() {
		return year_of_manufacture;
	}
	public void setYearofManufacture(int yearOfManufacture) {
		year_of_manufacture = yearOfManufacture;
	}
	public int getRoadPrice() {
		return roadprice;
	}
	public void setRoadPrice(int roadprice) {
		this.roadprice = roadprice;
	}
	public int getVehicleid() {
		return vehicleid;
	}
	public void setVehicleid(int vehicleid) {
		this.vehicleid = vehicleid;
	}
	
 
}
