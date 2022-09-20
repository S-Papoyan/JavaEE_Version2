package com.digi.controller;

import com.digi.repository.UserRepository;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        boolean login = UserRepository.login(email, password);

        if (login) {
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } else {
            response.getWriter().println("Wrong email or password");
        }
    }
}
