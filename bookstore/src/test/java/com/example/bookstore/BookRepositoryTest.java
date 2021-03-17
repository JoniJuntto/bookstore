package com.example.bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;

import org.junit.jupiter.api.Test;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTest {

	@Autowired
	private BookRepository repository;
	
	@Test
    public void findByTitleShouldReturnBook() {
    List<Book> books = (List<Book>) repository.findAll();
    assertThat(books.get(0).getTitle()).isEqualTo("Sapiens");
    }
	
	@Test
    public void createNewBook() {
    	Book book = new Book("Mikon elämä", "Joku äijä", "87687687", "87685665", 10000, null);
    	repository.save(book);
    	assertThat(book.getId()).isNotNull();
    }    
	
	@Test
	public void DeleteNewBook() {
		Book book = new Book("Mikon elämä", "Joku äijä", "87687687", "87685665", 10000, null);
    	repository.save(book);
    	repository.deleteById(book.getId());
	}
}
