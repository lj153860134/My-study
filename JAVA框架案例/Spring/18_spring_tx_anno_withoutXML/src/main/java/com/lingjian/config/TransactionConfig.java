package com.lingjian.config;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @description: 事务相关的配置类
 * @author: Ling Jian
 * @date: 2020-02-18 13:24
 **/

public class TransactionConfig {
    /**
     * 用于创建事务管理对象
     * @param dataSource
     * @return
     */
    @Bean(name="transactionManager")
    public PlatformTransactionManager createTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
