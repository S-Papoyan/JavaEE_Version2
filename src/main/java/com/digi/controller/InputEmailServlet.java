package com.digi.controller;

import com.digi.repository.UserRepository;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class InputEmailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = request.getParameter("email");

        Integer id = UserRepository.getByEmail(email);
        if (id != null) {
            session.setAttribute("email", email);
            request.getRequestDispatcher("/forgetPassword.jsp").forward(request, response);
        } else {
            response.getWriter().println("Wrong email!");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String email = (String) session.getAttribute("email");
        String new_password = req.getParameter("new_password");
        String confirm_password = req.getParameter("confirm_password");
        if (confirm_password.equals(new_password)) {
            UserRepository.forgetPassword(new_password, email);
            resp.sendRedirect("/homePage.jsp");
        } else {
            resp.getWriter().write("doesn't match");
        }
    }
}
