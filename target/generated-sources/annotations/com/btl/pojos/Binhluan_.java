package com.btl.pojos;

import com.btl.pojos.Baiviet;
import com.btl.pojos.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-10-21T19:04:43")
@StaticMetamodel(Binhluan.class)
public class Binhluan_ { 

    public static volatile SingularAttribute<Binhluan, User> idUser;
    public static volatile SingularAttribute<Binhluan, Baiviet> idBaiviet;
    public static volatile SingularAttribute<Binhluan, Integer> id;
    public static volatile SingularAttribute<Binhluan, String> noidung;
    public static volatile SingularAttribute<Binhluan, Date> thoigian;

}