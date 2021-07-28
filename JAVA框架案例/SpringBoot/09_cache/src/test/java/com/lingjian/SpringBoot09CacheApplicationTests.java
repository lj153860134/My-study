package com.lingjian;

import com.lingjian.domain.Employee;
import com.lingjian.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Arrays;

@SpringBootTest
class SpringBoot09CacheApplicationTests {

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    RedisTemplate<Object, Employee> empRedisTemplate;


    @Test
    void contextLoads() {
        Employee employee = employeeMapper.getEepById(1);
        System.out.println(employee);
    }

    @Test
    public void test1() {
//        stringRedisTemplate.opsForValue().append("lingjian","xvxiaomeng");
        String str = stringRedisTemplate.opsForValue().get("lingjian");
        System.out.println(str);
    }

    //测试保存对象
    @Test
    public void test2() {
        Employee employee = employeeMapper.getEepById(2);
//        redisTemplate.opsForValue().set("emp-1",employee);
        empRedisTemplate.opsForValue().set("emp-1",employee);
    }


}
