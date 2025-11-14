package com.sparta.utils;

public record SignupForm(
        String title,
        String password,
        String day,
        String month,
        String year,
        String firstName,
        String lastName,
        String company,
        String address,
        String address2,
        String country,
        String state,
        String city,
        String zipcode,
        String mobileNumber
) {}