package com.lingjian.user;

import com.lingjian.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConsumerUserApplicationTests {


    @Autowired
    UserService userService;
    @Test
    void contextLoads() {
        userService.hello();
    }

}
