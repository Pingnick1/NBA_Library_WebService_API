package com.lexicon.library.dataaccess;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.lexicon.library.domain.Book;


@Stateless
//@Alternative
public class BookDataAccessProductionVersion implements BookDataAccess {

	@PersistenceContext
	private EntityManager em;	
	
//	Create new book
	@Override
	public void insert(Book book) {
		em.persist(book);
		}

	
	
	
//	Get all books
	@Override
	public List<Book> findAll() {
		Query q = em.createQuery("select * from Book");
		List<Book> books = q.getResultList();
		
		return books;
		}

//	Find book by Id
	@Override
	public Book findById(int id) {
		
		return em.find(Book.class, id);		
		}
	
	

//	Find book by title
	@Override
	public List<Book> findByTitle(String title) {
		
		Query q = em.createNativeQuery("SELECT * FROM Book b WHERE b.title LIKE ?1",Book.class);
		q.setParameter(1, title + "%");
		List<Book> books = q.getResultList();
				return books;	
				}
	
//	Find book by author 
	@Override
	public List<Book> findByAuthor(String author) {
		
		Query q = em.createNativeQuery("SELECT * FROM Book b WHERE b.author LIKE ?1",Book.class);
		q.setParameter(1, author +"%");
		List<Book> authors = q.getResultList();
		
		return authors;		
		}

	
	
//Find book by genre "not working for now in "
	@Override
	public List<Book> findByGenre(String title) {
		
		Query q = em.createQuery("select book from Book book");
		List<Book> books = q.getResultList();
		
		return books;		
		}

	
	
//	Find book by isbn
	@Override
	public List<Book> findByISBN(long isbn) {
		
		Query q = em.createNativeQuery("SELECT * FROM Book b WHERE b.isbn LIKE ?1",Book.class);
		q.setParameter(1,"%"+isbn +"%");
		List<Book> books = q.getResultList();
		
		return books;		
		}


	
//	Update book"not working for now"
	@Override
	public void update(String updateColumn, String updateValue) {
		// TODO Auto-generated method stub
		}
	
	
	
//	Delete book by getting Id
	@Override
	public void deleteBook(int id) {
		Book book = em.find(Book.class, id);
		em.remove(book);
	}

}
