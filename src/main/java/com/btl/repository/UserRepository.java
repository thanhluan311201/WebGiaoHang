/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.repository;


import com.btl.pojos.User;
import java.util.List;
import org.springframework.stereotype.Component;


/**
 *
 * @author Admin
 */
@Component
public interface UserRepository {
    boolean addUser(User user);
    boolean addShipper(User shipper);
    List<User> getUsers(String username);
    List<User> getUserByUserRole(String SHIPPER);
    User getUserById(int id);
    
}
