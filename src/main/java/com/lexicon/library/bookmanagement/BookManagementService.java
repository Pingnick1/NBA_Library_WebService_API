package com.lexicon.library.bookmanagement;

import java.util.List;

import javax.ejb.Local;

import com.lexicon.library.domain.Book;

@Local
public interface BookManagementService {
	public void registerBook(Book book);
	public List<Book> getAllBooks();
	public List<Book> updateBooks();
	public List<Book> searchById(int id);

}
