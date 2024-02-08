package com.oyd.students.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "belt")
	private String belt;
	
	@Column(name = "is_active")
	private boolean isActive;
	
	public Student() {
		
	}
	
	public Student(String firstName, String lastName, String email, String phone, String belt, boolean isActive) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.belt = normalizeBeltRankName(belt);
		this.isActive = isActive;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBelt() {
		return normalizeBeltRankName(this.belt);
	}
	public void setBelt(String belt) {
		this.belt = belt;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public String normalizeBeltRankName(String belt) {
		String reformattedBelt = belt.toUpperCase();
		switch(belt){
			case("WB"): return "White Belt";
			case("1S"): return "1st Section";
			case("2S"): return "2nd Section";
			case("3S"): return "3rd Section";
			case("4S"): return "4th Section";
			case("5S"): return "5th Section";
			case("6S"): return "6th Section";
			case("1D"): return "1st Degree";
			case("2D"): return "2nd Degree";
			case("3D"): return "3rd Degree";
			case("4D"): return "4th Degree";
			case("5D"): return "5th Degree";
			case("6D"): return "6th Degree";
			case("7D"): return "7th Degree";
			case("8D"): return "8th Degree";
			case("9D"): return "9th Degree";
		}
		return reformattedBelt;
	}
}
