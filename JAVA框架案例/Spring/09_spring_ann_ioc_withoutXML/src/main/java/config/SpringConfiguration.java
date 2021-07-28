package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * @description: 该类是一个配置类
 *               和bean.xml是一样的
 * @author: Ling Jian
 * @date: 2020-02-11 20:27
 **/
@Configuration   //这个可有可无 但最好配置类都加上这个注解
@ComponentScan(basePackages = {"com.lingjian"})
@Import(JdbcConfig.class)
@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfiguration {


}
