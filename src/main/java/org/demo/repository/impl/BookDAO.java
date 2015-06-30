package org.demo.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.demo.bean.Book;
import org.demo.repository.BookRepository;

public class BookDAO implements BookRepository {

	@Override
	public Book getById(int id) {
		// FAKE 
		Book book = new Book();
		book.setId(id);
		book.setTitle("Title "+id);
		book.setAuthor("Author "+id);
		return book;
	}

	@Override
	public Book save(Book book) {
		// FAKE 
		return book ;
	}
	
	@Override
	public void deleteById(int id) {
		// FAKE 
	}

	@Override
	public List<Book> getAll() {
		List<Book> list = new ArrayList<Book>();
		for ( int i = 0 ; i < 5 ; i++ ) {
			Book book = new Book();
			book.setId(i);
			book.setTitle("Title "+i);
			book.setAuthor("Author "+i);
			list.add(book);
		}
		return list;
	}
}
