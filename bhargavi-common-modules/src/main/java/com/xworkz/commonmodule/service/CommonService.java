package com.xworkz.commonmodule.service;

import com.xworkz.commonmodule.dto.LoginDto;
import com.xworkz.commonmodule.dto.RegisterDto;

public interface CommonService {
    String saveRegisterDto(RegisterDto dto);
    boolean getRegisterByEmailId(LoginDto dto);
    RegisterDto getRegisterByEmailId(String email);
    String valiadteRegisterByPhoneNumber(Long mobile);
    String generateOtp(String email);
    boolean validateOTP(String email , String otp);
    RegisterDto getRegisterById(Integer id);
   boolean updateRegisterById(RegisterDto dto);
}
