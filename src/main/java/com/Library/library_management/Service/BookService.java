package com.Library.library_management.Service;

import com.Library.library_management.Entity.Book;
import com.Library.library_management.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // KİTAP EKLEME (CREATE)
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    // KİTAPLARI LİSTELEME (READ)
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // İD GÖRE KİTAP GETİRME (READ)
    public Book getBookById(Long id) {
        // Kitap ID'sine göre kitap bulur. Eğer bulunmazsa null döner.
        Book book = bookRepository.findById(id).orElse(null);
        return book;
    }


    // KİTAP GÜNCELLEME (UPDATE)
    public Book updateBook(Long id, Book bookDetails) {
        // Kitap ID'sine göre kitap mevcut mu kontrol et
        Book existingBook = bookRepository.findById(id).orElse(null);

        if (existingBook == null) {
            return null ; // Eğer kitap bulunmazsa null döner
        }

        // Kitap mevcutsa, kitap detaylarını güncelle
        existingBook.setTitle(bookDetails.getTitle());
        existingBook.setAuthor(bookDetails.getAuthor());
        existingBook.setIsbn(bookDetails.getIsbn());
        existingBook.setPublish_data(bookDetails.getPublish_data());
        existingBook.setCategory(bookDetails.getCategory());

        // Güncellenmiş kitabı kaydet ve geri döndür
        return bookRepository.save(existingBook);
    }


    // KİTAP SİLME (DELETE)
    public boolean deleteBook(Long id) {
        // Kitap ID'sine göre kitap var mı kontrol et
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id); // Kitap varsa sil
            return true;
        }
        return false; // Kitap bulunmazsa false döner
    }


}
