package com.example.work1.model;

import lombok.Data;

import java.util.Date;

/**
 * @author mail.kjh@gmail.com
 * @since 2021-11-22
 */
@Data
public class Member {
    private int memberId;
    private String memberName;
    private String memberAlias;
    private String passwd;
    private String phone;
    private String email;
    private int gender;
    private Date createdAt;
    private Date updatedAt;
}
