package com.applocation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.controller","com.Service"})
@MapperScan("com.mapper")
@ServletComponentScan
public class UserApplication extends SpringBootServletInitializer {

    public static  void main(String [] args){
        SpringApplication.run(UserApplication.class,args);
    }

}
