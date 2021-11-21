package com.example.work1.model;

import lombok.Data;

import java.util.Date;

/**
 * @author mail.kjh@gmail.com
 * @since 2021-11-22
 */
@Data
public class ProductOrderVo {
    private int orderId;
    private int productId;
    private String productName;
    private Date paidAt;
    private Date createdAt;
}
