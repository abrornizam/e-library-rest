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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.rest.model.Book;
import com.library.rest.model.Genre;
import com.library.rest.service.AuthorService;
import com.library.rest.service.BookService;
import com.library.rest.service.GenreService;

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
	
	@Autowired
	GenreService genreService;

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
	
	@GetMapping(value = "/{genre}")
	public @ResponseBody List<Book> listBookByGenre(@PathVariable String genre, HttpServletResponse response) {
		response.setContentType("application/json");
		response.setStatus(200);
		return bookService.findByGenre(genre);
	}
	
	@GetMapping(value = "/filter")
	public @ResponseBody List<Book> filterBook(@RequestParam("year") String year, @RequestParam("genre") String genre, HttpServletResponse response) {
		response.setContentType("application/json");
		response.setStatus(200);
		if(year.equalsIgnoreCase("Year") && genre.equalsIgnoreCase("Genre")){
			return listBook(response);
		}else if(year != "Year" && genre.equalsIgnoreCase("Genre")) {
			return listBookByYear(year, response);
		}else if(year.equalsIgnoreCase("Year") && genre != "Genre") {
			return listBookByGenre(genre, response);
		}else if(year != "Year" && genre != "Genre"){
			return bookService.filterBook(year, genre);		
		}else {
			return listBook(response);
		}
	}
	
	/* GENRE */
	
	@GetMapping(value = "/genre")
	public @ResponseBody List<Genre> listGenre(HttpServletResponse response) {
		response.setContentType("application/json");
		response.setStatus(200);
		return genreService.findAll();
	}
	
	@PostMapping(value = "/genre/save")
	public @ResponseBody Genre saveData(@RequestBody Genre genre, HttpServletResponse response) {
		response.setContentType("application/json");
		response.setStatus(200);
		return genreService.saveData(genre);
	}
	
	@GetMapping(value = "/genre/detail/{id}")
	public @ResponseBody Genre detailGenre(@PathVariable int id, HttpServletResponse response) {
		response.setContentType("application/json");
		response.setStatus(200);
		return genreService.detailData(id);
	}
	
	@PutMapping(value = "/genre/edit/{id}")
	public @ResponseBody void editGenre(@RequestBody Genre genre, HttpServletResponse response) {
		response.setContentType("application/json");
		response.setStatus(200);
		genreService.updateData(genre);
	}
	
	@DeleteMapping(value = "/genre/delete/{id}")
	public @ResponseBody void deleteGenre(@PathVariable int id, HttpServletResponse response) {
		response.setContentType("application/json");
		response.setStatus(200);
		genreService.deleteData(id);
	}
	
}
