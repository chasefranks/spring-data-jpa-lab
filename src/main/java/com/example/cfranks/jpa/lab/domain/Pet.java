package com.example.cfranks.jpa.lab.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Pet {

	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "owner_id")
	@JsonIgnore
	private PetOwner owner;
	
	@OneToOne(mappedBy = "occupant", fetch = FetchType.EAGER)
	@JsonIgnore
	private Kennel kennel;

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
	
	public void setKennel(Kennel kennel) {
		this.kennel = kennel;
	}
	
	public Kennel getKennel() {
		return kennel;
	}

	@Override
	public String toString() {
		return "Pet [id=" + id + ", name=" + name + ", owner=" + owner.getFirstName() + " " + owner.getLastName() + ", kennel=" + kennel + "]";
	}

}
