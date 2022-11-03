/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.btl.service;

import com.btl.pojos.Baiviet;
import com.btl.pojos.User;
import java.util.List;


/**
 *
 * @author Admin
 */

public interface BaivietService {
    boolean AddBaiviet(Baiviet baiviet, User creator);
    List<Baiviet> getBaiviet(int page);
    Baiviet getBaivietById(int idBaiviet);
    List<Baiviet> getBaivietByUser(int iduser);
    boolean updateBaiviet(Baiviet baiviet);
}
