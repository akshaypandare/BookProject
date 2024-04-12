package com.texala.book.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.texala.book.model.Book;
import com.texala.book.repository.BookRepository;

@ExtendWith(MockitoExtension.class)
public class BookSericeTest {

	@Mock
	private BookRepository bookRepository;
	
	@InjectMocks
	private BookService bookService;
	
	Book book1,book2;
	List<Book> list;
	
	@BeforeEach
	public void init() {
		
		book1 = new Book();
		book1.setBookId(1001);
		book1.setBookName("Java");
		book1.setBookAuthor("Akshay");

		
	}
	
	@DisplayName("Should save the record.")
	@Test
	public void save() {
		
		when(bookRepository.save(book1)).thenReturn(book1);
		
		Book newBook = bookService.saveBook(book1);
		
		assertNotNull(newBook);
		assertThat(newBook.getBookId()).isEqualTo(1001);

	}
	
	@DisplayName("Should save the record.")
	@Test
	public void findAllBooks() {
		
		list = new ArrayList<>();
		list.add(book1);
		
		when(bookRepository.findAll()).thenReturn(list);
		
		List<Book> newList = bookService.findAllBooks();
		
		assertNotNull(newList);
		assertThat(newList.size()).isEqualTo(1);

	}
}
