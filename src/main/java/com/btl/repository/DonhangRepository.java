/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.btl.repository;

import com.btl.pojos.Donhang;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author Admin
 */
@Component
public interface DonhangRepository {
    List<Donhang> getDonhang();
    List<Donhang> getDonhangByShipper(int iduser);
    List<Donhang> getDonhangByUser(int iduser);
    Donhang addDonhang(Donhang d);
    Donhang getDonhangById(int idDonhang);
    boolean updateDonHang(Donhang d);
}
