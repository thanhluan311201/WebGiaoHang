/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.repository.Impl;

import com.btl.pojos.Danhgia;
import com.btl.repository.DanhgiaRepository;
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
public class DanhgiaRepositoryImpl implements DanhgiaRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    @Transactional
    public Danhgia addDanhgia(Danhgia d) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try{
            session.save(d);
            
            return d;
        } catch (HibernateException ex){
            ex.printStackTrace();
        }
        
        return null;
    }
    
}
