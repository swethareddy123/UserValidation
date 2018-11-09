package com.cg.ctrl;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class User {
	
	private String city;
	
	@NotEmpty(message="Email is mandatory")
	@Email(message = "Please enter valid email id")
	private String email;
	
	@NotEmpty(message="First Name is mandatory")
	@Size(min=4,max=8,message = "minimum 4 and maximum 8 characters required")
	private String firstName;
	
	@NotEmpty(message="Last Name is mandatory")
	@Size(min=4,max=8,message = "minimum 4 and maximum 8 characters required")
	private String lastName;
	
	private char gender;
	
	private String[] skillSet;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String[] getSkillSet() {
		return skillSet;
	}
	public void setSkillSet(String[] skillSet) {
		this.skillSet = skillSet;
	}
	

}
