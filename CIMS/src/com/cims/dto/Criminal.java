package com.cims.dto;

public class Criminal {
	private int id;
	private String name;
	private int age;
	private String gender;
	private String address;
	private String identifying_marks;
	private String crime;
	private String crime_location;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getIdentifying_marks() {
		return identifying_marks;
	}
	public void setIdentifying_marks(String identifying_marks) {
		this.identifying_marks = identifying_marks;
	}
	public String getCrime() {
		return crime;
	}
	public void setCrime(String crime) {
		this.crime = crime;
	}
	public String getCrime_location() {
		return crime_location;
	}
	public void setCrime_location(String crime_location) {
		this.crime_location = crime_location;
	}
	public Criminal() {}
	public Criminal(int id, String name, int age, String gender, String address, String identifying_marks, String crime,
			String crime_location) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.identifying_marks = identifying_marks;
		this.crime = crime;
		this.crime_location = crime_location;
	}
	@Override
	public String toString() {
		return "Criminal [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", address=" + address
				+ ", identifying_marks=" + identifying_marks + ", crime=" + crime + ", crime_location=" + crime_location
				+ "]";
	}
	

}
