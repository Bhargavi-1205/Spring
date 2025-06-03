package com.xworkz.snapbasket.controller;


import com.xworkz.snapbasket.dto.SnapbasketDto;
import com.xworkz.snapbasket.service.SnapbasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
public class SnapbasketController {

    @Autowired
    SnapbasketService service;

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
        return "home";
    }
    @GetMapping("redirectToLogin")
    public String getLoginPage(){
        return "login";
    }
    @GetMapping("redirectToAbout")
    public String getAboutPage(){
        return "about";
    }
    @GetMapping("redirectToContact")
    public String getContactPage(){
        return "contact";
    }
    @GetMapping("redirectToManage")
    public String getManagePage(){
        return "manage";
    }
    @GetMapping("redirectToApprovePage")
    public String getApprovePage(){
        return "approve";
    }
    @GetMapping("redirectToAdminPage")
    public String getAdminPage(){
        return "admin";
    }
    @GetMapping("redirectToSubmitPage")
    public String getSubmitPage(){
        return "submit";
    }

    @GetMapping("/getAll")
    public String readMethod(Model model){
        List<SnapbasketDto> dto =service.getAll();
        model.addAttribute("listOfDto",dto);
        System.out.println("invoking controller"+service.getAll());
        System.out.println("invoking read method ");
        return "allpage";
    }
    @GetMapping("/getNameById")
    public String getNameById(@RequestParam("id")String id, Model model){
        SnapbasketDto snapbasketDto = service.getNameById(Integer.parseInt(id));
        model.addAttribute("item",snapbasketDto);
        System.out.println("Controller: "+snapbasketDto);
        return "view";
    }
    @GetMapping("updateById")
    public String updateById(@RequestParam("id")String id, Model model){
        SnapbasketDto snapbasketDto = service.getNameById(Integer.parseInt(id));
        model.addAttribute("item",snapbasketDto);
        System.out.println("Update:"+snapbasketDto);
        return "update";

    }
    @PostMapping("saveData")
    public String getData(SnapbasketDto dto, Model model){
        System.out.println("UserName :"+dto.getUserName()+"email :"+dto.getEmail()+"phoneNumber :"+dto.getPhoneNumber());
       String message = service.saveData(dto);
      model.addAttribute("msg",message);
        model.addAttribute("name",dto.getUserName());
        model.addAttribute("email",dto.getEmail());
        model.addAttribute("phoneNumber",dto.getPhoneNumber());
        return "success";
    }
    @PostMapping("Register")
    public String getInfo(SnapbasketDto dto , Model model){
        System.out.println("UserName :"+dto.getUserName()+"email :"+dto.getEmail()+"phoneNumber :"+dto.getPhoneNumber());
        model.addAttribute("name",dto.getUserName());
        model.addAttribute("email",dto.getEmail());
        model.addAttribute("phoneNumber",dto.getPhoneNumber());
        return "successContact";

    }
    @PostMapping("SignIn")
    public String getIn(SnapbasketDto dto, Model model){
        System.out.println("UserName :"+dto.getUserName()+"email :"+dto.getEmail()+"phoneNumber :"+dto.getPhoneNumber());
        String message = service.saveData(dto);
        model.addAttribute("msg",message);
        return "logoutput";
    }
    @PostMapping("about")
    public String getAbout(SnapbasketDto dto, Model model){
        System.out.println("UserName :"+dto.getUserName()+"email :"+dto.getEmail()+"phoneNumber :"+dto.getPhoneNumber());
        String message = service.saveData(dto);
        model.addAttribute("msg",message);
        return "successAbout";
    }
    @PostMapping("admin")
    public String getAdmin( SnapbasketDto dto , Model model){
        System.out.println("UserName :"+dto.getUserName()+"email :"+dto.getEmail()+"phoneNumber :"+dto.getPhoneNumber());
        String message = service.saveData(dto);
        model.addAttribute("msg",message);
        return "successAdmin";
    }
    @PostMapping("Approve")
    public String getApprove(SnapbasketDto dto , Model model){
        System.out.println("UserName :"+dto.getUserName()+"email :"+dto.getEmail()+"phoneNumber :"+dto.getPhoneNumber());
        String message = service.saveData(dto);
        model.addAttribute("msg",message);
        return "successApprove";
    }
    @PostMapping("Home")
    public String getHomeData( SnapbasketDto dto , Model model){
        System.out.println("UserName :"+dto.getUserName()+"email :"+dto.getEmail()+"phoneNumber :"+dto.getPhoneNumber());
        String message = service.saveData(dto);
        model.addAttribute("msg",message);
        return "successHome";
    }
    @PostMapping("Manage")
    public String ManageData(SnapbasketDto dto , Model model){
        System.out.println("UserName :"+dto.getUserName()+"email :"+dto.getEmail()+"phoneNumber :"+dto.getPhoneNumber());
        String message = service.saveData(dto);
        model.addAttribute("msg",message);
        return "successmanage";
    }
    @PostMapping("Submit")
    public String submitData(SnapbasketDto dto , Model model){
        System.out.println("UserName :"+dto.getUserName()+"email :"+dto.getEmail()+"phoneNumber :"+dto.getPhoneNumber());
        String message = service.saveData(dto);
        model.addAttribute("msg",message);
        return "successSubmit";
    }
    @PostMapping("View")
    public String viewData( SnapbasketDto dto, Model model){
        System.out.println("UserName :"+dto.getUserName()+"email :"+dto.getEmail()+"phoneNumber :"+dto.getPhoneNumber());
        String message = service.saveData(dto);
        model.addAttribute("msg",message);
        return "successView";
    }


}
