package com.xworkz.commonmodule.restcontroller;


import com.xworkz.commonmodule.service.CommonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/common/")
public class CommonRestController {
    @Autowired
    CommonService service;
    @GetMapping("checkMobileNumber/{phoneNumber}")
    public String checkPhoneNumber(@PathVariable Long phoneNumber){
        log.info("Invoking phoneNumber{}", phoneNumber);
        return service.valiadteRegisterByPhoneNumber(phoneNumber) ;
    }

}
