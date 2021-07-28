<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: lingjian
  Date: 2020/2/22
  Time: 4:50 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<%--重用的注解--%>
<a href="/anno/testRequestParam?name=凌健">RequestParam</a>

<br>

<form action="/anno/testRequestBody" method="post">
    用户姓名:<input type="text" name="username"/><br/>
    用户年龄:<input type="text" name="age"/><br/>
    <input type="submit" value="提交"/>

</form>

<a href="/anno/testPathVariable/10">PathVariable</a>

<br>

<a href="/anno/testRequestHeader">RequestHeader</a>
<br>

<a href="/anno/testCookieValue">CookieValue</a>
<br>

<form action="/anno/testModelAttribute" method="post">
    用户姓名:<input type="text" name="name"/><br/>
    用户年龄:<input type="text" name="age"/><br/>
    <input type="submit" value="提交"/>

</form>
<br>

<a href="/anno/testSessionAttribute">SessionAttribute</a>
<br>

<a href="/anno/getSessionAttribute">SessionAttribute</a>
<br>

</body>
</html>
