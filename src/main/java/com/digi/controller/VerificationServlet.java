package com.digi.controller;

import com.digi.repository.UserRepository;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class VerificationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String verify = request.getParameter("verify");
        boolean check = UserRepository.checkVerify(email, verify);

        if (check) {
            request.getRequestDispatcher("/homePage.jsp").forward(request, response);
        }else {
            request.getRequestDispatcher("/verification.jsp").forward(request, response);
        }
    }
}
