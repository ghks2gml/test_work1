package com.example.work1.controller;

import com.example.work1.model.Member;
import com.example.work1.model.dto.LoginDto;
import com.example.work1.model.dto.LoginResultDto;
import com.example.work1.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author mail.kjh@gmail.com
 * @since 2021-11-22
 */
@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/join")
    public ResponseEntity<Void> join(@RequestBody Member member){
        memberService.join(member);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResultDto> login(@RequestBody LoginDto dto){
        return new ResponseEntity<>(memberService.login(dto), HttpStatus.OK);
    }

    @GetMapping("/info")
    public ResponseEntity<Member> info(@RequestAttribute("member") Member member){
        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    @GetMapping("/info/{memberId}")
    public ResponseEntity<Member> infoByMemberId(@PathVariable(name = "memberId") int memberId){
        return new ResponseEntity<>(memberService.getMember(memberId), HttpStatus.OK);
    }

}
