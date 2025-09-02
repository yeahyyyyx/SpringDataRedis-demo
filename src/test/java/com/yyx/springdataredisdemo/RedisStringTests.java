package com.yyx.springdataredisdemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yyx.springdataredisdemo.redis.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class RedisStringTests {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void testString() {
        stringRedisTemplate.opsForValue().set("name", "yyx2");
        System.out.println(stringRedisTemplate.opsForValue().get("name"));
//        stringRedisTemplate.opsForValue().set("age", 18);
//        System.out.println(stringRedisTemplate.opsForValue().get("age"));
    }

    private static final ObjectMapper mapper = new ObjectMapper();
    @Test
    void testSaveUser() throws JsonProcessingException {
        //创建对象
        User user = new User("yyx", 23);
        //手动序列化
        String json = mapper.writeValueAsString( user);
        //写入数据
        stringRedisTemplate.opsForValue().set("user:200", json);
        //获取数据
        String jsonUser = stringRedisTemplate.opsForValue().get("user:200");
        //手动反序列化
        User object = mapper.readValue(jsonUser, User.class);
        System.out.println(object);
    }
    @Test
    void testHash() {
        stringRedisTemplate.opsForHash().put("user:400", "name", "yyx");
        stringRedisTemplate.opsForHash().put("user:400", "age", "18");
        System.out.println(stringRedisTemplate.opsForHash().entries("user:400"));
    }
}
