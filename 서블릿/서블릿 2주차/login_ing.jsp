<%-- 
    Document   : login_ing
    Created on : 2023. 11. 3., 오후 9:54:54
    Author     : PARK
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>로그인 중입니다.</title>
    </head>
    <body>
        <h1><%=session.getAttribute("username")%>로그인 중입니다.</h1> //여기를 해결을 못하겠습니다
        <a href="login.jsp">로그아웃 하기</a>
    </body>
</html>
