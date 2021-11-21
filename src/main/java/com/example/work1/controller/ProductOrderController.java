package com.example.work1.controller;

import com.example.work1.model.MemberOrderVo;
import com.example.work1.model.ProductOrderVo;
import com.example.work1.model.dto.ListMemberOrderDto;
import com.example.work1.service.ProductOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductOrderController {
    private final ProductOrderService productOrderService;

    /**
     * 단일회원의 주문목록 조회
     */
    @GetMapping("/order/{memberId}")
    public ResponseEntity<List<ProductOrderVo>> listProductOrder(@PathVariable("memberId") int memberId){
        return new ResponseEntity<>(productOrderService.listProductOrder(memberId), HttpStatus.OK);
    }

    /**
     * 여러 회원 목록 조회
     */
    @PostMapping("/members")
    public ResponseEntity<List<MemberOrderVo>> listMemberOrder(@RequestBody ListMemberOrderDto dto){
        return new ResponseEntity<>(productOrderService.listMemberAndOrder(dto), HttpStatus.OK);
    }
}
