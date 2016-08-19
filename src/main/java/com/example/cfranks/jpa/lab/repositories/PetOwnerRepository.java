package com.example.cfranks.jpa.lab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cfranks.jpa.lab.domain.PetOwner;

public interface PetOwnerRepository extends JpaRepository<PetOwner, Integer> {

}
