/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finlogic.step.repository;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author sohel1
 */
public class StudentRepository {
     String url = "jdbc:mysql://192.168.208.2:3306/njindiainvest?useOldAliasMetadataBehavior=true&sslMode=DISABLED&characterSetResults=Cp1252&characterEncoding=Cp1252&allowLoadLocalInfile=true";
    String user = "njindiainvest";
    String password = "njindiainvest";

    public ResultSet getAllStudents() throws SQLException {
        Connection con = DriverManager.getConnection(url, user, password);
        // select statement
        PreparedStatement stmt = con.prepareStatement("select name, address, email, state, city from studentexample;");

        ResultSet rs = stmt.executeQuery();
        
        return rs;
    }
    
    public int insertStudent(String name, 
            String address, 
            String email, 
            String state, 
            String city) throws SQLException {
        Connection con = DriverManager.getConnection(url, user, password);
        // insert statement
        PreparedStatement stmt = con.prepareStatement(
                "insert into studentexample (name, address, email, state, city) values (?, ?, ?, ?, ?);");

        stmt.setString(1, name);
        stmt.setString(2, address);
        stmt.setString(3, email);
        stmt.setString(4, state);
        stmt.setString(5, city);
        
        return stmt.executeUpdate();
    }
}

