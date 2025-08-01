package com.xworkz.commonmodule.controller;

import com.xworkz.commonmodule.dto.RegisterDto;
import com.xworkz.commonmodule.service.CommonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("register/")
public class RegisterController {
    @Autowired
   CommonService service;
    @PostMapping("saveRegistration")
    public String saveRegistration(RegisterDto dto, Model model){
        log.info("Invoking saveRegistration");
        log.info("Data fetching from front end :{}", dto);
        String message =service.saveRegisterDto(dto);
        model.addAttribute("msg",message);
        return "success";
    }
}
