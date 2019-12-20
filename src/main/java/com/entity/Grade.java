package com.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Grade {

    private  int id;
    private  int missionId;
    private  int orderId;
    private  int appraiserId;
    private  int grade;

    private Date beginTime;
    private Date updateTime;
    private char isNot;
    private String standby1;
    private String standby2;
    private String standby3;



}
