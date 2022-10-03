package com.example.simpleApiRest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.simpleApiRest.entities.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>{
  
}
