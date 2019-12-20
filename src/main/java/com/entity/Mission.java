package com.entity;

import lombok.Data;

import java.util.Date;


@Data
public class Mission {

    private int id;
    private int userId;
    private String area;
    private String address;
    private Double longitude;
    private Double latitude;
    private int sort;
    private String title;
    private String describel;
    private String img;
    private String contact;
    private String cPhone;
    private int orderId;
    private String evaluate;
    private String state;


    private Date beginTime;
    private Date updateTime;
    private char isNot;
    private String standby1;
    private String standby2;
    private String standby3;


}
