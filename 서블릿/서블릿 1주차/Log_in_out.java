/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author PARK
 */
@WebServlet(urlPatterns = {"/logProc"})
public class Log_in_out extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { {
            resp.setContentType("text/html;charset=UTF-8");
            PrintWriter out = resp.getWriter();
            String id = req.getParameter("id");
            String password = req.getParameter("password");

            if (id.isEmpty() || password.isEmpty()) {
                out.print("ID 또는 비밀번호를 정확히 입력해주세요");
                return;
            }

            HttpSession session = req.getSession();

            if (session.isNew() || session.getAttribute("id") == null) {
                session.setAttribute("id", id);
                if (session.isNew()) {
                    out.print("Session 생성 후, 로그인 완료");
                } else
                    out.print("로그인을 완료하였습니다.");
            } else {
                out.println("현재 로그인 상태입니다.");
            }
    }

    // ... (rest of the code)

}
 
    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession(false);
        if(session != null && session.getAttribute("id") != null) {
            session.invalidate();
            out.println("로그아웃 완료");
        } else  {
            out.println("현재 로그인 상태가 아닙니다.");
        }
        out.close();
    }
}
