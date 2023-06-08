package com.restaurant.model;

public class Restaurant {
    private int restoId;
    private String restoName;
    private String address;
	
	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Restaurant(int restoId, String restoName, String address) {
		super();
		this.restoId = restoId;
		this.restoName = restoName;
		this.address = address;
	}
	public int getRestoId() {
		return restoId;
	}
	public void setRestoId(int restoId) {
		this.restoId = restoId;
	}
	public String getRestoName() {
		return restoName;
	}
	public void setRestoName(String restoName) {
		this.restoName = restoName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Restaurant [restoId=" + restoId + ", restoName=" + restoName + ", address=" + address + "]";
	}

}
