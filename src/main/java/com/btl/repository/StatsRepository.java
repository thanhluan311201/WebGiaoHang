/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.btl.repository;

import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author Admin
 */
@Component
public interface StatsRepository {
    List<Object[]> donhangStats();
    List<Object[]> baivietStats();
}
