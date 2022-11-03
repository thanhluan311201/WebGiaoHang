package com.btl.pojos;

import com.btl.pojos.Binhluan;
import com.btl.pojos.Donhang;
import com.btl.pojos.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-10-21T19:04:43")
@StaticMetamodel(Baiviet.class)
public class Baiviet_ { 

    public static volatile SingularAttribute<Baiviet, User> idUser;
    public static volatile SingularAttribute<Baiviet, Date> ngaytao;
    public static volatile SetAttribute<Baiviet, Donhang> donhangSet;
    public static volatile SetAttribute<Baiviet, Binhluan> binhluanSet;
    public static volatile SingularAttribute<Baiviet, String> tinhtrang;
    public static volatile SingularAttribute<Baiviet, String> anh;
    public static volatile SingularAttribute<Baiviet, Integer> id;
    public static volatile SingularAttribute<Baiviet, String> noidung;

}