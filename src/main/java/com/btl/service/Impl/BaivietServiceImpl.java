/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.service.Impl;

import com.btl.pojos.Baiviet;
import com.btl.pojos.User;
import com.btl.repository.BaivietRepository;
import com.btl.service.BaivietService;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Service
@Transactional
public class BaivietServiceImpl implements BaivietService{
    @Autowired
    private BaivietRepository baivietRepository;
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<Baiviet> getBaiviet(int page) {
        return this.baivietRepository.getBaiviet(page);
    }
    
    @Override
    public List<Baiviet> getBaivietByUser(int iduser) {
        return this.baivietRepository.getBaivietByUser(iduser);
    }

    @Override
    public boolean AddBaiviet(Baiviet baiviet, User creator) {
        try {
            Map r = this.cloudinary.uploader().upload(baiviet.getFile().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));
            baiviet.setAnh((String) r.get("secure_url"));
            baiviet.setIdUser(creator);
            baiviet.setNgaytao(new Date());
            baiviet.setTinhtrang(baiviet.AVAIL);
            return this.baivietRepository.AddBaiviet(baiviet);
        } catch(IOException ex){
                ex.printStackTrace();
            }
        return false;
    }

    @Override
    public Baiviet getBaivietById(int idBaiviet) {
        return this.baivietRepository.getBaivietById(idBaiviet);
    }

    @Override
    public boolean updateBaiviet(Baiviet bv) { 
        
        return this.baivietRepository.updateBaiviet(bv);
    }
}
