package com.example.cfranks.jpa.lab.domain;

public class Pet {

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
