package com.lexicon.library.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.lexicon.library.domain.Book;

public class BookTests {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void CreateBooks() {
		Book book1 = new Book("Waking Up: A Guide to Spirituality Without Religion",
				"Philosophy", "Sam Harris", "9781442359949", "Penguin Books");
	}
	
	@Test
	public void InsertBooks() {
		
	}


}
