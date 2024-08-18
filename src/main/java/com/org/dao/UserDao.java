package com.org.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.org.dto.User;

@Repository
public class UserDao {
	
	 static EntityManagerFactory emf = Persistence.createEntityManagerFactory("karthik");
	 
	 
	 public void insertAndUpdateUser(User user) {
		 
		 EntityManager em = emf.createEntityManager();
		 EntityTransaction et = em.getTransaction();
		 
		 et.begin();
		 em.merge(user);
		 et.commit();
		 
	 }
	 
	 
	 
	 
	 public void deleteUser(User user) {
		 
		 EntityManager em = emf.createEntityManager();
		 EntityTransaction et = em.getTransaction();
		 et.begin();
		 em.remove(user);
		 et.commit();
		 
		 
	 }
	
	

}
