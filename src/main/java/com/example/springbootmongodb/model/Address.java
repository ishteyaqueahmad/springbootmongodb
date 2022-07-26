package com.example.springbootmongodb.model;

import lombok.Data;

@Data
public class Address {
    private String country;
    private String postcode;
    private String city;
}
