package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.org.dto.Notes;

@Repository
public class NotesDao {
	
	
	 static EntityManagerFactory emf = Persistence.createEntityManagerFactory("karthik");
	 
public  void insertAndUpdateNotes(Notes notes) {
	
	
	 EntityManager em = emf.createEntityManager();
	 EntityTransaction et = em.getTransaction();
	 
	 et.begin();
	 em.merge(notes);
	 et.commit();
	
	
}



public  List<Notes> fetchAllNotes() {
	
	
	 EntityManager em = emf.createEntityManager();
	 
	 Query query = em.createQuery("select n from Notes n");
	 
	 List<Notes> list = query.getResultList();
	 
	 return list;
	 
	
	
}


public Notes fetchNotesById(int id) {
	

	 EntityManager em = emf.createEntityManager();
	 
	return em.find(Notes.class,id);
	
	
	
	
}



public void deleteNotesById(int id) {
	 EntityManager em = emf.createEntityManager();
	 EntityTransaction et = em.getTransaction();
	 
	 
	 Notes notes = em.find(Notes.class, id);
	 
	 if(notes!=null) {
		 
		 et.begin();
		 em.remove(notes);
		 et.commit();
		 
	 }
	
	
}
	 
	 

}
