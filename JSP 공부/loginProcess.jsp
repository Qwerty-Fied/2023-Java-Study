<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>

<%
    Map<String, String> userDatabase = new HashMap<>();
    userDatabase.put("park", "1234");
    userDatabase.put("kim", "5678");
    
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    if (userDatabase.containsKey(username) && userDatabase.get(username).equals(password)) {
        // 아이디는 키, 비밀번호는 value 값으로 찾음
        session.setAttribute("username", username);
        response.sendRedirect("login.jsp"); // Redirect to the login page
    } else {
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>로그인 오류</title>
</head>
<body>
    <h2>로그인 실패</h2>
    <a href="login.jsp">로그인 페이지로 돌아가기</a>
</body>
</html>
<%
    }
%>
