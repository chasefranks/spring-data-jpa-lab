package com.example.cfranks.jpa.lab.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pet {

	@Id
	private int id;
	
	private String name;
	private PetOwner owner;

	public Pet() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PetOwner getOwner() {
		return owner;
	}

	public void setOwner(PetOwner owner) {
		this.owner = owner;
	}

}
