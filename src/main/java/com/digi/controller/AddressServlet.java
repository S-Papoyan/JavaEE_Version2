package com.digi.controller;

import com.digi.repository.AddressRepository;
import com.digi.repository.UserRepository;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class AddressServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String country = request.getParameter("country");
        String city = request.getParameter("city");
        String street = request.getParameter("street");
        String home = request.getParameter("home");
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        Integer user_id = UserRepository.getByEmail(user.toString());
        AddressRepository.saveAddress(country, city, street, home, user_id);
        response.sendRedirect("/login.jsp");

    }
}
