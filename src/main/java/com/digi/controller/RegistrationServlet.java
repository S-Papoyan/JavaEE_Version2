package com.digi.controller;

import com.digi.repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String age = request.getParameter("age");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        UserRepository userRepository = new UserRepository();
        userRepository.insert(name, surname, Integer.parseInt(age), email, password);
//        response.sendRedirect("/homePage.jsp");
        request.getRequestDispatcher("/verification.jsp").forward(request, response);

    }
}
