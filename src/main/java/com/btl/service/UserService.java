/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.btl.service;

import com.btl.pojos.User;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;




/**
 *
 * @author Admin
 */


public interface UserService extends UserDetailsService{
    boolean addUser(User user);
    boolean addShipper(User shipper);
    List<User> getUsers(String username);
    List<User> getUserByUserRole(String SHIPPER);
    User getUserById(int id);
}
