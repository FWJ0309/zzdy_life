package com.entity;

import lombok.Data;

import java.util.Date;
@Data
public class User {

    private int id;
    private String username;
    private String password;
    private String phone;
    private String email;
    private String nickname;
    private char sex;
    private int age;
    private String headImg;
    private String profession;
    private char realName;
    private char realEnterprise;
    private char realElectro;
    private char realOccupation;
    private Date beginTime;
    private Date updateTime;
    private char isNot;
    private String standby1;
    private String standby2;
    private String standby3;



}
