package com.Library.library_management.Entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "loans")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @ManyToOne
    @JoinColumn(name="book_id",nullable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(name="member_id",nullable = false)
    private Member member;

    @Column(name="loan_date",nullable = false)
    private Date loandate;

    @Column(name="return_date")
    private Date returndate;

    @Column(name = "status",nullable = false)
    private String status;

    @Column(name = "available_copies", nullable = false)
    private int availableCopies;

    public Loan() {
    }

    public Loan(Long id, Book book, Member member, Date loandate, Date returndate, String status, int availableCopies) {
        this.id = id;
        this.book = book;
        this.member = member;
        this.loandate = loandate;
        this.returndate = returndate;
        this.status = status;
        this.availableCopies = availableCopies;
    }

    public Long getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public Member getMember() {
        return member;
    }

    public Date getLoandate() {
        return loandate;
    }

    public Date getReturndate() {
        return returndate;
    }

    public String getStatus() {
        return status;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public void setLoandate(Date loandate) {
        this.loandate = loandate;
    }

    public void setReturndate(Date returndate) {
        this.returndate = returndate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", book=" + book +
                ", member=" + member +
                ", loandate=" + loandate +
                ", returndate=" + returndate +
                ", status='" + status + '\'' +
                ", availableCopies=" + availableCopies +
                '}';
    }
}
