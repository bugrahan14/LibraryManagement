package com.Library.library_management.Repository;

import com.Library.library_management.Entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {


    // Örneğin, üye ID'sine göre ödünç alma işlemi aramak için bir metod:
    List<Loan> findByMemberId(Long memberId);
}
