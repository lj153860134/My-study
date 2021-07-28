<%--
  Created by IntelliJ IDEA.
  User: lingjian
  Date: 2020/2/22
  Time: 11:16 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--请求参数绑定--%>
<%--<a href="/param/testParam?username=lingjian">请求参数绑定</a>--%>

<%--把数据封装到Account类中--%>
<%--<form action="/param/saveAccount" method="post">
    姓名:<input type="text" name="username"/><br/>
    密码:<input type="text" name="password"/><br/>
    金额:<input type="text" name="money"/><br/>
    用户姓名:<input type="text" name="user.name"/><br/>
    用户年龄:<input type="text" name="user.age"/><br/>
    <input type="submit" value="提交"/>

</form>--%>

<%--把数据封装到Account类中 类中存在list和map的集合--%>
<%--<form action="/param/saveAccount" method="post">
    姓名:<input type="text" name="username"/><br/>
    密码:<input type="text" name="password"/><br/>
    金额:<input type="text" name="money"/><br/>
    用户姓名1:<input type="text" name="list[0].name"/><br/>
    用户年龄1:<input type="text" name="list[0].age"/><br/>

    用户姓名2:<input type="text" name="map['one'].name"/><br/>
    用户年龄2:<input type="text" name="map['one'].age"/><br/>
    <input type="submit" value="提交"/>--%>


<%--自定义类型转换器--%>
<%--<form action="/param/saveUser" method="post">
    用户姓名:<input type="text" name="name"/><br/>
    用户年龄:<input type="text" name="age"/><br/>
    用户生日:<input type="text" name="date"/><br/>

    <input type="submit" value="提交"/>--%>

<a href="/param/testServlet">Servlet原生的API</a>




</form>


</body>
</html>
