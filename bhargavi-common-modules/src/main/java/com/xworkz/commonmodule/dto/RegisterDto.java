package com.xworkz.commonmodule.dto;


import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Data
@Component
public class RegisterDto {

    private Integer registerId;
    private String userName;
    private Long phoneNumber;
    private String email;
    private String password;
    private String confirmPassword;
    private String imageName;
    MultipartFile file;
}

