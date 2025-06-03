package com.xworkz.snapbasket.dto;


import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class SnapbasketDto {


    private  int id;
    private  String userName;
    private String email;
    private long phoneNumber;
}
