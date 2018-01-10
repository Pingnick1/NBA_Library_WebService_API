package com.lexicon.library.bookmanagement;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.lexicon.library.dataaccess.BookDataAccess;
import com.lexicon.library.domain.Book;

@Stateless
public class BookManagementImplementation implements BookManagementService {

	@Inject 
	private BookDataAccess dao;
	
	@Override
	public void registerBook(Book book) {
		dao.insert(book);
	}

	@Override
	public List<Book> getAllBooks() {
		return dao.findAll();
	}

	@Override
	public Book searchById(int id) {
		return dao.findById(id);
	}
	
	@Override
	public List<Book> updateBooks() {
		// TODO Auto-generated method stub
		return null;
	}

}

