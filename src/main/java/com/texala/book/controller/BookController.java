package com.texala.book.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.texala.book.model.Book;
import com.texala.book.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	@PostMapping("/saveBook")
	public Book saveBook(@RequestBody Book book) {
		return bookService.saveBook(book);
	}

	@GetMapping("/books")
	public ResponseEntity<List<Book>> findAllBooks() {
		List<Book> list = bookService.findAllBooks();
		if (list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}

	@GetMapping("/book/{bookId}")
	public Optional<Book> findByBookId(@PathVariable("bookId") int bookId) {
		return bookService.findByBookId(bookId);
	}

	@GetMapping("/bookByName/{bookName}")
	public List<Book> findByBookName(@PathVariable("bookName") String bookName) {
		return bookService.findByBookName(bookName);
	}

	@GetMapping("/bookByAuthorName/{bookAuthor}")
	public List<Book> findByAuthorName(@PathVariable("bookAuthor") String bookAuthor) {
		return bookService.findByAuthorName(bookAuthor);
	}

	@DeleteMapping("/delete")
	public String deleteAllBooks() {
		return bookService.deleteAllBooks();
	}

	@DeleteMapping("/delete/{bookId}")
	public String deleteById(@PathVariable("bookId") int bookId) {
		return bookService.deleteById(bookId);
	}

	@PutMapping("/update")
	public Book updateBook(@RequestBody Book book) {
		return bookService.updateBook(book);
	}
}