/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.controllers;


import com.btl.service.BaivietService;
import com.btl.service.UserService;
import com.btl.pojos.Baiviet;
import com.btl.pojos.Donhang;
import com.btl.pojos.User;
import com.btl.service.DonhangService;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



/**
 *
 * @author Admin
 */
@Controller
public class baivietController {
    @Autowired
    private BaivietService baivietService;

    
    @GetMapping("/baiviet")
    public String baivietView(Model model){
        model.addAttribute("baiviet", new Baiviet());
        return "baiviet";
    }
    
    @PostMapping("/baiviet")
    public String AddBaiviet(Model model, @ModelAttribute(value = "baiviet") Baiviet baiviet,HttpSession session){
        User u = (User) session.getAttribute("currentUser");
        if(this.baivietService.AddBaiviet(baiviet, u)==true)
            return "redirect:/";
        else
            model.addAttribute("errMsg","Loi");
        return "baiviet";
    }
    
    @RequestMapping("/daugia")
    public String daugia(Model model, @RequestParam(required = false) Map<String, String> params){
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("baiviet", this.baivietService.getBaiviet(page));
        
        return "daugia";
    }
    
    @RequestMapping("/daugia/{id}")
    public String baiviet_ct(Model model, @PathVariable("id") int idBaiviet){
        model.addAttribute("baiviet", this.baivietService.getBaivietById(idBaiviet));
        
        return "baiviet_ct";
    }
    

}
