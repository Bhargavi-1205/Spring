package com.xworkz.commonmodule.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home/")
public class CommonController {


    @GetMapping("redirectToRegister")
    public String getRegisterPage(){
        return "register";
    }


    @GetMapping("redirectToView")
    public String getViewPage(){
        return "view";
    }


    @GetMapping("redirectToHome")
    public String getHomePage(){
        return "index";
    }

    @PostMapping("redirectToSubmitPage")
    public String getSubmitPage(){
        return "submit";
    }



}
