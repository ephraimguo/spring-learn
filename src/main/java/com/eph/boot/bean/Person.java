package com.eph.boot.bean;

import lombok.Data;

import java.util.Date;

@Data
public class Person {

    private Integer age;
    private Date Birth;
    private String username;
    private Pet pet;
}
