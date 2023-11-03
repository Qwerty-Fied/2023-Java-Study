/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        
        String sendData =  "LoginServlet?id=" + URLEncoder.encode(username, "UTF-8") + 
                "&pd=" + URLEncoder.encode(password, "UTF-8");
        
        System.out.println("회원가입 정보 확인 - 아이디: " + username + ", 비밀번호: " + password + ", 이메일: " + email);
        
        response.sendRedirect(sendData);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        
        String sendData =  "LoginServlet?id=" + URLEncoder.encode(username, "UTF-8") + 
                "&pd=" + URLEncoder.encode(password, "UTF-8");
        
        System.out.println("회원가입 정보 확인 - 아이디: " + username + ", 비밀번호: " + password + ", 이메일: " + email);
        
        response.sendRedirect(sendData);
    }
}
