package com.digi.model;

import lombok.Data;

@Data
public class User {

    private int id;
    private String name;
    private String surname;
    private int age;
    private String email;
    private String password;
    private String verify;
}
