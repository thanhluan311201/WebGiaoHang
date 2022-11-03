/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.controllers;


import com.btl.pojos.User;
import com.btl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Admin
 */
@Controller
public class ShipperController {
    @Autowired
    private UserService userDetailsService;
    
    @RequestMapping("/shipperInfo/{id}")
    public String shipperInfo_ct(Model model, @PathVariable("id") int id){
        model.addAttribute("user", this.userDetailsService.getUserById(id));
    
        return "shipperInfo_ct";
    }
    
    @RequestMapping("/shipperInfo")
    public String shipperInfo(Model model, String userRole){
        model.addAttribute("User", this.userDetailsService.getUserByUserRole(userRole));
        
        return "shipperInfo";
    }
    
//    @GetMapping("/admin/shipperRegister")
//    public String shipperRegisterView(Model model){
//        model.addAttribute("shipper", new User());
//        return "shipperRegister";
//    }
//    
//    @PostMapping("/admin/shipperRegister")
//    public String shipperRegister(Model model, @ModelAttribute(value = "shipper") User shipper){
//        String errMsg = "";
//        if (shipper.getPassword().equals(shipper.getConfirmPassword())){
//            if (this.userDetailsService.addShipper(shipper) == true)
//               return "redirect:/";
//            
//            else
//                errMsg ="Loi";
//        } else
//            errMsg = "Mat khau khong khop";
//        model.addAttribute("errMsg", errMsg);
//        
//        return "shipperRegister";
//    }
}
