package com.Library.library_management.Controller;

import com.Library.library_management.Entity.Loan;
import com.Library.library_management.Service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanController {
    @Autowired
    private LoanService loanService;

    // LİST ALL BORROWED BOKKS
    @GetMapping
    public ResponseEntity<List<Loan>> getAllLoans() {
        List<Loan> loans = loanService.getAllLoans();
        return ResponseEntity.ok(loans);
    }

    // BORROWİNG A BOOK BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Loan> getLoanById(@PathVariable Long id) {
        Loan loan = loanService.getLoanById(id);
        if (loan != null) {
            return ResponseEntity.ok(loan);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // ADDİNG A NEW LOANER BOKK
    @PostMapping
    public ResponseEntity<Loan> createLoan(@RequestBody Loan loan) {
        Loan createdLoan = loanService.createLoan(loan);
        return ResponseEntity.status(201).body(createdLoan);  // 201 Created
    }

    // UPDATE LOAN BOOKS
    @PutMapping("/{id}")
    public ResponseEntity<Loan> updateLoan(@PathVariable Long id, @RequestBody Loan loanDetails) {
        Loan updatedLoan = loanService.updateLoan(id, loanDetails);
        if (updatedLoan != null) {
            return ResponseEntity.ok(updatedLoan);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETİNG A LOANED BOOK
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoan(@PathVariable Long id) {
        boolean isDeleted = loanService.deleteLoan(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();  // 204 No Content
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
