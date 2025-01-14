package com.Library.library_management.Controller;

import com.Library.library_management.Entity.Book;
import com.Library.library_management.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    //  ADD BOOK (CREATE)
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book){

        Book savedBook = bookService.createBook(book);
        return ResponseEntity.ok(savedBook);
    }

    //  LIST ALL BOOKS (READ)
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);

    }

    //  BRINGING BOOKS BY ID (READ)
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id){
        Book book = bookService.getBookById(id);
        if (book != null){
            return  ResponseEntity.ok(book); // 200 OK
        }
        else{
            return ResponseEntity.notFound().build(); // IF BOOK NOT FOUND HTTP 404 RETURNS
        }
    }

    //  BOOK UPDATE (UPDATE)
    @PutMapping("/{id}")
    public  ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
        // The {id} in the URL and the JSON information received in the request are retrieved.
        Book updatedBook = bookService.updateBook(id, bookDetails);
        if (updatedBook != null) {
            return ResponseEntity.ok(updatedBook); // HTTP 200 (OK)
        } else {
            return ResponseEntity.notFound().build(); // 404 (Not Found)
        }
    }

    // BOOK DELETE (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        // The {id} part of the URL is taken
        boolean isDeleted = bookService.deleteBook(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();// HTTP 204 (No Content)
        } else {
            return ResponseEntity.notFound().build(); // HTTP 404 (Not Found)
        }
    }





















}
