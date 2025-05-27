package com.xworkz.snapbasket.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class SnapbasketController {

    @GetMapping("redirectToRegister")
    public String getRegisterPage(){
        return "register.jsp";
    }
    @GetMapping("redirectToView")
    public String getViewPage(){
        return "view.jsp";
    }
    @GetMapping("redirectToHome")
    public String getHomePage(){
        return "home.jsp";
    }
    @GetMapping("redirectToLogin")
    public String getLoginPage(){
        return "login.jsp";
    }
    @GetMapping("redirectToAbout")
    public String getAboutPage(){
        return "about.jsp";
    }
    @GetMapping("redirectToContact")
    public String getContactPage(){
        return "contact.jsp";
    }
    @GetMapping("redirectToManage")
    public String getManagePage(){
        return "manage.jsp";
    }
    @GetMapping("redirectToApprovePage")
    public String getApprovePage(){
        return "approve.jsp";
    }
    @GetMapping("redirectToAdminPage")
    public String getAdminPage(){
        return "admin.jsp";
    }
    @GetMapping("redirectToSubmitPage")
    public String getSubmitPage(){
        return "submit.jsp";
    }
}
