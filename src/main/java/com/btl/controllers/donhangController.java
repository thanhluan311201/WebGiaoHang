/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.controllers;

import com.btl.pojos.Donhang;
import com.btl.pojos.User;
import com.btl.service.DonhangService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Admin
 */
@Controller
public class donhangController {
    
    @Autowired
    private DonhangService donhangService;
    
    @RequestMapping("/donhangs/{id}")
    public String donhang(Model model, @PathVariable("id") int id){
        model.addAttribute("donhang", this.donhangService.getDonhangByShipper(id));
        
        
        return "donhang";
    }
    @RequestMapping("/donhangu/{id}")
    public String donhangu(Model model, @PathVariable("id") int id){
        model.addAttribute("donhang", this.donhangService.getDonhangByUser(id));
        
        
        return "donhang";
    }
    @RequestMapping("/updatedh/{id}")
    public String updatedh(Model model, @PathVariable("id") int id){

        Donhang d = this.donhangService.getDonhangById(id);
        if(this.donhangService.updateDonHang(d) == true)
            return "index";
        
        return "donhang";
    }
}
