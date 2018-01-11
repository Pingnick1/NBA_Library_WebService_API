package com.lexicon.library.dataaccess;

import java.util.ArrayList;
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
import com.lexicon.library.domain.Genres;


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
	public List<Book> findByGenre(Genres genre) {
		
		Query q = em.createQuery("select book from Book book where book.genre = :genre");
		q.setParameter("genre", genre);
		List<Book> books = q.getResultList();
		
		return books;		
		
	}

	@Override
	public List<Book> findByISBN(long isbn) {

		
		Query q = em.createQuery("select book from Book book where book.isbn = :isbn");
		q.setParameter("isbn", isbn);
		List<Book> books = q.getResultList();
		
		return books;		
		
	}
	@Override
	public void deleteBook(int id) {
		Book book = em.find(Book.class, id);
		em.remove(book);
	}


}

