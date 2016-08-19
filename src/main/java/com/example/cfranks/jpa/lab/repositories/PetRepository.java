package com.example.cfranks.jpa.lab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cfranks.jpa.lab.domain.Pet;

public interface PetRepository extends JpaRepository<Pet, Integer>{

}
