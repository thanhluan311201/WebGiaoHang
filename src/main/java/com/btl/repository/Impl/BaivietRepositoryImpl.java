/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.repository.Impl;

import com.btl.pojos.Baiviet;
import com.btl.pojos.User;
import com.btl.repository.BaivietRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
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
public class BaivietRepositoryImpl implements BaivietRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Baiviet> getBaiviet(int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Baiviet> query = builder.createQuery(Baiviet.class);
        Root root = query.from(Baiviet.class);
        query = query.select(root);
        
        Predicate p = builder.like(root.get("tinhtrang").as(String.class), Baiviet.AVAIL);
        query = query.where(p).orderBy(builder.desc(root.get("ngaytao")));
        Query q = session.createQuery(query);
        
        int max = 3;
        q.setMaxResults(max);
        q.setFirstResult((page - 1) * max);
        
        return q.getResultList();
    }
    
    @Override
    public List<Baiviet> getBaivietByUser(int iduser) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Baiviet> query = builder.createQuery(Baiviet.class);
        Root root = query.from(Baiviet.class);
        query = query.select(root);
        
        Predicate p = builder.equal(root.get("idUser"), iduser);
        query = query.where(p).orderBy(builder.desc(root.get("ngaytao")));
        
        Query q = session.createQuery(query);
        
        return q.getResultList();
    }

    @Override
    public boolean AddBaiviet(Baiviet baiviet) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try{
            session.save(baiviet);
            return true;
        }catch(HibernateException ex){
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public Baiviet getBaivietById(int idBaiviet) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Baiviet.class, idBaiviet);
    }
    
    @Override
    public boolean updateBaiviet(Baiviet bv){
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        try{
            Baiviet b = this.getBaivietById(bv.getId());
            b.setTinhtrang(Baiviet.UNAVAIL);
            session.update(b);
            
            return true;
        }catch(HibernateException ex){
            System.err.println(ex.getMessage());
        }
                
        return false;
    }
}    
