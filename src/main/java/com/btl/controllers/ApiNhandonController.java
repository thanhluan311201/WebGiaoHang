package com.btl.controllers;

import com.btl.pojos.Baiviet;

import com.btl.pojos.Donhang;
import com.btl.pojos.User;
import com.btl.service.BaivietService;
import com.btl.service.DonhangService;

import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
@RestController
public class ApiNhandonController {
    @Autowired
    private BaivietService baivietService;
    @Autowired
    private DonhangService donhangService;

    
    @PostMapping(path = "/api/add-donhang", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Donhang> addDonhang(@RequestBody Map<String, String> params, HttpSession session){
        User u = (User) session.getAttribute("currentUser");
        if (u != null)
            try{
                int idBaiviet = Integer.parseInt(params.get("idBaiviet"));
                
                Baiviet bv = this.baivietService.getBaivietById(idBaiviet);
                Donhang d = this.donhangService.addDonhang(bv, u);

                if(this.baivietService.updateBaiviet(bv) == true)
                return new ResponseEntity<>(d, HttpStatus.CREATED);
            } catch (Exception ex){
                ex.printStackTrace();
            }
        
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
