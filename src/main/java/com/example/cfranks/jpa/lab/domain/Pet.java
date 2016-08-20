package com.example.cfranks.jpa.lab.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Pet {

	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "owner_id")
	private PetOwner owner;

	public Pet() {

	}
	
	public Pet(String name) {
		this.name = name;
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

	@Override
	public String toString() {
		return "Pet [id=" + id + ", name=" + name + ", owner=" + owner.getFirstName() + " " + owner.getLastName() + "]";
	}

}
