/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.controllers;

import com.btl.pojos.Baiviet;
import com.btl.pojos.Binhluan;
import com.btl.pojos.Danhgia;
import com.btl.pojos.User;
import com.btl.service.DanhgiaService;
import com.btl.service.UserService;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@RestController
public class ApiDanhgiaController {
    @Autowired
    private DanhgiaService danhgiaService;
    @Autowired
    private UserService userService;
    
    @PostMapping(path = "/api/add-danhgia", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Danhgia> addDanhgia(@RequestBody Map<String, String> params, HttpSession session){

            try{
                String noidung = params.get("noidung");
                int idUser = Integer.parseInt(params.get("idUser"));
                User u = this.userService.getUserById(idUser);
                
                Danhgia d = this.danhgiaService.addDanhgia(noidung, u);

                return new ResponseEntity<>(d, HttpStatus.CREATED);
            } catch (Exception ex){
                ex.printStackTrace();
            }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
