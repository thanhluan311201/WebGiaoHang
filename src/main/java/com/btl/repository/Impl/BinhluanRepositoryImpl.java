/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.repository.Impl;

import com.btl.pojos.Binhluan;
import com.btl.repository.BinhluanRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Repository
@Transactional
public class BinhluanRepositoryImpl implements BinhluanRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public Binhluan addBinhluan(Binhluan b) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try{
            session.save(b);
            
            return b;
        } catch (HibernateException ex){
            ex.printStackTrace();
        }
        
        return null;
    }
    
}
