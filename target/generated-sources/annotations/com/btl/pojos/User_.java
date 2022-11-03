package com.btl.pojos;

import com.btl.pojos.Baiviet;
import com.btl.pojos.Binhluan;
import com.btl.pojos.Danhgia;
import com.btl.pojos.Donhang;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-10-21T19:04:43")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> image;
    public static volatile SingularAttribute<User, String> sdt;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SetAttribute<User, Donhang> donhangSet;
    public static volatile SetAttribute<User, Binhluan> binhluanSet;
    public static volatile SetAttribute<User, Danhgia> danhgiaSet;
    public static volatile SingularAttribute<User, String> name;
    public static volatile SingularAttribute<User, Integer> id;
    public static volatile SingularAttribute<User, String> userRole;
    public static volatile SingularAttribute<User, String> cmnd;
    public static volatile SetAttribute<User, Baiviet> baivietSet;
    public static volatile SingularAttribute<User, String> username;

}