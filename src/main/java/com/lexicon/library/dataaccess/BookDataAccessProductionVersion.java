package com.lexicon.library.dataaccess;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.lexicon.library.domain.Book;


@Stateless
//@Alternative
public class BookDataAccessProductionVersion implements BookDataAccess {

	@PersistenceContext
	private EntityManager em;	
	
	@Override
	public void insert(Book book) {
		em.persist(book);

	}

	@Override
	public List<Book> findAll() {
		Query q = em.createQuery("select * from Book");
		List<Book> books = q.getResultList();
		
		return books;
	}

	@Override
	public Book findById(int id) {
		
		return em.find(Book.class, id);		
		
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
	public List<Book> findByISBN(long title) {
		
		Query q = em.createQuery("select book from Book book");
		List<Book> books = q.getResultList();
		
		return books;		
		
	}

	@Override
	public void update(String updateColumn, String updateValue) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteBook(int id) {
		Book book = em.find(Book.class, id);
		em.remove(book);
	}

}
