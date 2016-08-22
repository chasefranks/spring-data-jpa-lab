package com.example.cfranks.jpa.lab.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cfranks.jpa.lab.domain.PetOwner;
import com.example.cfranks.jpa.lab.repositories.PetOwnerRepository;

@RestController
@RequestMapping("/owner")
public class PetOwnerController {
	
	private PetOwnerRepository petOwnerRepository;
	
	@Autowired
	public void setPetOwnerRepository(PetOwnerRepository petOwnerRepository) {
		this.petOwnerRepository = petOwnerRepository;
	}
	
	@RequestMapping("")
	public List<PetOwner> getOwners() {
		return petOwnerRepository.findAll();
	}

}
