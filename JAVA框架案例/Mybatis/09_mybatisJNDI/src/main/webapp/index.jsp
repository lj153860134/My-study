<%@ page import="org.apache.ibatis.io.Resources" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactoryBuilder" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>
<%@ page import="com.lingjian_1.dao.IUserDao" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="java.util.List" %>
<%@ page import="com.lingjian_1.domain.User" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<body>
<h2>Hello World!</h2>
<%
    //读取配置文件(两种方式)
    InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
//        InputStream is=MybatisTest.class.getClassLoader().getResourceAsStream("SqlMapConfig.xml");
    //创建SqlSessionFactory工厂
    SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
    SqlSessionFactory factory = builder.build(is);
    //使用工厂生产SqlSession对象
    SqlSession sqlSession = factory.openSession();
    //使用SqlSession创建Dao接口的代理对象
    IUserDao userDao = sqlSession.getMapper(IUserDao.class);
    List<User> users=userDao.findAll();
    for (User user : users) {
        System.out.println(user);

    }
    //释放资源
    sqlSession.close();
    is.close();
%>
</body>
</html>
