package fr.iocean.webapp.controller;

import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.iocean.webapp.model.Book;
import fr.iocean.webapp.service.LibraryService;

@RestController
public class LibraryController {

	@RequestMapping(value="/books", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Book> affiche() throws ParseException {
		return LibraryService.getAll();
	}
	
	@RequestMapping(value="/books/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Book affiche1(@PathVariable("id") int id) throws ParseException {
		return LibraryService.getById(id);
	}
	
	@RequestMapping(value="/books", method = RequestMethod.POST)
	public String affiche2(@RequestBody @Valid Book book) throws ParseException {
		return LibraryService.addBook(book)?"New book created":"Failed to creat new book";
	}
	
	@RequestMapping(value="/books/{id}", method = RequestMethod.DELETE)
	public String affiche3(@PathVariable("id") int id) throws ParseException {
		return LibraryService.removeBook(id)?"Book deleted!":"Book failed to be deleted";
	}
	
	@RequestMapping(value="/books/{id}", method = RequestMethod.PUT)
	public String affiche4(@RequestBody Book book) throws ParseException {
		return "Not yet done!!";
	}
}
