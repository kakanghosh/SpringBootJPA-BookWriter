package com.welldev.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.welldev.models.Book;
import com.welldev.models.Writer;
import com.welldev.services.BookService;
import com.welldev.services.WriterService;

@RestController
public class BookController {

	@Autowired
	BookService bookService;

	@RequestMapping("/writers/{writer_id}/books")
	public List<Book> getBooks(@PathVariable("writer_id") Integer writerID) {
		return this.bookService.getBooks(writerID);
	}

	@RequestMapping("/writers/{writer_id}/books/{book_id}")
	public Optional<Book> getBook(@PathVariable("writer_id") Integer writerID, @PathVariable("book_id") Integer bookID) {
		return this.bookService.getSingleBook(writerID, bookID);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/writers/{writer_id}/books")
	public Book insertBook(@PathVariable("writer_id") Integer writerID, @RequestBody Book book) {
		return this.bookService.addBook(writerID, book);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/writers/{writer_id}/books/{book_id}")
	public Book updateBook(@PathVariable("writer_id") Integer writerID, @PathVariable("book_id") Integer bookID, @RequestBody Book book) {
		return this.bookService.updateBook(writerID, bookID, book);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/writers/{writer_id}/books/{book_id}")
	public Boolean deleteBook(@PathVariable("writer_id") Integer writerID, @PathVariable("book_id") Integer bookID) {
		return this.bookService.deleteBook(writerID, bookID);
	}
}
