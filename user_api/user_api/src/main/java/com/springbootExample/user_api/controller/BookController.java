package com.springbootExample.user_api.controller;

import com.springbootExample.user_api.model.Book;
import com.springbootExample.user_api.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAllBook(){
        return ResponseEntity.ok(bookService.getAllBook());
    }

    @PostMapping("/save")
    public ResponseEntity<Book> saveBook(@RequestBody Book book){
        return ResponseEntity.ok(bookService.saveBook(book));
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id){
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @PutMapping("updateById/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book){
        return ResponseEntity.ok((bookService.updateBook(book,id)));
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
    }

    @PutMapping("updateByIdWithOwner/{idBook},{idOwner}")
    public ResponseEntity<Book> updateBookWithOwner(@PathVariable Long idBook, @RequestBody Book book, @PathVariable Long idOwner){
        return ResponseEntity.ok((bookService.updateBookWithOwner(book,idBook,idOwner)));
    }
}
