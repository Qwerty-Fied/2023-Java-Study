<%-- 
    Document   : login.jsp
    Created on : 2023. 11. 3., 오후 9:56:57
    Author     : PARK
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>로그인 화면</title>
    </head>
    <body>
        <h2>로그인</h2>
    <form action="LoginServlet" method="post">
        아이디: <input type="text" name="id" required><br>
        비밀번호: <input type="password" name="pd" required><br>
        <input type="submit" value="로그인 하기">
    </form>
    <input type="button" onclick="location.href='index.jsp'" value="회원가입 하기">
    </body>
</html>
