package com.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Auther:位开心
 * @Date: 2019/12/16
 * @Description: com.entity
  @version: 1.0
 */
@Data
public class Sys_user_profession1 {

    private int id;
    private int userId;
    private String userName;
    private String userCid;
    private String type;
    private String introduce;
    private String serviceArea;
    private int  state;
}
