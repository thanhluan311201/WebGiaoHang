/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.btl.service;

import com.btl.pojos.Baiviet;
import com.btl.pojos.Binhluan;
import com.btl.pojos.User;

/**
 *
 * @author Admin
 */
public interface BinhluanService {
    Binhluan addBinhluan(String noidung, Baiviet bv, User creator);
}
