package com.Library.library_management.Entity;

import jakarta.persistence.*;
import org.springframework.transaction.annotation.Transactional;

@Entity
@Table(name="books")
public class Book {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(name="title",nullable = false)
    private String title;

    @Column(name="author",nullable = false)
    private  String author;

    @Column(name="isbn",nullable = false)
    private String isbn;

    @Column(name="publish_data")
    private String publish_data;

    @Column(name="category")
    private String category;

    public Book() {
    }

    public Book(Long id, String title, String author, String isbn, String publish_data, String category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publish_data = publish_data;
        this.category = category;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setPublish_data(String publish_data) {
        this.publish_data = publish_data;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getPublish_data() {
        return publish_data;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getAuthor() {
        return author;
    }


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publish_data='" + publish_data + '\'' +
                ", category='" + category + '\'' +
                '}';
    }


}
