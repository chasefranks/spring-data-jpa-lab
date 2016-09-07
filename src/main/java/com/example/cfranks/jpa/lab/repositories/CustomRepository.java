package com.example.cfranks.jpa.lab.repositories;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.cfranks.jpa.lab.domain.Pet;

@Repository
public class CustomRepository {
	
	private SessionFactory sessionFactory;
	private Session session;
	
	@Autowired
	public CustomRepository(EntityManagerFactory emFactory) {
		this.sessionFactory = emFactory.unwrap(SessionFactory.class);		
		this.session = sessionFactory.openSession();
	}
	
	public List<Pet> fetchAllPets() {		
		return session.createQuery("from Pet").list();
	}
	
	public List<Pet> fetchPetsInAisle(String aisle) {
		
		String jpqlString = "select pet from Pet pet inner join pet.kennel k where k.aisle = :aisle";
		
		return session
				.createQuery(jpqlString)
				.setString("aisle", aisle)
				.list();
		
	}
	

}
