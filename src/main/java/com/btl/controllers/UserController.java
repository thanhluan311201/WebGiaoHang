/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.controllers;

import com.btl.pojos.Baiviet;
import com.btl.pojos.User;
import com.btl.service.BaivietService;
import com.btl.service.UserService;
import com.cloudinary.Cloudinary;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;


import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Admin
 */

@Controller
public class UserController {
    @Autowired
    private UserService userDetailsService;
    @Autowired
    private BaivietService baivietService;
    @Autowired
    private Cloudinary cloudinary;
    
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    
    @GetMapping("/register")
    public String registerView(Model model){
        model.addAttribute("user", new User());
        return "register";
    }
    
    @PostMapping("/register")
    public String register(Model model, @ModelAttribute(value = "user") User user){
        String errMsg = "";
        if (user.getPassword().equals(user.getConfirmPassword())){
            if (this.userDetailsService.addUser(user) == true)
               return "redirect:/login";
            else
                errMsg ="Loi";
        } else
            errMsg = "Mat khau khong khop";
        model.addAttribute("errMsg", errMsg);
        
        return "register";
    }
    
    
    
    @RequestMapping("/user/{userId}")
    public String user(Model model, @PathVariable(value = "userId") int userId){
        model.addAttribute("baiviet", this.baivietService.getBaivietByUser(userId));
        model.addAttribute("user", this.userDetailsService.getUserById(userId));
        
        return "user";
    }
    
}
