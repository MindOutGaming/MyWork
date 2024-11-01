/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finlogic.step.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author sohel1
 */
public class LoginRepository {

    String url = "jdbc:mysql://192.168.208.2:3306/njindiainvest?useOldAliasMetadataBehavior=true&sslMode=DISABLED&characterSetResults=Cp1252&characterEncoding=Cp1252&allowLoadLocalInfile=true";
    String user = "njindiainvest";
    String password = "njindiainvest";

    public int checkLoginDetails(String username, String pass) throws SQLException {
        Connection con = DriverManager.getConnection(url, user, password);
        // select statement
        PreparedStatement stmt = con.prepareStatement("select count(username) from loginexample where username = ? and password = ?;");

        stmt.setString(1, username);
        stmt.setString(2, pass);
        ResultSet rs = stmt.executeQuery();
        int status = 0;
        
        if (rs.next()) {
            status = rs.getInt(1);
    {{}}    }
        return status;
    }
}

