package com.example.cfranks.jpa.lab;

import static java.util.Arrays.asList;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.cfranks.jpa.lab.domain.Kennel;
import com.example.cfranks.jpa.lab.domain.Pet;
import com.example.cfranks.jpa.lab.domain.PetOwner;
import com.example.cfranks.jpa.lab.repositories.KennelRepository;
import com.example.cfranks.jpa.lab.repositories.PetOwnerRepository;
import com.example.cfranks.jpa.lab.repositories.PetRepository;

@SpringBootApplication
public class SpringDataJpaLabApplication {
	
	private Logger logger = LoggerFactory.getLogger(SpringDataJpaLabApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaLabApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner save(PetRepository petRepo, PetOwnerRepository petOwnerRepo) {
		return (args)->{
			
			logger.info("saving test data");
			PetOwner owner = new PetOwner();
			owner.setFirstName("Chase");
			owner.setLastName("Franks");
			owner.setPhoneNumber("817-925-6472");
			
			Pet reese = new Pet();
			reese.setName("Reese");
			reese.setOwner(owner);
			
			Pet lilly = new Pet();
			lilly.setName("Lilly");
			lilly.setOwner(owner);
			
			petOwnerRepo.save(owner);
			petRepo.save(reese);
			petRepo.save(lilly);
			
			PetOwner vivian = new PetOwner();
			vivian.setFirstName("Vivian");
			vivian.setLastName("Erminger");
			vivian.setPhoneNumber("827-827-3655");	
			
			Pet tippy = new Pet("Tippy");
			vivian.setPets(asList(tippy)); // note, this doesn't actually persist the relationship
			
			tippy.setOwner(vivian); // we have to do this
			
			petOwnerRepo.save(vivian);			
			petRepo.save(tippy);
			
			logger.info("test data saved");
			
		};
		
	}
	
	@Bean
	public CommandLineRunner fetch(PetRepository petRepo, PetOwnerRepository petOwnerRepo, KennelRepository kennelRepo) {
		return (args)->{
			logger.info("displaying all pet owners");
			petOwnerRepo.findAll()
				.forEach(
						owner -> System.out.println(owner)
				);
			
			logger.info("displaying all pets");
			petRepo.findAll().forEach(pet->{
				System.out.println(pet);
			});
			
			// let's create a few kennels
			Kennel tippyKennel = new Kennel("A", 1);
			Kennel reesesKennel = new Kennel("A", 2);			
						
			Pet tippy = petRepo.findByName("Tippy").get(0);
			tippyKennel.setOccupant(tippy);
			
			Pet reese = petRepo.findByName("Reese").get(0);
			reesesKennel.setOccupant(reese);
			
			kennelRepo.save(asList(tippyKennel, reesesKennel));
			
			logger.info("displaying all pets in their kennels");
			petRepo.findAll().forEach(pet->{
				System.out.println(pet);
			});

		};			
	}
}
