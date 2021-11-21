package com.example.work1.service;

import com.example.work1.dao.ProductOrderDao;
import com.example.work1.model.MemberOrderVo;
import com.example.work1.model.ProductOrderVo;
import com.example.work1.model.dto.ListMemberOrderDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductOrderService {
    private final ProductOrderDao productOrderDao;

    /**
     * 단일 회원의 주문목록 조회
     */
    public List<ProductOrderVo> listProductOrder(int memberId){
        return productOrderDao.listOrderByMember(memberId);
    }

    /**
     * 이름 혹은 전화번호 하나로만 검색이 가능함.
     * 여러회원 목록 조회
     */
    public List<MemberOrderVo> listMemberAndOrder(ListMemberOrderDto dto){
        if(dto.getPage() == 0) dto.setPage(1);
        //TODO parameter valid check
        String name = dto.getName(); //검색체크
        String email = null;
        if(name == null) email = dto.getEmail(); //검색체크

        int start = (dto.getPage() - 1) * 10;

        return productOrderDao.listMemberAndOrder(name, email, start);
    }

}
