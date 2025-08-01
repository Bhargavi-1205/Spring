package com.xworkz.passportseva.dto;

import lombok.Data;
import org.springframework.stereotype.Component;
@Data
@Component
public class PassportDto {

    private  int id;

    private String passportOffice;

    private String  givenName;

    private String surName;

    private String dob;

    private String email;

    private String loginId;

    private String password;

    private String confirmPassword;

    private String hintQuestion;

    private String hintAnswer;
}
