package com.example.cfranks.jpa.lab;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.cfranks.jpa.lab.domain.Pet;
import com.example.cfranks.jpa.lab.domain.PetOwner;
import com.example.cfranks.jpa.lab.repositories.PetOwnerRepository;
import com.example.cfranks.jpa.lab.repositories.PetRepository;

@SpringBootApplication
public class SpringDataJpaLabApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaLabApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner save(PetRepository petRepo, PetOwnerRepository petOwnerRepo) {
		return (args)->{
			
			// create a new Pet object
			Pet pet = new Pet();
			pet.setName("Reese");
			
			// save
			petRepo.save(pet);
			
			// same for pet owner
			PetOwner owner = new PetOwner();
			owner.setFirstName("Chase");
			owner.setLastName("Franks");
			owner.setPhoneNumber("817-925-6472");
			
			petOwnerRepo.save(owner);
			
			// question: how can we link a pet to it's owner			
			
		};
	}
}
