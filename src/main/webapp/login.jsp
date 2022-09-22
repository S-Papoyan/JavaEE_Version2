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
    HttpSession session1 = request.getSession();
    Object user = session1.getAttribute("user");
    String info = UserRepository.getInfo(user.toString());
    response.getWriter().write(info);
%>
<body>
<br><br>
<a href="address.jsp">add_address</a>
</body>
</html>
