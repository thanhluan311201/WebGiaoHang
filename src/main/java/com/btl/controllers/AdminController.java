/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.controllers;

import com.btl.pojos.User;
import com.btl.service.DonhangService;
import com.btl.service.StatsService;
import com.btl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Admin
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService userDetailsService;
    @Autowired
    private DonhangService donhangService;
    @Autowired
    private StatsService statsService;
    
    @GetMapping("/donhang_stats")
    public String donhangStats(Model model){
        model.addAttribute("donhangStats", this.statsService.donhangStats());
        
        return "donhang_stats";
    }
    
    @GetMapping("/baiviet_stats")
    public String baivietStats(Model model){
        model.addAttribute("baivietStats", this.statsService.baivietStats());
        
        return "baiviet_stats";
    }
    
    @GetMapping("/shipperRegister")
    public String shipperRegisterView(Model model){
        model.addAttribute("shipper", new User());
        return "shipperRegister";
    }
    
    @PostMapping("/shipperRegister")
    public String shipperRegister(Model model, @ModelAttribute(value = "shipper") User shipper){
        String errMsg = "";
        if (shipper.getPassword().equals(shipper.getConfirmPassword())){
            if (this.userDetailsService.addShipper(shipper) == true)
               return "redirect:/";
            
            else
                errMsg ="Loi";
        } else
            errMsg = "Mat khau khong khop";
        model.addAttribute("errMsg", errMsg);
        
        return "shipperRegister";
    }
    @RequestMapping("/donhang")
    public String donhang(Model model){
        model.addAttribute("donhang", this.donhangService.getDonhang());
        
        return "donhang";
    }
}
