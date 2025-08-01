package com.xworkz.commonmodule.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "register_info")
@NamedQueries({
        @NamedQuery(name = "checkEmail", query = "Select r from RegisterEntity r where r.email=:email"),
        @NamedQuery(name = "ValidateRegisterByPhoneNumber", query = "select r from RegisterEntity r where r.phoneNumber=:mobileNumber"),
        @NamedQuery(name = "UpdateByOtp", query="update RegisterEntity r set r.otp = :newotp where r.email= :email "),
        @NamedQuery(name = "updateRegisterByImageName",query="Update RegisterEntity r " +
                "set r.userName=:userName,r.phoneNumber=:phoneNumber, r.imageName=:imageName  where r.registerId=:registerId ")


})


@Component
@Data
public class RegisterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "register_id")
    private Integer registerId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "phone_number")
    private Long phoneNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "psw")
    private String password;
    @Column(name ="confirm_psw")
    private String confirmPassword;
    @Column(name="otp")
    private String otp;
    private String imageName;
}
