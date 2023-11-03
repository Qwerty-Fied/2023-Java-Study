<%-- 
    Document   : index.jsp
    Created on : 2023. 11. 3., 오후 8:43:55
    Author     : PARK
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kr">
<head>
    <meta charset="UTF-8">
    <title>회원가입</title>
</head>
<body>
    <h2>회원가입</h2>
    <form action="SignUpServlet" method="post">
        아이디: <input type="text" name="username" required><br>
        비밀번호: <input type="password" name="password" required><br>
        이메일: <input type="email" name="email" required><br>
        <input type="submit" value="가입하기">
    </form>
</body>
</html>
