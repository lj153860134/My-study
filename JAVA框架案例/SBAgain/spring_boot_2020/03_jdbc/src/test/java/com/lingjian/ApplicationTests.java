package com.lingjian;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootTest
class ApplicationTests {

    @Autowired
    DataSource dataSource;

    @Test
    public void test1() throws Exception{
        System.out.println(dataSource.getClass());

        Connection conn = dataSource.getConnection();
        System.out.println(conn);
        conn.close();

    }

}
