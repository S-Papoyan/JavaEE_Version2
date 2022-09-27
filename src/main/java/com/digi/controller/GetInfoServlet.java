package com.digi.controller;

import com.digi.model.Address;
import com.digi.model.User;
import com.digi.repository.AddressRepository;
import com.digi.repository.UserRepository;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class GetInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("user");

        User user = UserRepository.getUser(email);
        List<Address> address = AddressRepository.getAddress(user.getId());



    }


}
