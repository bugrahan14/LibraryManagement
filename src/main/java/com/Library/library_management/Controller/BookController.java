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

    // KİTAP EKLEME (CREATE)
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book){

        Book savedBook = bookService.createBook(book);
        return ResponseEntity.ok(savedBook);
    }

    // TÜM KİTAPLARI LİSTELEME (READ)
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);

    }

    // İD E GÖRE KİTAP GETİRME (READ)
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id){
        Book book = bookService.getBookById(id);
        if (book != null){
            return  ResponseEntity.ok(book); // 200 OK
        }
        else{
            return ResponseEntity.notFound().build(); // KİTAP BULUNAMAZSA HTTP 404 DÖNER
        }
    }

    // KİTAP GÜNCELLEME (UPDATE)
    @PutMapping("/{id}")
    public  ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
        // URL'deki {id} ve istekte gelen JSON bilgileri alınır.
        Book updatedBook = bookService.updateBook(id, bookDetails);
        if (updatedBook != null) {
            return ResponseEntity.ok(updatedBook); // HTTP 200 (OK) ile döner.
        } else {
            return ResponseEntity.notFound().build(); // 404 (Not Found) döner.
        }
    }

    // KİTAP SİLME (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        // URL'deki {id} kısmı alınır.
        boolean isDeleted = bookService.deleteBook(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();// HTTP 204 (No Content) döner.
        } else {
            return ResponseEntity.notFound().build(); // HTTP 404 (Not Found) döner.
        }
    }





















}
