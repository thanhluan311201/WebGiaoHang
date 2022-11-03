/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.btl.repository;

import com.btl.pojos.Danhgia;
import org.springframework.stereotype.Component;

/**
 *
 * @author Admin
 */
@Component
public interface DanhgiaRepository {
    Danhgia addDanhgia(Danhgia d);
}
