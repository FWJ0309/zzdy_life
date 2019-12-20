package com.controller;

import com.Service.UserService;
import com.entity.User;
import com.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class IndexController {
    @Autowired
    private  UserService userService;



    @GetMapping("/selectAll")
    public Msg getUser(){
        try {
            List<User> list = userService.selectUsers();
            return  Msg.success().add("list",list);
        } catch (Exception e) {
            e.printStackTrace();
           return  Msg.fail();
        }





    }







}
