package com.aktog.library.repository;

import com.aktog.library.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,String> {
}