package com.entity;

import lombok.Data;

import java.util.Date;


/**
 * @Auther:位开心
 * @Date: 2019/12/16
 * @Description: com.entity
 * @version: 1.0
 */
@Data
public class Sys_user_name {

    private int id;
    private int userId;
    private String idNumber;
    private  String name;
    private Date beginTime;
    private Date updateTime;
    private char isNot;
    private String standby1;
    private String standby2;
    private String standby3;
}
