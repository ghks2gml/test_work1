package com.example.work1;

import com.example.work1.model.Member;
import com.example.work1.service.MemberService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class 회원정보테스트 {
    @Autowired private MemberService memberService;

    @Test
    public void 회원가입(){
        Member member = new Member();
        member.setMemberName("derek.kim");
        member.setMemberAlias("닉네임");
        member.setEmail("mail.kjh@gamil.com");
        member.setPasswd("1234");
        member.setGender(1);
        member.setPhone("01064330801");
        memberService.join(member);
    }
}
