<%@ page import="com.digi.repository.UserRepository" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 20.09.2022
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MyPage</title>
</head>
<%
    String email = request.getParameter("email");
    String info = UserRepository.getInfo(email);
    response.getWriter().write(info);
%>
<body>

</body>
</html>
