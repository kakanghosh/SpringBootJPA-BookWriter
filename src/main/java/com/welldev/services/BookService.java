package com.welldev.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.welldev.models.Book;
import com.welldev.models.Writer;
import com.welldev.repositories.BookRepository;
import com.welldev.repositories.WriterRepository;

@Service
public class BookService {
//	private List<Writer> writers = new ArrayList<Writer>(Arrays.asList(new Writer(1, "ABC"), new Writer(2, "DEF"),
//			new Writer(3, "GHI"), new Writer(4, "JKL"), new Writer(5, "MNO")));
	@Autowired
	private BookRepository bookRepository;
	private List<Book> books = new ArrayList<Book>();

	public List<Book> getBooks(Integer writerID) {
		//return this.bookRepository.findByWriterId(writerID);
		return null;
	}

	public Optional<Book> getSingleBook(Integer writerID, Integer bookID) {
		return this.bookRepository.findById(bookID);
	}

	public Book addBook(Integer writerID, Book book) {
		//book.setWriter(new Writer(writerID, ""));
		return this.bookRepository.save(book);
	}

	public Book updateBook(Integer writerID, Integer bookID, Book book) {
		book.setId(bookID);
		//book.setWriter(new Writer(writerID, ""));
		return this.bookRepository.save(book);
	}

	public Boolean deleteBook(Integer writerID, Integer bookID) {
		this.bookRepository.deleteById(bookID);
		return this.bookRepository.findById(bookID).equals(Optional.empty())? true : false;
	}

}
