package com.library.rest.service.impl;

/**
 * @author ANIZAM
 *
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.library.rest.model.Book;
import com.library.rest.repository.BookRepository;
import com.library.rest.service.BookService;

@Service
@Transactional
public class BookServiceImpl implements BookService {
	
	private BookRepository bookRepository;
	
	@Autowired
	public void setbookRepository(BookRepository bookRepository) {
		// TODO Auto-generated method stub
		this.bookRepository = bookRepository;
	}

	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		return bookRepository.findAll();
	}
	
	@Override
	public Book saveBook(Book book) {
		// TODO Auto-generated method stub
		int totalData = bookRepository.getTotalData();
		int seqId = 0;	
		if(totalData == 0) {
			seqId = 1;
		}else {
			seqId = bookRepository.getSequenceId()+1;
		}
		book.setId(seqId);
		book.setIdbook("BOOK"+seqId);
		book.setStatus(true);		
		return bookRepository.save(book);
	}

	@Override
	public void updateBook(Book book) {
		// TODO Auto-generated method stub
		Book entity = bookRepository.findByIdbook(book.getIdbook());
		if(entity != null) {
			entity.setTitle(book.getTitle());
			entity.setDescription(book.getDescription());
			entity.setYear(book.getYear());
			entity.setAvailability(book.getAvailability());
			entity.setAuthor(book.getAuthor());
			entity.setStatus(true);
		}
	}

	@Override
	public void deleteBook(String idbook) {
		// TODO Auto-generated method stub
		Book entity = bookRepository.findByIdbook(idbook);
		if(entity != null) {
			entity.setStatus(false);
		}
	}

	@Override
	public Book findByIdbook(String idbook) {
		// TODO Auto-generated method stub
		return bookRepository.findByIdbook(idbook);
	}

	@Override
	public void updateBookLeft(String idbook, int availability) {
		// TODO Auto-generated method stub
		Book book = bookRepository.findByIdbook(idbook);
		book.setAvailability(availability);
	}

	@Override
	public List<Book> findByYear(String year) {
		// TODO Auto-generated method stub
		List<Book> listBookYear = bookRepository.findByYear(year);
		return listBookYear;
	}

	@Override
	public List<Book> findByGenre(String genre) {
		// TODO Auto-generated method stub
		List<Book> listBookGenre = bookRepository.findByGenre(genre);
		return listBookGenre;
	}

	@Override
	public List<Book> filterBook(String year, String genre) {
		// TODO Auto-generated method stub
		List<Book> filterBook = bookRepository.filterBook(year, genre);
		return filterBook;
	}	
	
}
