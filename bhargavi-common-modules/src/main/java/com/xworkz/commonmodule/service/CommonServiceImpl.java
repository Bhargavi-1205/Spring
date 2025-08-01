package com.xworkz.commonmodule.service;

import com.xworkz.commonmodule.dto.LoginDto;
import com.xworkz.commonmodule.dto.RegisterDto;
import com.xworkz.commonmodule.entity.RegisterEntity;
import com.xworkz.commonmodule.repository.CommonRepository;
import com.xworkz.commonmodule.resources.OtpGenerate;
import com.xworkz.commonmodule.util.CommonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
@Service
@Transactional
public class CommonServiceImpl implements CommonService {
    @Autowired
    CommonRepository repository;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;
    @Autowired
    EmailSender emailSender;

    @Override
    public String saveRegisterDto(RegisterDto dto) {
        log.info("Invoking saveRegisterDto");
        String isCheck = null;
        if (dto != null) {
            RegisterEntity emailEntity = repository.getRegisterByEmail(dto.getEmail());
            if (emailEntity == null) {
                RegisterEntity registerEntity = new RegisterEntity();
                String encodePsw = passwordEncoder.encode(dto.getPassword());
                log.info("Encoded Password: {}", encodePsw);
                BeanUtils.copyProperties(dto, registerEntity);
                registerEntity.setPassword(encodePsw);
                boolean isSaved = repository.saveRegister(registerEntity);
                log.info("Print register Entity{}", registerEntity);
                if (isSaved) {
                    isCheck = "Registered";

                } else {
                    isCheck = "Not Registered";
                }
            } else {
                isCheck = "Email already Registered";
            }

        }
        return isCheck;
    }

    @Override
    public boolean getRegisterByEmailId(LoginDto dto) {
        log.info("Invoking getRegisterByEmailId ");
        boolean isLogin = false;
        if (dto != null) {
            RegisterEntity registerEntity = repository.getRegisterByEmail(dto.getEmail());
            if (registerEntity != null) {
                isLogin = passwordEncoder.matches(dto.getPassword(), registerEntity.getPassword());
            }
        }
        return isLogin;
    }

    @Override
    public RegisterDto getRegisterByEmailId(String email) {
        log.info("Invoking getRegisterByEmailId {}", email);
        RegisterDto dto = null;
        if (email != null && !email.isEmpty()) {
            RegisterEntity entity = repository.getRegisterByEmail(email);
            log.info("Entity From DB :{}", entity);

            if (entity != null) {
                dto = CommonUtil.convertEntityToDto(entity);
                log.info("Converted DTO: {}", dto);
            }
        }
        return dto;
    }

    @Override
    public String valiadteRegisterByPhoneNumber(Long mobile) {
        log.info("Invoking valiadteRegisterByPhoneNumber");
        String status = "Invalid mobile number"; ;
        if( mobile != 0l) {
            RegisterEntity entity = repository.getRegisterByPhoneNumber(mobile);
            status = (entity == null) ? "Phone number not exist" : "Phone number already exist";
        }
        return status;
    }

    @Override
    public String generateOtp(String email) {
       log.info("generating otp :");
        String newotp = OtpGenerate.generateOTP();
        log.info("newotp :{}", newotp);
        emailSender.mailSend(email, newotp);
        repository.updateByOtp(email, newotp);
        log.info("Updating otp{}", newotp);
        return "OTP generated and sent successfully";
    }

    @Override
    public boolean validateOTP(String email, String otp) {
        log.info("Validating OTP for email: {}", email);
        boolean isValid = false;

        if (email != null && otp != null) {
            RegisterEntity registerEntity = repository.getRegisterByEmail(email);

            if (registerEntity != null) {
                isValid = otp.equals(registerEntity.getOtp());
            }
        }
        return isValid;
    }

    @Override
    public RegisterDto getRegisterById(Integer id) {
        log.info("Getting register by ID: {}", id);
        RegisterDto registerDto = null;

        if (id != null) {
            RegisterEntity entity = repository.getRegisterById(id);
            if (entity != null) {
                registerDto = CommonUtil.convertEntityToDto(entity);
            }
        }
        return registerDto;
    }

    @Override
    public boolean updateRegisterById(RegisterDto dto) {
        log.info("Updating register with ID: {}", dto);
        boolean isUpdated = false;

        if(dto != null) {
            try {
                MultipartFile file = dto.getFile();
                if(file != null && !file.isEmpty()) {
                    byte[] bytes = file.getBytes();
                    Path path = Paths.get(CommonUtil.UPLOADED_FOLDER + file.getOriginalFilename());
                    Files.write(path, bytes);

                    log.info("File saved: {}", file.getOriginalFilename());
                }

                RegisterEntity entity = new RegisterEntity();
                BeanUtils.copyProperties(dto, entity);

                if(file != null) {
                    entity.setImageName(file.getOriginalFilename());
                }

                repository.updateRegister(entity);
                isUpdated = true;

            } catch (IOException e) {
                log.error("Error saving file: {}", e.getMessage());
                e.printStackTrace();
            }
        }
        return isUpdated;
    }


    }





