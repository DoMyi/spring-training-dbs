package com.example.demo.service;

import java.util.HashMap;
//import java.util.ArrayList;
//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;

@Service
public class LibraryService {
	
	@Autowired
	private GsonUtilService gsonUtilService;
	
	@Autowired
	private BookRepository bookRepository;
	
	private HashMap<Integer, Book> books;

	public LibraryService() {
		// TODO Auto-generated constructor stub
//		this.books = new HashMap<>();
//		this.books.put(34567, new Book(34567, "Java Spring", "Pearson", 150));
//		this.books.put(34568, new Book(34567, "Spring MVC", "Tata McGraw Hill", 1200.89));
//		this.books.put(34569, new Book(34567, "Spring REST", "OReilly", 98.98));
//		this.books.put(34570, new Book(34567, "Spring Security", "FlyingBird", 78.08));
//		
//		bookRepository.saveAll(this.books.values());
	}
	
	
	public String getAllBooks() {
		return this.gsonUtilService.simpleJson(bookRepository.findAll());
	}
	
	public String getBookById(long id) {
		return this.gsonUtilService.simpleJson(bookRepository.findById(id));
	}
	
	public void addBook(Book book) {
//		this.books.put((int)book.getId(), book);
		bookRepository.save(book);
	}
	
	public String deleteBook(long id) {
		Book deletedBook = bookRepository.findById(id).orElse(null);
		bookRepository.deleteById(id);
		return gsonUtilService.simpleJson(deletedBook);
	}
	
	

}
