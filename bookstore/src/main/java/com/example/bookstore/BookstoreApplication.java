package com.example.bookstore;

import org.springframework.boot.CommandLineRunner;
import com.example.bookstore.domain.User;
import com.example.bookstore.domain.UserRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.Category;
import com.example.bookstore.domain.CategoryRepository;


//Samuli Raivio auttanut koodin kanssa REST osioon asti!

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository bRepository, CategoryRepository cRepository, UserRepository userRepository) {
		return (args) -> {

			Category c1 = new Category("fiction");
			Category c2 = new Category("nonfiction");

			cRepository.save(c1);
			cRepository.save(c2);

			Book b1 = new Book("Sapiens", "Yuval Noah Harari", "2017", "9789522794703", 12.95, c2);
			Book b2 = new Book("The Subtle Art of Not Giving a F*ck", "Mark Manson", "2017", "9780062641540", 15.50,
					c2);
			Book b3 = new Book("Rumo", "Walter Moers", "2005", "0099472228", 30.97, c1);

			bRepository.save(b1);
			bRepository.save(b2);
			bRepository.save(b3);

			// Create users: admin/admin user/user
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			userRepository.save(user1);
			userRepository.save(user2);

		};

	}

}
