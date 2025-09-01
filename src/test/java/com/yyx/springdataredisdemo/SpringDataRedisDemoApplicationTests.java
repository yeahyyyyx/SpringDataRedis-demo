package com.yyx.springdataredisdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class SpringDataRedisDemoApplicationTests {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void testString() {
        redisTemplate.opsForValue().set("name", "yyx2");
        System.out.println(redisTemplate.opsForValue().get("name"));
        redisTemplate.opsForValue().set("age", 18);
        System.out.println(redisTemplate.opsForValue().get("age"));
    }
}
