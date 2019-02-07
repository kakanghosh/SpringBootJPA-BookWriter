package com.welldev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.welldev.models.Book;
import com.welldev.models.Writer;
import com.welldev.repositories.BookRepository;
import com.welldev.repositories.WriterRepository;

@SpringBootApplication
public class SpringRestApplication implements CommandLineRunner {

	@Autowired
	private WriterRepository writerRepository;
	@Autowired
	private BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringRestApplication.class, args);
		System.out.println("Hello World!");
	}

	@Override
	public void run(String... args) throws Exception {

		this.writerRepository.deleteAllInBatch();
		this.bookRepository.deleteAllInBatch();

		// Creating Writers
		Writer writer = new Writer(null, "Mr. XYZ");

		// Creating Books
		Book book1 = new Book(null, "Introduction to C");
		Book book2 = new Book(null, "Introduction to CPP");

		writer.getBooks().add(book1);
		writer.getBooks().add(book2);

		book1.getWriters().add(writer);
		book2.getWriters().add(writer);

		writerRepository.save(writer);
	}
}
