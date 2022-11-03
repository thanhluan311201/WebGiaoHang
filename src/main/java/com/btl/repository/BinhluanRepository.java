/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.btl.repository;

import com.btl.pojos.Binhluan;
import org.springframework.stereotype.Component;

/**
 *
 * @author Admin
 */
@Component
public interface BinhluanRepository {
    Binhluan addBinhluan(Binhluan b);
}
