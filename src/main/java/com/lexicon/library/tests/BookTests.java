package com.lexicon.library.tests;

import javax.naming.NamingException;

public class BookTests {

	public static void main(String[] args) throws NamingException {
		/*

		Properties jndiProperties = new Properties();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
		jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:9990");
		jndiProperties.put("jboss.naming.client.ejb.context", true);

		Context jndi = new InitialContext(jndiProperties);

		Book book1 = new Book("Waking Up: A Guide to Spirituality Without Religion",
				Genres.SPIRITUALITY, "Sam Harris", 9781442359949L);
		
		Book book2 = new Book("The View From Nowhere",
				Genres.PHILOSOPHY, "Thomas Nagel", 9780195056440L);

		Book book3 = new Book("Principles of Cognitive Neuroscience",
				Genres.SCIENCE, "Dale Purves et. al.", 9780878935734L);
		BookManagementService service = (BookManagementService) jndi.lookup(
				"BookManagementImplementation/local");

		service.registerBook(book1);
		service.registerBook(book2);
		service.registerBook(book3);

		List<Book> books = service.getAllBooks();
		System.out.println(books);
		*/

	}

}
