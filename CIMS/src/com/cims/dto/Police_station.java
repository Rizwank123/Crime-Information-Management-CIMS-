package com.cims.dto;

public class Police_station {
	private int ps_id;
	private String ps_name;
	private String address;
	private String phone;
	public int getPs_id() {
		return ps_id;
	}
	public void setPs_id(int ps_id) {
		this.ps_id = ps_id;
	}
	public String getPs_name() {
		return ps_name;
	}
	public void setPs_name(String ps_name) {
		this.ps_name = ps_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Police_station() {
		// TODO Auto-generated constructor stub
	}
	public Police_station(int ps_id, String ps_name, String address, String phone) {
		super();
		this.ps_id = ps_id;
		this.ps_name = ps_name;
		this.address = address;
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Police_station [ps_id=" + ps_id + ", ps_name=" + ps_name + ", address=" + address + ", phone=" + phone
				+ "]";
	}
	

}
