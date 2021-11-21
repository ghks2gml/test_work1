package com.example.work1.model;

import lombok.Data;

import java.util.Date;

@Data
public class ProductOrder {
    private int orderId;
    private int memberId;
    private int productId;
    private Date paidAt;
    private int lastOrder;
    private Date createdAt;
    private Date updatedAt;
}
