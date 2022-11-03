/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.repository.Impl;

import com.btl.pojos.Baiviet;
import com.btl.pojos.Donhang;
import com.btl.repository.DonhangRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
public class DonhangRepositoryImpl implements DonhangRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Donhang> getDonhangByShipper(int iduser) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Donhang> query = builder.createQuery(Donhang.class);
        Root root = query.from(Donhang.class);
        query = query.select(root);
        
        Predicate p = builder.equal(root.get("idUser"), iduser);
        query = query.where(p);
        
        Query q = session.createQuery(query);
        
        return q.getResultList();
    }

    @Override
    public Donhang addDonhang(Donhang d) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try{
            session.save(d);
            
            return d;
        }catch (HibernateException ex){
            ex.printStackTrace();
        }
        
        return d;
    }

    @Override
    public List<Donhang> getDonhangByUser(int i) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Donhang> query = builder.createQuery(Donhang.class);
        Root root = query.from(Donhang.class);
        query = query.select(root);
        
        Predicate p = builder.equal(root.get("idBaiviet").get("idUser"), i);
        query = query.where(p);
        
        Query q = session.createQuery(query);
        
        return q.getResultList();
    }

    @Override
    public boolean updateDonHang(Donhang dnhng) {
    Session session = this.sessionFactory.getObject().getCurrentSession();
        
    try{
        Donhang d = this.getDonhangById(dnhng.getId());
        d.setTinhtrang(Donhang.COMPLETE);
        session.update(d);

        return true;
    }catch(HibernateException ex){
        System.err.println(ex.getMessage());
    }

    return false;    }

    @Override
    public Donhang getDonhangById(int i) {
    Session session = this.sessionFactory.getObject().getCurrentSession();
    
    return session.get(Donhang.class, i);    
    }

    @Override
    public List<Donhang> getDonhang() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Donhang> query = builder.createQuery(Donhang.class);
        Root root = query.from(Donhang.class);
        query = query.select(root);
        
        Query q = session.createQuery(query);
        
       
        
        return q.getResultList();
    }
}

