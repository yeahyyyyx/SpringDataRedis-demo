package com.yyx.springdataredisdemo;

import com.yyx.springdataredisdemo.redis.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class RedisDemoApplicationTests {
    @Autowired
//    private RedisTemplate redisTemplate;
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    void testString() {
        redisTemplate.opsForValue().set("name", "yyx2");
        System.out.println(redisTemplate.opsForValue().get("name"));
        redisTemplate.opsForValue().set("age", 18);
        System.out.println(redisTemplate.opsForValue().get("age"));
    }
    @Test
    void testSaveUser() {
        //key分级存储
//        redisTemplate.opsForValue().set("user:100:name", "yyx");
//        redisTemplate.opsForValue().set("user:100:age", 18);
        redisTemplate.opsForValue().set("user:100", new User("yyx", 23));
        redisTemplate.opsForValue().set("user:1", new User("whq", 18));
        User object = (User)redisTemplate.opsForValue().get("user:100");
        System.out.println(object);
    }
}
