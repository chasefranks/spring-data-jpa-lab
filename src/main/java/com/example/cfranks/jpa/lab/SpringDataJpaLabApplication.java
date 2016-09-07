package com.example.cfranks.jpa.lab;

import static java.util.Arrays.asList;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import com.example.cfranks.jpa.lab.domain.Kennel;
import com.example.cfranks.jpa.lab.domain.Pet;
import com.example.cfranks.jpa.lab.domain.PetOwner;
import com.example.cfranks.jpa.lab.repositories.CustomRepository;
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
	public CommandLineRunner save(PetRepository petRepo, PetOwnerRepository petOwnerRepo, KennelRepository kennelRepo) {
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
			
			owner.setPets(asList(reese, lilly)); // we have to set both directions of the relationship
			
			petOwnerRepo.save(owner);
			
			logger.info(owner.toString());
			
			PetOwner vivian = new PetOwner();
			vivian.setFirstName("Vivian");
			vivian.setLastName("Erminger");
			vivian.setPhoneNumber("827-827-3655");	
			
			Pet tippy = new Pet("Tippy");
			tippy.setOwner(vivian);		
			
			vivian.setPets(asList(tippy));
			
			petOwnerRepo.save(vivian);	
			
			logger.info(vivian.toString());
			
			// let's create a few kennels
			Kennel tippyKennel = new Kennel("A", 1);
			Kennel reesesKennel = new Kennel("A", 2);			

			Pet tippyFromDB = petRepo.findByName("Tippy").get(0);
			tippyKennel.setOccupant(tippyFromDB);

			Pet reeseFromDB = petRepo.findByName("Reese").get(0);
			reesesKennel.setOccupant(reeseFromDB);

			kennelRepo.save(asList(tippyKennel, reesesKennel));
			
			logger.info("test data saved");
			
		};
		
	}
	
	@Bean
	public CommandLineRunner customRepoTest(CustomRepository customRepo) {
		return args -> {
			List<Pet> petsFromDB = customRepo.fetchAllPets();
			
			for(Pet p : petsFromDB) {
				logger.info(p.toString());
			}
			
			petsFromDB = customRepo.fetchPetsInAisle("A");
			
			for(Pet p : petsFromDB) {
				logger.info(p.toString());
			}
		};		
	}
	
	
}
