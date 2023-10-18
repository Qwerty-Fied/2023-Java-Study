<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>

<%
    // Invalidate the session to log out the user
    session.invalidate();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>로그아웃</title>
</head>
<body>
    <h2>로그아웃</h2>
    <p>성공적으로 로그아웃 되었습니다.</p>
    <a href="login.jsp">로그인 페이지로 돌아가기</a>
</body>
</html>
