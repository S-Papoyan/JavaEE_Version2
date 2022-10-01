package com.digi.service;

import com.digi.model.User;
import com.digi.repository.jpaRepository.UserJPARepository;

import java.util.List;

public class UserService {
    public static void main(String[] args) {

        UserJPARepository userJPARepository = new UserJPARepository();

        List<User> all = userJPARepository.getAll();
        System.out.println(all);


    }
}
