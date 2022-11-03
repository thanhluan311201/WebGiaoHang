/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.repository.Impl;

import com.btl.pojos.Baiviet;
import com.btl.pojos.Donhang;
import com.btl.pojos.User;
import com.btl.repository.StatsRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.Query;
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
public class StatsRepositoryImpl implements StatsRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Object[]> donhangStats() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        
        Root rootU = q.from(User.class);
        Root rootD = q.from(Donhang.class);
        
        q.where(b.equal(rootD.get("idUser"), rootU.get("id")));
        
        q.multiselect(rootU.get("id"), rootU.get("name"),
                b.count(rootD.get("id")));
        
        q.groupBy(rootU.get("id"));
        
        Query query = session.createQuery(q);
        
        return query.getResultList();
    }

    @Override
    public List<Object[]> baivietStats() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        
        Root rootU = q.from(User.class);
        Root rootB = q.from(Baiviet.class);
        
        q.where(b.equal(rootB.get("idUser"), rootU.get("id")));
        
        q.multiselect(rootU.get("id"), rootU.get("name"),
                b.count(rootB.get("id")));
        
        q.groupBy(rootU.get("id"));
        
        Query query = session.createQuery(q);
        
        return query.getResultList();
    }
    
}
