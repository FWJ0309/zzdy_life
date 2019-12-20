package com.entity;

import lombok.Data;

import java.util.Date;


@Data
public class Sys_user_electric {

    private int id;
    private int userId;
    private char electricUserNo;
    private String meterNo;
    private String areaCode;
    private String areaName;
    private char electricUserType;
    private String unitName;
    private String masterName;
    private String masterId;
    private String masterPhone;
    private String registrantName;
    private String registrantId;
    private String registrantPhone;
    private String electricFeeListSampleUrl;
    private String registrantPhotoUrl;
    private Date beginTime;
    private Date updateTime;
    private char isNot;
    private String standby1;
    private String standby2;
    private String standby3;


}
