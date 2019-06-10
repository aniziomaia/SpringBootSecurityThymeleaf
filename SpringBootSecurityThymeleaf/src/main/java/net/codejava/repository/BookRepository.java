package net.codejava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.codejava.model.Book;


public interface BookRepository extends JpaRepository<Book, String>{

	Book findById(long id);
}
