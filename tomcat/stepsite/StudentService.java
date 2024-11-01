  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finlogic.step.service;

import com.finlogic.step.repository.StudentRepository;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author sohel1
 */
public class StudentService {
    StudentRepository studentRepository = new StudentRepository();
    
    public ResultSet getAllStudents() throws SQLException {
        return studentRepository.getAllStudents();
    }
    
    public int insertStudent(String name, 
            String address, 
            String email, 
            String state, 
            String city) throws SQLException {
        return studentRepository.insertStudent(name, address, email, state, city);
    }
}

