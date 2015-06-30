package org.demo.repository;

import java.util.List;

import org.demo.bean.Book;

public interface BookRepository {
	
	List<Book> getAll();
	
	Book getById(int id);
	
	Book save(Book book) ;
	
	void deleteById(int id);
}
