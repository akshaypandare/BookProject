package com.texala.book.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.texala.book.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
	
	// findByBookName = findBy [introducer], BookName [Criteria]
	//Custom method for find 
	public List<Book> findByBookName(String bookName);
	public List<Book> findByBookAuthor(String bookAuthor);
}