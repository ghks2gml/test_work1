package com.example.work1.dao;

import com.example.work1.model.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author mail.kjh@gmail.com
 * @since 2021-11-22
 */
@Mapper
public interface MemberDao {
    int insertMember(Member member);

    Member getMemberByEmailAndPasswd(String email, String passwd);

    Member getMember(int memberId);

}
