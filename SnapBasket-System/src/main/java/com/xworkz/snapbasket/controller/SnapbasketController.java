package com.xworkz.snapbasket.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    @PostMapping("saveData")
    public String getData(String userName , String email , String phoneNumber , Model model){
        System.out.println("User Name :"+userName+" email :"+email+" phoneNumber :"+phoneNumber);
        model.addAttribute("name",userName);
        model.addAttribute("email",email);
        model.addAttribute("phoneNumber",phoneNumber);
        return "success.jsp";
    }
    @PostMapping("Register")
    public String getInfo(String userName , String email , String phoneNumber, String address , String dob , String gender , String qualification , int experience, String skills , String hobbies , Model model){
        System.out.println("User Name :"+userName+" email :"+email+" phoneNumber :"+phoneNumber+" address :"+address);
        model.addAttribute("name",userName);
        model.addAttribute("email",email);
        model.addAttribute("phoneNumber",phoneNumber);
        model.addAttribute("address",address);
        model.addAttribute("dob", dob);
        model.addAttribute("gender",gender);
        model.addAttribute("qualification",qualification);
        model.addAttribute("experience",experience);
        model.addAttribute("skills",skills);
        model.addAttribute("hobbies",hobbies);
        return "success.jsp";

    }
    @PostMapping("SignIn")
    public String getIn(String userName , String email , String password , Model model){
        System.out.println("User Name :"+userName+" email :"+email+" password :"+password);
        model.addAttribute("name",userName);
        model.addAttribute("email",email);
        model.addAttribute("password",password);
        return "logoutput.jsp";
    }
    @PostMapping("about")
    public String getAbout(String userName , String email , String phoneNumber, String address , String dob , String gender , String qualification , int experience, String skills , String hobbies , Model model){
        System.out.println("User Name :"+userName+" email :"+email+" phoneNumber :"+phoneNumber+" address :"+address);
        model.addAttribute("name",userName);
        model.addAttribute("email",email);
        model.addAttribute("phoneNumber",phoneNumber);
        model.addAttribute("address",address);
        model.addAttribute("dob", dob);
        model.addAttribute("gender",gender);
        model.addAttribute("qualification",qualification);
        model.addAttribute("experience",experience);
        model.addAttribute("skills",skills);
        model.addAttribute("hobbies",hobbies);
        return "success.jsp";

    }
    @PostMapping("admin")
    public String getAdmin(String userName , String email , String phoneNumber, String address , String dob , String gender , String qualification , int experience, String skills , String hobbies , Model model){
        System.out.println("User Name :"+userName+" email :"+email+" phoneNumber :"+phoneNumber+" address :"+address);
        model.addAttribute("name",userName);
        model.addAttribute("email",email);
        model.addAttribute("phoneNumber",phoneNumber);
        model.addAttribute("address",address);
        model.addAttribute("dob", dob);
        model.addAttribute("gender",gender);
        model.addAttribute("qualification",qualification);
        model.addAttribute("experience",experience);
        model.addAttribute("skills",skills);
        model.addAttribute("hobbies",hobbies);
        return "success.jsp";

    }
    @PostMapping("Approve")
    public String getApprove(String userName , String email , String phoneNumber, String address , String dob , String gender , String qualification , int experience, String skills , String hobbies , Model model){
        System.out.println("User Name :"+userName+" email :"+email+" phoneNumber :"+phoneNumber+" address :"+address);
        model.addAttribute("name",userName);
        model.addAttribute("email",email);
        model.addAttribute("phoneNumber",phoneNumber);
        model.addAttribute("address",address);
        model.addAttribute("dob", dob);
        model.addAttribute("gender",gender);
        model.addAttribute("qualification",qualification);
        model.addAttribute("experience",experience);
        model.addAttribute("skills",skills);
        model.addAttribute("hobbies",hobbies);
        return "success.jsp";

    }
    @PostMapping("Home")
    public String getHomeData(String userName , String email , String phoneNumber, String address , String dob , String gender , String qualification , int experience, String skills , String hobbies , Model model){
        System.out.println("User Name :"+userName+" email :"+email+" phoneNumber :"+phoneNumber+" address :"+address);
        model.addAttribute("name",userName);
        model.addAttribute("email",email);
        model.addAttribute("phoneNumber",phoneNumber);
        model.addAttribute("address",address);
        model.addAttribute("dob", dob);
        model.addAttribute("gender",gender);
        model.addAttribute("qualification",qualification);
        model.addAttribute("experience",experience);
        model.addAttribute("skills",skills);
        model.addAttribute("hobbies",hobbies);
        return "success.jsp";

    }
    @PostMapping("Manage")
    public String ManageData(String userName , String email , String phoneNumber, String address , String dob , String gender , String qualification , int experience, String skills , String hobbies , Model model){
        System.out.println("User Name :"+userName+" email :"+email+" phoneNumber :"+phoneNumber+" address :"+address);
        model.addAttribute("name",userName);
        model.addAttribute("email",email);
        model.addAttribute("phoneNumber",phoneNumber);
        model.addAttribute("address",address);
        model.addAttribute("dob", dob);
        model.addAttribute("gender",gender);
        model.addAttribute("qualification",qualification);
        model.addAttribute("experience",experience);
        model.addAttribute("skills",skills);
        model.addAttribute("hobbies",hobbies);
        return "success.jsp";

    }
    @PostMapping("Submit")
    public String submitData(String userName , String email , String phoneNumber, String address , String dob , String gender , String qualification , int experience, String skills , String hobbies , Model model){
        System.out.println("User Name :"+userName+" email :"+email+" phoneNumber :"+phoneNumber+" address :"+address);
        model.addAttribute("name",userName);
        model.addAttribute("email",email);
        model.addAttribute("phoneNumber",phoneNumber);
        model.addAttribute("address",address);
        model.addAttribute("dob", dob);
        model.addAttribute("gender",gender);
        model.addAttribute("qualification",qualification);
        model.addAttribute("experience",experience);
        model.addAttribute("skills",skills);
        model.addAttribute("hobbies",hobbies);
        return "success.jsp";

    }
    @PostMapping("View")
    public String viewData(String userName , String email , String phoneNumber, String address , String dob , String gender , String qualification , int experience, String skills , String hobbies , Model model){
        System.out.println("User Name :"+userName+" email :"+email+" phoneNumber :"+phoneNumber+" address :"+address);
        model.addAttribute("name",userName);
        model.addAttribute("email",email);
        model.addAttribute("phoneNumber",phoneNumber);
        model.addAttribute("address",address);
        model.addAttribute("dob", dob);
        model.addAttribute("gender",gender);
        model.addAttribute("qualification",qualification);
        model.addAttribute("experience",experience);
        model.addAttribute("skills",skills);
        model.addAttribute("hobbies",hobbies);
        return "success.jsp";

    }


}
