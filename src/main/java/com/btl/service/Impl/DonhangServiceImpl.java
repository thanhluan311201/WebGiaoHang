/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.service.Impl;

import com.btl.pojos.Baiviet;
import com.btl.pojos.Donhang;
import com.btl.pojos.User;
import com.btl.repository.DonhangRepository;
import com.btl.service.DonhangService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Service
public class DonhangServiceImpl implements DonhangService{
    @Autowired
    private DonhangRepository donhangRepository;

    @Override
    @Transactional
    public List<Donhang> getDonhangByShipper(int iduser) {
        return this.donhangRepository.getDonhangByShipper(iduser);
    }

    @Override
    public Donhang addDonhang(Baiviet bv, User creator) {
        
        Donhang d = new Donhang();
        d.setIdBaiviet(bv);
        d.setIdUser(creator);
        d.setTinhtrang(Donhang.SHIPPING);
        
        return this.donhangRepository.addDonhang(d);
    }

    @Override
    public List<Donhang> getDonhangByUser(int iduser) {
        return this.donhangRepository.getDonhangByUser(iduser);
    }

    @Override
    public boolean updateDonHang(Donhang d) {
        return this.donhangRepository.updateDonHang(d);
    }

    @Override
    public Donhang getDonhangById(int i) {
        return this.donhangRepository.getDonhangById(i);
    }

    @Override
    public List<Donhang> getDonhang() {
        return this.donhangRepository.getDonhang();
    }
    
}
