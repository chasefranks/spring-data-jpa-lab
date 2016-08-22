package com.example.cfranks.jpa.lab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cfranks.jpa.lab.domain.Kennel;

public interface KennelRepository extends JpaRepository<Kennel, Integer> {

}
