package com.xworkz.commonmodule.util;

import com.xworkz.commonmodule.dto.RegisterDto;
import com.xworkz.commonmodule.entity.RegisterEntity;
import org.springframework.beans.BeanUtils;

public class CommonUtil {

    public static String UPLOADED_FOLDER = "C://Users//BHARGAVI N//OneDrive//Pictures//Screenshots";

    public static RegisterEntity convertDtoToEntity(RegisterDto registerDto){
        RegisterEntity registerEntity = new RegisterEntity();
        BeanUtils.copyProperties(registerDto,registerEntity);
        return registerEntity;

    }
    public static RegisterDto convertEntityToDto(RegisterEntity entity){
        RegisterDto registerDto = new RegisterDto();
        BeanUtils.copyProperties(entity,registerDto);
        return registerDto;
    }
}
