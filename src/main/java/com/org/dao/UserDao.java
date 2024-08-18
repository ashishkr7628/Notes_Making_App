package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.org.dto.Notes;
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
	 
	 
	 
		public List<User> verifyAdminByEmailAndPassword(String email, String password) {
			EntityManager em= emf.createEntityManager(); 
			EntityTransaction et = em.getTransaction();
			
			Query query = em.createQuery("select d from User d where d.email=?1 and d.password=?2");
			query.setParameter(1, email);
			query.setParameter(2, password);
			List<User> list = query.getResultList();
		
			
			return list;
		}
	
		
		public List<User> fetchAll(){
			EntityManager em = emf.createEntityManager();		 
			  
			  EntityTransaction et = em.getTransaction();
			  
			  Query query = em.createQuery("select d from User d ");
			List<User> list= query.getResultList();
			
			return list;
		}

public User fetchUserById(int id) {
	

	 EntityManager em = emf.createEntityManager();
	 
	return em.find(User.class,id);
	
	
	
	
}


}
