package com.cims.dto;

import java.sql.Timestamp;

public class Crime {
	private int crid;
	private String crPlace;
	private String type;
	private Timestamp dateTime;
	private String status;
	private int ps_id;
	public Crime(int crid, String crPlace, String type, Timestamp dateTime, String status, int ps_id) {
		super();
		this.crid = crid;
		this.crPlace = crPlace;
		this.type = type;
		this.dateTime = dateTime;
		this.status = status;
		this.ps_id = ps_id;
	}
	public Crime() {}
	public int getCrid() {
		return crid;
	}
	public void setCrid(int crid) {
		this.crid = crid;
	}
	public String getCrPlace() {
		return crPlace;
	}
	public void setCrPlace(String crPlace) {
		this.crPlace = crPlace;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Timestamp getDateTime() {
		return dateTime;
	}
	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}
	public int getPs_id() {
		return ps_id;
	}
	public void setPs_id(int ps_id) {
		this.ps_id = ps_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Crims [crid=" + crid + ", crPlace=" + crPlace + ", type=" + type + ", dateTime=" + dateTime
				+ ", status=" + status + ", ps_id=" + ps_id + "]";
	}
	
	
	

}
