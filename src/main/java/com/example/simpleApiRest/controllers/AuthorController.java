package com.example.simpleApiRest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.simpleApiRest.entities.Author;
import com.example.simpleApiRest.services.AuthorService;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/authors")
public class AuthorController {
  @Autowired
  private AuthorService service;


  @GetMapping
  public ResponseEntity<List<Author>> allAuthors(){
    List<Author> authors = service.allAuthors();
    return ResponseEntity.ok(authors);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Author> getAuthor(@PathVariable Long id){
    Optional<Author> author = service.getAuthor(id);
    if(!author.isPresent()){
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(author.get());
  }
  

  @PostMapping
  public ResponseEntity<Author> postAuthor(@RequestBody Author author){
    if(author.getId() != null){
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok(service.postAuthor(author));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity deleteAuthor(@PathVariable Long id){
    if(!service.deleteAuthor(id)){
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok().build();
  }

  @PutMapping
  public ResponseEntity updateAuthor(@RequestBody Author author){
    if(author.getId() == null){
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok(service.updateAuthor(author));
  }

}
