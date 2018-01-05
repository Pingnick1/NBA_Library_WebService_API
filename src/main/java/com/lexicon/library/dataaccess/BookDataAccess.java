package com.lexicon.library.dataaccess;

import java.util.List;

import com.lexicon.library.domain.Book;

public interface BookDataAccess {
	
	public abstract void insert(Book newBook);
	
	public abstract void update(String updateColumn, String updateValue);
	
	public abstract List<Book> findAll();

	public abstract List<Book> findById(String id);
	
	public abstract List<Book> findByTitle(String title);
	
	public abstract List<Book> findByGenre(String genre);
	
	public abstract List<Book> findByAuthor(String author);

	public abstract List<Book> findByISBN(String isbn);
}
