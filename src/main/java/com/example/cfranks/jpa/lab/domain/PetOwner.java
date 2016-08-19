package com.example.cfranks.jpa.lab.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PetOwner {
	
	@Id
	private int id;
	
	private String firstName;
	private String lastName;
	private String phoneNumber;
	
	private List<Pet> pets;
	
	public PetOwner() {

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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<Pet> getPets() {
		return pets;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}

}
