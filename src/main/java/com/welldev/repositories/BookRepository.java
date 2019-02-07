package com.welldev.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.welldev.models.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{
	//List<Book> findByWriterId(Integer writerID);
}
