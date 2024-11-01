/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finlogic.step.service;

import com.finlogic.step.repository.LoginRepository;
import java.sql.SQLException;
/**
 *
 * @author sohel1
 */
public class LoginService {
    LoginRepository loginRepository = new LoginRepository();
    
    public int verifyLoginDetails(String username, String password) 
            throws SQLException {
        return loginRepository.checkLoginDetails(username, password);
    } 
}

