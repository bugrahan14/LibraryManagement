package com.Library.library_management.Controller;

import com.Library.library_management.Entity.Member;
import com.Library.library_management.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    // ADD MEMBER (CREATE)
    @PostMapping
    public ResponseEntity<Member> createMember(@RequestBody Member member){
        Member createMember = memberService.createMember(member);
        return ResponseEntity.ok(createMember);
    }

    // LIST ALL MEMBERS (READ)
    @GetMapping
    public ResponseEntity<List<Member>> getAllMembers(){
        List<Member> members = memberService.getAllMembers();
        return ResponseEntity.ok(members);
    }

    // GETTING A MEMBER BY ID (READ)
    @GetMapping("/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable Long id ){
        Member member = memberService.getMemberById(id);
        return ResponseEntity.ok(member);
    }

    //  MEMBER UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Member> updateMember(@PathVariable Long id, @RequestBody Member memberDetails) {
        Member updatedMember = memberService.updateMember(id, memberDetails);
        return ResponseEntity.ok(updatedMember);
    }

    // MEMBER DELETE ( DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long id) {
        boolean isDeleted = memberService.deleteMember(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
















}
