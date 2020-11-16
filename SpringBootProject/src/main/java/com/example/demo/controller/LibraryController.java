package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.service.LibraryService;

@RestController
@RequestMapping("/library")
public class LibraryController {
	
	@Autowired
	private LibraryService libraryService;
	
	public LibraryController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value = "/display_all", method = RequestMethod.GET )
	public String getAllBooks() {
		return this.libraryService.getAllBooks();
	}
	
	@RequestMapping(value = "/display/{id}", method = RequestMethod.GET)
	public String getBookById(@PathVariable("id") int id) {
		return this.libraryService.getBookById(id);
	}
	
//	@CrossOrigin
	@RequestMapping(value = "/addBook", method = RequestMethod.POST)
	public ResponseEntity<String> addBook(@RequestBody Book book) {
		this.libraryService.addBook(book);
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}

}
