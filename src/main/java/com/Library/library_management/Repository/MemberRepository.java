package com.Library.library_management.Repository;

import com.Library.library_management.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    // Burada ek olarak özelleştirilmiş sorgular yazabilirsiniz.
    // Örneğin, email ile üye aramak için bir metod:
    Member findByEmail(String email);
}
