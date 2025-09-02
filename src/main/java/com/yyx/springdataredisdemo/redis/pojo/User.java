package com.yyx.springdataredisdemo.redis.pojo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String name;
    private Integer age;

    // 手动添加全参数构造函数
//    public User(String name, Integer age) {
//        this.name = name;
//        this.age = age;
//    }
}