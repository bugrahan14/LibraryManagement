package com.Library.library_management.Service;

import com.Library.library_management.Entity.Loan;
import com.Library.library_management.Repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {
    @Autowired
    private LoanRepository loanRepository;

    // ÖDÜNÇ ALMA İŞLEMİ (CREATE)
    public Loan createLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    // TÜM ÖDÜNÇLERİ LİSTELEME (READ)
    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    // İD E GÖRE BİR ÖDÜNÇ İŞLEMİNE BAKMA (READ)
    public Loan getLoanById(Long id) {
        return loanRepository.findById(id).orElse(null);
    }

    // ÖDÜNÇ GÜNCELLEME (UPDATE)
    public Loan updateLoan(Long id, Loan loanDetails) {
        Loan existingLoan = loanRepository.findById(id).orElse(null);
        if (existingLoan != null) {
            existingLoan.setBook(loanDetails.getBook());
            existingLoan.setMember(loanDetails.getMember());
            existingLoan.setLoandate(loanDetails.getLoandate());
            existingLoan.setReturndate(loanDetails.getReturndate());
            existingLoan.setStatus(loanDetails.getStatus());
            return loanRepository.save(existingLoan);
        }
        return null;
    }

    // Ödünç silme (Delete)
    public boolean deleteLoan(Long id) {
        if (loanRepository.existsById(id)) {
            loanRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
