/**
 * 
 */
package com.library.rest.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.rest.model.Book;
import com.library.rest.service.BookService;
import com.library.rest.service.AuthorService;

/**
 * @author ANIZAM
 *
 */

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/rest/library/book")
public class BookController {

	@Autowired
	BookService bookService;
	
	@Autowired
	AuthorService authorService;

	@GetMapping(value = "/listBook")
	public @ResponseBody List<Book> listBook(HttpServletResponse response) {
		response.setContentType("application/json");
		response.setStatus(200);
		return bookService.findAll();
	}
	
	@PostMapping(value = "/save")
	public @ResponseBody Book saveBuku(@RequestBody Book book, HttpServletResponse response) {
		response.setContentType("application/json");
		response.setStatus(200);
		return bookService.saveBook(book);
	}
	
	@GetMapping(value = "/detail/{idbook}")
	public @ResponseBody Book detailBook(@PathVariable String idbook, HttpServletResponse response) {
		response.setContentType("application/json");
		response.setStatus(200);
		return bookService.findByIdbook(idbook);
	}
	
	@PutMapping(value = "/edit/{idbook}")
	public @ResponseBody void editBook(@RequestBody Book book, HttpServletResponse response) {
		response.setContentType("application/json");
		response.setStatus(200);
		bookService.updateBook(book);
	}
	
	@DeleteMapping(value = "/delete/{idbook}")
	public @ResponseBody void deleteBook(@PathVariable String idbook, HttpServletResponse response) {
		response.setContentType("application/json");
		response.setStatus(200);
		bookService.deleteBook(idbook);
	}
	
	@GetMapping(value = "/{year}")
	public @ResponseBody List<Book> listBookByYear(@PathVariable String year, HttpServletResponse response) {
		response.setContentType("application/json");
		response.setStatus(200);
		return bookService.findByYear(year);
	}
	
}
