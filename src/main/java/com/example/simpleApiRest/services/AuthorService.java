package com.example.simpleApiRest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.simpleApiRest.entities.Author;
import com.example.simpleApiRest.repositories.AuthorRepository;

@Service
public class AuthorService {
  
  private AuthorRepository repository;

  public AuthorService(AuthorRepository repository){
    this.repository = repository;
  }

  public List<Author> allAuthors(){
    return repository.findAll();
  }

  public Optional<Author> getAuthor(Long id){
    return repository.findById(id);
  }

  public Author postAuthor(Author author){
    return repository.save(author);
  }

  public boolean deleteAuthor(Long id){
    if(repository.existsById(id)){
      repository.deleteById(id);
      return true;
    }else{
      return false;
    }
    
  }
  public Author updateAuthor(Author author){
    return repository.save(author);
  }
}
