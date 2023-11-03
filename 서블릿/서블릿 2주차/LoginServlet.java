/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("id"); //signUP에서 ID 가져옴
        String password = request.getParameter("pd"); //signUP에서 비밀번호 가져옴
        String receivedID = request.getParameter("id");
        String receivedPWD = request.getParameter("pd");
        if (receivedID.equals(username) && receivedPWD.equals(password)) { //조건문
            response.sendRedirect("login-success.jsp");
        } else {
            response.sendRedirect("login-failure.jsp");
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("id"); //signUP에서 ID 가져옴
        String password = request.getParameter("pd"); //signUP에서 비밀번호 가져옴
        String receivedID = request.getParameter("id");
        String receivedPWD = request.getParameter("pd");
        if (receivedID.equals(username) && receivedPWD.equals(password)) { //조건문
            response.sendRedirect("login-success.jsp");
        } else {
            response.sendRedirect("login-failure.jsp");
        }
    }
}

