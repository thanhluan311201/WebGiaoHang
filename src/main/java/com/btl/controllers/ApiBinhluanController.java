/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.controllers;

import com.btl.pojos.Baiviet;
import com.btl.pojos.Binhluan;
import com.btl.pojos.User;
import com.btl.service.BaivietService;
import com.btl.service.BinhluanService;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@RestController
public class ApiBinhluanController {
    @Autowired
    private BinhluanService binhluanService;
    @Autowired
    private BaivietService baivietService;
    
    @PostMapping(path = "/api/add-comment", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Binhluan> addBinhluan(@RequestBody Map<String, String> params, HttpSession session){
        User u = (User) session.getAttribute("currentUser");
        if (u != null)
            try{
                String noidung = params.get("noidung");
                int idBaiviet = Integer.parseInt(params.get("idBaiviet"));
                
                Baiviet bv = this.baivietService.getBaivietById(idBaiviet);
                Binhluan b = this.binhluanService.addBinhluan(noidung, bv, u);

                return new ResponseEntity<>(b, HttpStatus.CREATED);
            } catch (Exception ex){
                ex.printStackTrace();
            }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
