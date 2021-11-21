package com.example.work1.model;

import lombok.Data;

import java.util.Date;

@Data
public class MemberOrderVo extends Member {
    private int orderId;
    private Date paidAt;
    private int productId;
    private String productName;
}
