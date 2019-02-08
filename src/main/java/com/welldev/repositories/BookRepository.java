package com.welldev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.welldev.models.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{
	//List<Book> findByWriterId(Integer writerID);
}
