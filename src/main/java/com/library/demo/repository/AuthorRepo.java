package com.library.demo.repository;

import com.library.demo.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Id;


public interface AuthorRepo extends JpaRepository<Author, Long> {
    Author findByName(String name);
}


