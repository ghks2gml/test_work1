package com.example.work1.model;

import lombok.Data;

import java.util.Date;

@Data
public class Product {
    private int productId;
    private String productName;
    private Date createdAt;
    private Date updatedAt;
}
