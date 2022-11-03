/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.btl.repository;

import com.btl.pojos.Baiviet;
import java.util.List;
import org.springframework.stereotype.Component;



/**
 *
 * @author Admin
 */
@Component
public interface BaivietRepository {
    boolean AddBaiviet(Baiviet baiviet);
    List<Baiviet> getBaiviet(int page);
    List<Baiviet> getBaivietByUser(int iduser);
    Baiviet getBaivietById(int idBaiviet);
    boolean updateBaiviet(Baiviet baiviet);
}
