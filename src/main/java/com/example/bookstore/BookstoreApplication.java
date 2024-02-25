package com.example.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.model.Book;
import com.example.bookstore.model.BookRepository;


@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository repository) {
		return (args) -> {
			log.info("saving a couple of books");
			repository.save(new Book("Huonetoveri", "Ruth Ware", 2023, "9789511484073", 10.95));
			repository.save(new Book("Tulivuoren varjossa", "Kari Enqvist", 2024, "9789510501634", 33.95));
			repository.save(new Book("Hyvän nimissä", "Donna Leon", 2022, "9789511461166", 28.95));
		
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
			
		};
	}
	

}
