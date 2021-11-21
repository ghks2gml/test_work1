package com.example.work1.service;

import com.example.work1.dao.MemberDao;
import com.example.work1.exception.ServerException;
import com.example.work1.model.Member;
import com.example.work1.model.dto.LoginDto;
import com.example.work1.model.dto.LoginResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author mail.kjh@gmail.com
 * @since 2021-11-22
 */
@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberDao memberDao;
    private final TokenService tokenService;

    public void join(Member member){
        //TODO 회원이 존재 하는지 확인

        //TODO validation check

        Date current = new Date();
        member.setCreatedAt(current);
        member.setUpdatedAt(current);
        memberDao.insertMember(member);
    }

    public LoginResultDto login(LoginDto dto){
        //TODO validation check

        //step : 이메일, 비밀번호로 회원가져오기
        Member member = memberDao.getMemberByEmailAndPasswd(dto.getEmail(), dto.getPasswd());
        if(member == null){
            //TODO error message 작업
            throw new ServerException(501, "이메일 혹은 비밀번호가 틀렸습니다.");
        }

        //step : jwt 토큰 발생하기
        LoginResultDto resultDto = new LoginResultDto();
        resultDto.setToken(tokenService.token(member.getMemberId()));
        return resultDto;
    }

    public Member getMember(int memberId){
        Member member = memberDao.getMember(memberId);
        if(member == null){
            throw new ServerException(507, "회원을 찾을 수 없습니다.");
        }
        return member;
    }
}
