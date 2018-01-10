package com.lexicon.library.dataaccess;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/*
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
*/
import com.lexicon.library.domain.Book;


@Stateless
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
	public Book findById(int id) {
		
		return em.find(Book.class, id);		
		
	}
	
	@Override
	public void update(String updateColumn, String updateValue) {
		/*
		Query q = em.("select book from Book book where book.isbn = :isbn");
		q.getParameter(isbn);
		*/
		
	}
/*
	@Override
	public List<Book> findByTitle(String title) {
		Query q = em.createQuery("select book from Book book where book.title = :title");
		q.getParameter(title);
		List<Book> books = q.getResultList();
		
		return books;		
		
	}
	
	@Override
	public List<Book> findByAuthor(String author) {
		
		Query q = em.createQuery("select book from Book book where book.author = :author");
		q.getParameter(author);
		List<Book> books = q.getResultList();
		
		return books;		
		
	}

	@Override
	public List<Book> findByGenre(String genre) {
		
		Query q = em.createQuery("select book from Book book where book.genre = :genre");
		q.getParameter(genre);
		List<Book> books = q.getResultList();
		
		return books;		
		
	}

	@Override
	public List<Book> findByISBN(String isbn) {
		
		Query q = em.createQuery("select book from Book book where book.isbn = :isbn");
		q.getParameter(isbn);
		List<Book> books = q.getResultList();
		
		return books;		
		
	}
*/
}
