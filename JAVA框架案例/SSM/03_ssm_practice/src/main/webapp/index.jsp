<%--
  Created by IntelliJ IDEA.
  User: lingjian
  Date: 2020/5/25
  Time: 9:32 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<a href="/account/findAllAccount">测试springMVC</a>

<form action="/account/save" method="post">
    姓名:<input type="text" name="name"/> <br/>
    金额:<input type="text" name="money"/> <br/>
        <input type="submit" value="保存"/> <br/>
</form>

</body>
</html>
