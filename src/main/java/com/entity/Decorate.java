package com.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Decorate {

    int id;
    private String taxon;
    private String state;
    private Date beginTime;
    private Date updateTime;
    private char isNot;
    private String standby1;
    private String standby2;
    private String standby3;


}
