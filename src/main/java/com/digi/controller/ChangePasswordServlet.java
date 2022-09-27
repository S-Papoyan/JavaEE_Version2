package com.digi.controller;

import com.digi.repository.UserRepository;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ChangePasswordServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("user");
        String old_password = request.getParameter("old_password");
        String new_password = request.getParameter("new_password");
        String confirm_password = request.getParameter("confirm_password");

        boolean isLogin = UserRepository.login(email, old_password);

        if (isLogin ) {
            if(confirm_password.equals(new_password)){
                UserRepository.forgetPassword(new_password, email);
                response.sendRedirect("/login.jsp");
            }else {
                response.getWriter().write("passwords dont match");
            }
        } else {
            response.getWriter().write("Wrong old password");
        }
    }
}
