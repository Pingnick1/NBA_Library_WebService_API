package com.lexicon.library.dataaccess;

import java.util.List;

import com.lexicon.library.domain.Book;

public interface BookDataAccess {
	
	public void insert(Book newBook);
	
	public void update(String updateColumn, String updateValue);
	
	public List<Book> findAll();

	public List<Book> findById(String id);
	
	public List<Book> findByTitle(String title);
	
	public List<Book> findByGenre(String genre);
	
	public List<Book> findByAuthor(String author);

	public List<Book> findByISBN(String isbn);
}
