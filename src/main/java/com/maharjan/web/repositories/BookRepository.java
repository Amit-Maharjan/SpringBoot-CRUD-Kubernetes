package com.maharjan.web.repositories;

import com.maharjan.web.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {
}
