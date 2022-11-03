/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.btl.service;

import com.btl.pojos.Baiviet;
import com.btl.pojos.Donhang;
import com.btl.pojos.User;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface DonhangService {
    List<Donhang> getDonhang();
    List<Donhang> getDonhangByShipper(int iduser);
    Donhang addDonhang(Baiviet bv, User creator);
    List<Donhang> getDonhangByUser(int iduser);
    boolean updateDonHang(Donhang d);
    Donhang getDonhangById(int idDonhang);
}
