package com.library.rest.service;

/**
 * @author ANIZAM
 *
 */

import java.util.List;

import com.library.rest.model.Book;

public interface BookService {

	List<Book> findAll();
	
	Book saveBook(Book book);
	
	void updateBook(Book book);
	
	void deleteBook(String idbook);
	
	Book findByIdbook(String idbook);
	
	void updateBookLeft(String idbook, int availability);
	
	List<Book> findByYear(String year);
}