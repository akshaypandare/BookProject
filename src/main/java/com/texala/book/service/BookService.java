package com.texala.book.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.texala.book.model.Book;
import com.texala.book.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}

	public Optional<Book> findByBookId(int bookId) {
		return bookRepository.findById(bookId);
	}

	public List<Book> findAllBooks() {
		return bookRepository.findAll();
	}

	public String deleteById(int bookId) {
		bookRepository.deleteById(bookId);
		return "Record Deleted...";
	}

	public String deleteAllBooks() {
		bookRepository.deleteAll();
		return "All books are deleted...";
	}

	public List<Book> findByBookName(String bookName) {
		return bookRepository.findByBookName(bookName);
	}

	public List<Book> findByAuthorName(String bookAuthor) {
		return bookRepository.findByBookAuthor(bookAuthor);
	}

	public Book updateBook(Book book) {
		return bookRepository.save(book);
	}
}