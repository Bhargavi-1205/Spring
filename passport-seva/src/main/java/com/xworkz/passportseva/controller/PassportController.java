package com.xworkz.passportseva.controller;

import com.xworkz.passportseva.dto.PassportDto;
import com.xworkz.passportseva.service.PassportService;
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
public class PassportController {
@Autowired
    PassportService service;
@PostMapping("/save")
  public String saveMethod(PassportDto dto){
    service.saveDto(dto);
      System.out.println("passportseva details : "+dto);
      return "somepage.jsp";

  }
  @GetMapping("/getAllPassportApplication")
  public String readMethod(Model model){
 List<PassportDto> dto =service.getAll();
    model.addAttribute("listOfDto",dto);
    System.out.println("invoking controller"+service.getAll());
    System.out.println("invoking read method ");
  return "allpage.jsp";
  }
  @GetMapping("/getNameById")
      public String getNameById(@RequestParam("id")String id,Model model){
      PassportDto passportDto = service.getNameById(Integer.parseInt(id));
      model.addAttribute("item",passportDto);
      System.out.println("Controller: "+passportDto);
      return "viewPassport.jsp";
      }
    @GetMapping("updateById")
   public String updateById(@RequestParam("id")String id, Model model){
    PassportDto passportDto = service.getNameById(Integer.parseInt(id));
    model.addAttribute("item",passportDto);
       System.out.println("Update:"+passportDto);
       return "update.jsp";

   }
   @PostMapping("updating")
    public String update(PassportDto dto){
    service.updateById(dto);
    return "somepage.jsp";
   }
   @GetMapping("delete")
    public String delete(@RequestParam("id")String id,Model model){
    service.deleteById(Integer.parseInt(id));
    return "somepage.jsp";
   }
}
