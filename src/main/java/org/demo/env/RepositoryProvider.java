package org.demo.env;

import org.demo.repository.BookRepository;
import org.demo.repository.impl.BookDAO;

public class RepositoryProvider {

	public final static BookRepository getBookRepository() {
		return new BookDAO();
	}
}
