package com.digi.model;

import lombok.Data;

@Data
public class Address {

    private int address_id;
    private String country;
    private String city;
    private String street;
    private String home;
    private String user_id;
}
