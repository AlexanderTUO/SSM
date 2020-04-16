package com.tyk.redis;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: tyk
 * @Date: 2020/4/10 12:20
 * @Description:
 */
@Data
public class Person implements Serializable {
    private Integer age;
    private String name;

    public Person(Integer age, String name) {
        this.age = age;
        this.name = name;
    }
}
