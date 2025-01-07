package com.Library.library_management.Repository;

import com.Library.library_management.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    // Burada ek olarak özelleştirilmiş sorgular yazabilirsiniz.
    // Örneğin, ISBN ile kitap aramak için bir metod:
    Book findByIsbn(String isbn);
}
