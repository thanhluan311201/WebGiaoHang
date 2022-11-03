/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.service.Impl;

import com.btl.pojos.Baiviet;
import com.btl.pojos.Binhluan;
import com.btl.pojos.User;
import com.btl.repository.BaivietRepository;
import com.btl.repository.BinhluanRepository;
import com.btl.service.BinhluanService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Service
public class BinhluanServiceImpl implements BinhluanService{
    @Autowired
    private BinhluanRepository binhluanRepository;


    @Override
    public Binhluan addBinhluan(String noidung, Baiviet bv, User creator) {
        
        Binhluan b = new Binhluan();
        b.setNoidung(noidung);
        b.setIdBaiviet(bv);
        b.setIdUser(creator);
        b.setThoigian(new Date());
        
        return this.binhluanRepository.addBinhluan(b);
    }


}
