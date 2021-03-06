package com.example.work1.dao;

import com.example.work1.model.MemberOrderVo;
import com.example.work1.model.ProductOrderVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductOrderDao {
    List<ProductOrderVo> listOrderByMember(int memberId);

    List<MemberOrderVo> listMemberAndOrder(String name, String email, int start);
}
