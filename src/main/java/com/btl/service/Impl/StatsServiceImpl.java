/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.service.Impl;

import com.btl.repository.StatsRepository;
import com.btl.service.StatsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class StatsServiceImpl implements StatsService{
    @Autowired
    private StatsRepository statsRepository;

    @Override
    public List<Object[]> donhangStats() {
        return this.statsRepository.donhangStats();
    }

    @Override
    public List<Object[]> baivietStats() {
        return this.statsRepository.baivietStats();
    }
    
}
