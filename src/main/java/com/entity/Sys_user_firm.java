package com.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Sys_user_firm {


    private int id;
    private int userId;
    private String frimName;
    private String frimImg;
    private String intro;
    private Date beginTime;
    private Date updateTime;
    private char isNot;
    private String standby1;
    private String standby2;
    private String standby3;
    private String standby4;
    private String standby5;
    private String standby6;


}
