package com.xworkz.passportseva.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;


@Table(name = "passport_info")
@Entity
@Data
@NamedQuery(name = "getAll", query = "select p from PassportEntity p")
@NamedQuery(name="findNameById", query = "select p from PassportEntity p where p.id=:id")
@NamedQuery(name = "updateById" , query = "select p from PassportEntity p where p.id=:id")
@NamedQuery(name = "deleteById", query = "Delete from PassportEntity p where p.id=:id")
@Component
public class PassportEntity {
    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "passport_office")
    private String passportOffice;

    @Column(name="given_Name")
    private String  givenName;

    @Column(name="sur_Name")
    private String surName;

    @Column(name = "dob")
    private String dob;

    @Column(name = "email")
    private String email;

    @Column(name = "login_id")
    private String loginId;

    @Column(name = "password")
    private String password;

    @Column(name ="confirm_password")
    private String confirmPassword;

    @Column(name = "hint_ques")
    private String hintQuestion;

    @Column(name = "hint_ans")
    private String hintAnswer;

}
