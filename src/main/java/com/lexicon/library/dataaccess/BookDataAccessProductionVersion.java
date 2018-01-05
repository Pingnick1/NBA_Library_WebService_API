package com.lexicon.library.dataaccess;

import java.util.List;
import java.util.function.Predicate;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.lexicon.library.domain.Book;


@Stateless
//@Alternative
@ProductionDao
public class BookDataAccessProductionVersion implements BookDataAccess {

	@PersistenceContext
	private EntityManager em;	
	
	@Override
	public void insert(Book book) {
		em.persist(book);

	}

	@Override
	public List<Book> findAll() {
		Query q = em.createQuery("select book from Book book");
		List<Book> books = q.getResultList();
		
		return books;
	}

	@Override
	public List<Book> findById(String title) {
		
		Query q = em.createQuery("select book from Book book");
		List<Book> books = q.getResultList();
		
		return books;		
		
	}

	@Override
	public List<Book> findByTitle(String title) {
		
		Query q = em.createQuery("select book from Book book");
		List<Book> books = q.getResultList();
		
		return books;		
		
	}
	
	@Override
	public List<Book> findByAuthor(String title) {
		
		Query q = em.createQuery("select book from Book book");
		List<Book> books = q.getResultList();
		
		return books;		
		
	}

	@Override
	public List<Book> findByGenre(String title) {
		
		Query q = em.createQuery("select book from Book book");
		List<Book> books = q.getResultList();
		
		return books;		
		
	}

	@Override
	public List<Book> findByISBN(String title) {
		
		Query q = em.createQuery("select book from Book book");
		List<Book> books = q.getResultList();
		
		return books;		
		
	}

	@Override
	public void update(Predicate<Book> updateCriteria) {
		// TODO Auto-generated method stub
		
	}

}
