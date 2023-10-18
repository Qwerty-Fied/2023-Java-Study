<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>로그인 화면</title>
</head>
<body>
    <h2>로그인 화면</h2>
    <% 
if(session.getAttribute("username") != null) { 
    %>
        <p>환영합니다. <%= session.getAttribute("username") %>님! 현재 로그인 중입니다.</p>
        <form action="logout.jsp" method="post">
            <input type="submit" value="로그아웃">
        </form>
    <%
        } else { 
    %>
        <form action="loginProcess.jsp" method="post">
            <label for="username">아이디 : </label>
            <input type="text" name="username"><br>
            <label for="password">비밀번호 : </label>
            <input type="password" name="password"><br>
            <input type="submit" value="로그인 하기">
        </form>
    <%
        } 
    %>
</body>
</html>
