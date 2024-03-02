package com.example.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.model.Book;
import com.example.bookstore.model.BookRepository;
import com.example.bookstore.model.Category;
import com.example.bookstore.model.CategoryRepository;


@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository categoryRepository) {
		return (args) -> {
			log.info("saving a couple of books");

			Category category1 = new Category("Draama");
			Category category2 = new Category("Fantasia");
			Category category3 = new Category("Scifi");

			categoryRepository.save(category1);
			categoryRepository.save(category2);
			categoryRepository.save(category3);

			repository.save(new Book("Huonetoveri", "Ruth Ware", 2023, "9789511484073", 10.95, category1));
			repository.save(new Book("Tulivuoren varjossa", "Kari Enqvist", 2024, "9789510501634", 33.95, category3));
			repository.save(new Book("Hyvän nimissä", "Donna Leon", 2022, "9789511461166", 28.95, category2));
		
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
			
		};
	}
	

}
