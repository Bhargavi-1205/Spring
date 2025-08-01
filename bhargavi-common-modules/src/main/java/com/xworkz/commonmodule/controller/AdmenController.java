package com.xworkz.commonmodule.controller;


import com.xworkz.commonmodule.dto.RegisterDto;
import com.xworkz.commonmodule.service.CommonService;
import com.xworkz.commonmodule.util.CommonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Slf4j
@Controller
@RequestMapping("/")
public class AdmenController {
    @Autowired
    CommonService service;

    @GetMapping("homeToAdmin")
    public String homeToAdmin() {
        log.info("homeToAdmin");
        return "admin";
    }

    @PostMapping("generateOtp")
    public String email(@RequestParam("email") String email, Model model) {
        log.info("Invoking email :{}", email);
        service.generateOtp(email);
        model.addAttribute("email", email);
        return "otp";
    }

    @PostMapping("validateOtp")
    public String validateOtp(@RequestParam("email") String email, @RequestParam("otp") String otp, Model model) {
        log.info("Validating OTP for email: {}", email);
        boolean isValid = service.validateOTP(email, otp);
        if (isValid) {
            RegisterDto registerDto = service.getRegisterByEmailId(email);
            log.info("registerDto :{}", registerDto);
            model.addAttribute("register", registerDto);
            return "profile";
        } else {
            model.addAttribute("error", "Invalid Otp, Please try again");
            model.addAttribute("email", email);
            return "otp";
        }
    }

    @GetMapping("updatePage")
    public String redirectToUpdate(@RequestParam("id") String id, Model model) {//Reads the id parameter.
        log.info("updatePage :{}", id);
        RegisterDto registerDto = service.getRegisterById(Integer.valueOf(id));//Gets user data by ID from service.
        model.addAttribute("register", registerDto);
        return "update";   //Returns update view for editing.
    }

    @PostMapping("update")
    public String updateProfile(RegisterDto dto, Model model) {   //Receives the form data bound to a RegisterDto object
        log.info("updateProfile :" ,dto);
        boolean isUpdated = service.updateRegisterById(dto); //Calls service to update user by ID.
        if (isUpdated) {
            RegisterDto registerDto = service.getRegisterById(dto.getRegisterId());//Fetches updated record.
            log.info("registerDto :{}", registerDto);
            model.addAttribute("register", registerDto);
         //   model.addAttribute("msg", "Updated Successfully");
            return "profile";
        } else {
            model.addAttribute("msg", "Update Failed");  //Shows success view with failure message
            return "success";
        }

    }

    @GetMapping("/display")
    public void displayUserImage(HttpServletResponse response, @RequestParam String imagepath) throws IOException {
        File file = new File(CommonUtil.UPLOADED_FOLDER + File.separator + imagepath);
        try (InputStream in = new BufferedInputStream(new FileInputStream(file));
             ServletOutputStream out = response.getOutputStream()) {
            IOUtils.copy(in, out);
            response.flushBuffer();
        } catch (FileNotFoundException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Image not found");
        }
    }
}




