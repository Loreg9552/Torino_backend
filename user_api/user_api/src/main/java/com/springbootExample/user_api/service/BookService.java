package com.springbootExample.user_api.service;

import com.springbootExample.user_api.model.Book;
import com.springbootExample.user_api.model.User;
import com.springbootExample.user_api.repository.BookRepository;
import com.springbootExample.user_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    public Book saveBook(Book book){
        if (book.getOwner() != null && book.getOwner().getId() != null) {
            User owner = userRepository.findById(book.getOwner().getId())
                    .orElseThrow(() -> new RuntimeException("Utente non trovato"));
            book.setOwner(owner);
        }

        return bookRepository.save(book);
    }

    public List<Book> getAllBook(){
        return bookRepository.findAll();
    }

    public Book getBookById(Long bookId){
        return bookRepository.findById(bookId).orElseThrow();
    }

    public Book updateBook(Book bookToUpdate,Long bookId){
        Book book = bookRepository.findById(bookId).orElseThrow();
        book.setTitle(bookToUpdate.getTitle());
        if (bookToUpdate.getOwner() != null && bookToUpdate.getOwner().getId() != null) {
            User newOwner = userRepository.findById(bookToUpdate.getOwner().getId())
                    .orElseThrow(() -> new RuntimeException("Nuovo proprietario non trovato"));
            book.setOwner(newOwner);
        }

        return bookRepository.save(book);
    }

    public void deleteBook(Long bookId){
        if(bookRepository.existsById(bookId)){
            bookRepository.deleteById(bookId);
        }
    }

    public Book updateBookWithOwner(Book bookToUpdate,Long bookId,Long ownerId){
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Libro non trovato"));
        User owner = userRepository.findById(ownerId)
                .orElseThrow(() -> new RuntimeException("Utente non trovato"));
        book.setTitle(bookToUpdate.getTitle());
        book.setOwner(owner);

        return bookRepository.save(book);
    }
}
