/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc1;

/**
 *
 * @author sohel1
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SqlUtil {

    String url = "jdbc:mysql://192.168.208.2:3306/njindiainvest?useOldAliasMetadataBehavior=true&sslMode=DISABLED&characterSetResults=Cp1252&characterEncoding=Cp1252&allowLoadLocalInfile=true";
    String user = "njindiainvest";
    String password = "njindiainvest";

    public ResultSet executeQuery(String sql) throws SQLException {
        Connection con = DriverManager.getConnection(url, user, password);
        // select statement
        Statement stmt = con.createStatement();

        ResultSet rs = stmt.executeQuery(sql);

        return rs;
    }

    // select * from loginexample where username = ?
    public ResultSet executeQuery(String sql, List data) throws SQLException {
        Connection con = DriverManager.getConnection(url, user, password);
        // select statement
        PreparedStatement stmt = con.prepareStatement(sql);
        
        for (int i = 0; i < data.size(); i++) {
            stmt.setObject(i+1, data.get(i));
        }
        
        ResultSet rs = stmt.executeQuery();

        return rs;
    }
    
    // select * from loginexample where username = ?
    // insert into agencyexample values (?, ?, ?, ?, ?);
    public int executeUpdate(String sql, List data) throws SQLException {
        Connection con = DriverManager.getConnection(url, user, password);
        // dml
        PreparedStatement stmt = con.prepareStatement(sql);

        for (int i = 0; i < data.size(); i++) {
            stmt.setObject(i+1, data.get(i));
        }
        
        int status = stmt.executeUpdate();

        return status;
    }
    
    public int executeUpdate(String sql) throws SQLException {
        Connection con = DriverManager.getConnection(url, user, password);
        // select statement
        Statement stmt = con.createStatement();

        // number of rows inserted or updated or deleted
        // number of rows affected
        int status = stmt.executeUpdate(sql);

        return status;
    }

}
