/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.service.Impl;

import com.btl.pojos.Danhgia;
import com.btl.pojos.User;
import com.btl.repository.BinhluanRepository;
import com.btl.repository.DanhgiaRepository;
import com.btl.service.DanhgiaService;
import org.eclipse.persistence.internal.libraries.antlr.runtime.misc.Stats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Service
public class DanhgiaServiceImpl implements DanhgiaService{
    @Autowired
    private DanhgiaRepository danhgiaRepository;

    @Override
    public Danhgia addDanhgia(String noidung, User u) {
        
        Danhgia d = new Danhgia();
        d.setNoidung(noidung);
        d.setIdUser(u);
        
        return this.danhgiaRepository.addDanhgia(d);
    }
    
}
