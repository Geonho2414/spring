package dw.jdbcproject.controller;

import dw.jdbcproject.model.Member;
import dw.jdbcproject.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MemberController {
    @Autowired
    MemberService memberService;

    @PostMapping("/member/new")
    public ResponseEntity<Member> saveMember(@RequestBody Member member){
        return ResponseEntity.ok(memberService.saveMember(member));
    }

    @GetMapping("/member/get_id/{id}")
    public ResponseEntity<Optional<Member>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(memberService.findById(id));
    }

    @GetMapping("/member/get_name/{name}")
    public ResponseEntity<Optional<Member>> findByName(@PathVariable String name) {
        return ResponseEntity.ok(memberService.findByName(name));
    }

    @GetMapping("/members/get")
    public  ResponseEntity<List<Member>> getAllMembers(){
        return ResponseEntity.ok(memberService.getAllMembers());
    }
}
