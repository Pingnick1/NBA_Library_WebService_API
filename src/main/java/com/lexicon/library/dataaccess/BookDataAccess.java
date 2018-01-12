package com.lexicon.library.dataaccess;

import java.util.List;

import com.lexicon.library.domain.Book;
import com.lexicon.library.domain.Genres;

public interface BookDataAccess {
	
	public abstract void insert(Book newBook);
	
	//public abstract void update(String updateColumn, String updateValue);
	
	public abstract void deleteBook(int id);
	
	public abstract List<Book> findAll();

	public abstract Book findById(int id);
	
	public abstract List<Book> findByTitle(String title);
	
	public abstract List<Book> findByGenre(Genres genre);
	
	public abstract List<Book> findByAuthor(String author);

	public abstract List<Book> findByISBN(long isbn);

}
