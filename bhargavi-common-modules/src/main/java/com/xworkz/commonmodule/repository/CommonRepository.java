package com.xworkz.commonmodule.repository;

import com.xworkz.commonmodule.entity.RegisterEntity;

public interface CommonRepository {

    boolean saveRegister(RegisterEntity entity);
    RegisterEntity getRegisterByEmail(String email);
    RegisterEntity getRegisterByPhoneNumber(Long mobileNumber);
    String updateByOtp(String email , String otp);
    RegisterEntity getRegisterById(Integer id);
    boolean updateRegister(RegisterEntity entity);


}
