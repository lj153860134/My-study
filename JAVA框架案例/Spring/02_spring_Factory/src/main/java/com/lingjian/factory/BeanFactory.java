package com.lingjian.factory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLOutput;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @description: 创建Bean对象的工厂
 * @author: Ling Jian
 * @date: 2020-02-10 11:38
 **/
public class BeanFactory {

    //定义一个Properties对象
    private static Properties props;

    //定义一个Map 用于存放我们要创建的对象 我们把它称为容器
    private static Map<String,Object> beans;

    //使用静态代码块为Properties对象赋值
    static {
        //实例化对象
        try {
            props=new Properties();
            InputStream is =BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            props.load(is);

            //实例化容器
            beans=new HashMap<String,Object>();

            //取出配置文件中所有的key
            Enumeration keys=props.keys();

            //遍历枚举
            while(keys.hasMoreElements()){
                //取出每一个key
                String key=keys.nextElement().toString();
                //根据key获取value
                String beanPath=props.getProperty(key);

                //反射创建对象
                Object value=Class.forName(beanPath).newInstance();
                //把key和value存入容器之中
                beans.put(key,value);
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化Properties失败");
        }
    }


    /**
     * 根据beaName获取单例对象
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName) {
        return beans.get(beanName);

    }

    /**
     * 根据Bean的名称 获取bean对象
     * @param beanName
     * @return
     */
    /*public static Object getBean(String beanName) {
        Object bean=null;
        try {
            String beanPath = props.getProperty(beanName);
//            System.out.println(beanPath);
            bean = Class.forName(beanPath).newInstance();//每次都会调用默认构造函数创建对象
        } catch (Exception e) {
            e.printStackTrace();

        }
        return bean;

    }*/

}
