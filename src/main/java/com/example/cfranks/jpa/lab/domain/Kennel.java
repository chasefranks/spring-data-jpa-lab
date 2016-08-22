package com.example.cfranks.jpa.lab.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Kennel {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String aisle;
	private int number;
	
	@OneToOne
	@JoinColumn(name = "occupant_id")
	private Pet occupant;
	
	public Kennel() {

	}	
	
	public Kennel(String aisle, int number) {
		this.aisle = aisle;
		this.number = number;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public void setAisle(String aisle) {
		this.aisle = aisle;
	}
	
	public String getAisle() {
		return aisle;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setOccupant(Pet occupant) {
		this.occupant = occupant;
	}
	
	public Pet getOccupant() {
		return occupant;
	}

	@Override
	public String toString() {
		return "Kennel [aisle=" + aisle + ", number=" + number + "]";
	}

}
