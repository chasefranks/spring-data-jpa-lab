package com.example.cfranks.jpa.lab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cfranks.jpa.lab.domain.Pet;
import java.lang.String;
import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Integer>{
	
	List<Pet> findByName(String name);

}
