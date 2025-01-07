package com.Library.library_management.Service;

import com.Library.library_management.Entity.Member;
import com.Library.library_management.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    // ÜYE EKLEME (CREATE)
    public Member createMember(Member member){
        return memberRepository.save(member);
    }

    // TÜM ÜYELERİ LİSTELEME (READ)
    public List<Member> getAllMembers(){
        return memberRepository.findAll();
    }

    // İD E GÖRE BİR ÜYE GETİRME (READ)
    public Member getMemberById(Long id){
        return memberRepository.findById(id).orElse(null);
    }

    // ÜYE GÜNVCELLEME (UPDATE)
    public Member updateMember(Long id, Member memberDetails) {
        Member existingMember = memberRepository.findById(id).orElse(null);
        if (existingMember != null) {
            existingMember.setFirst_name(memberDetails.getFirst_name());
            existingMember.setLast_name(memberDetails.getLast_name());
            existingMember.setEmail(memberDetails.getEmail());
            existingMember.setPhone_number(memberDetails.getPhone_number());
            existingMember.setMembership_date(memberDetails.getMembership_date());
            return memberRepository.save(existingMember);
        }
        return null;
    }

    // ÜYE SİLME (DELETE)
    public boolean deleteMember(Long id) {
        if (memberRepository.existsById(id)) {
            memberRepository.deleteById(id);
            return true;
        }
        return false;
    }






}
