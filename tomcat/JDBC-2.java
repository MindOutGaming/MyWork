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
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JDBC1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        // java: used to create applications
        // mysql: used to manage data
        /*
        Applications: UI, BL, Data
        FB: UI, BL, Data
        
        Java Application: communicate Data
        JDBC: Java Database Connectivity (API)
        
        Person: Phone Number
        
        Database Connect: jdbc url, username, password
        
        Connection: to establish connection between application and db.
        DriverManager: provider
        Statement: we can execute SQL statements on the db.
        PreparedStatement: we can execute SQL statements on the db.
        ResultSet: result of the executed SQL statements on the db.
        
        mysql < 8
        jdbc url: jdbc:<provider>://<hostname>:<port>/<dbname>
        -jdbc:mysql://192.168.208.2:3306/njindiainvest
        
        username: njindiainvest
        password: njindiainvest
        
        CRUD: Create, Retrieve, Update and Delete
         */
        System.out.println("Menu\n1. Retrieve All\n2. Add\n3. Update\n4. Delete\n5. Search");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        SqlUtil sqlUtil = new SqlUtil();
        String url = "jdbc:mysql://192.168.208.2:3306/njindiainvest?useOldAliasMetadataBehavior=true&sslMode=DISABLED&characterSetResults=Cp1252&characterEncoding=Cp1252&allowLoadLocalInfile=true";
        String user = "njindiainvest";
        String password = "njindiainvest";

        switch (option) {
            case 1:
                try {
                    ResultSet rs = sqlUtil.executeQuery("select username, password from loginexample");
                    while (rs.next()) {
                        System.out.println("Username: " + rs.getString("username"));
                        System.out.println("Password: " + rs.getString("password"));
                        System.out.println("======================================");
                    }
                } catch (SQLException e) {
                    System.out.println("An exception has occurred: " + e.getMessage());
                }
                break;

            case 2:
                // insert
                sc.nextLine();
                System.out.println("Enter username: \n");
                String userId = sc.nextLine();
                System.out.println("Enter password: \n");
                String pass = sc.nextLine();

                try {
                    /*Connection con = DriverManager.getConnection(url, user, password);
                    // select statement
                    PreparedStatement stmt = con.prepareStatement("insert into loginexample values (?, ?);");
                    // update loginexample set password = ? where username = ?
                    // delete from loginexample where username = ?
                    // insert into agencyexample values (?, ?, ?, ?, ?)
                    
                    stmt.setString(1, userId);
                    stmt.setString(2, pass);*/
                    
                    List data =  new ArrayList();
                    
                    data.add(userId);
                    data.add(pass);
                    
                    int status = sqlUtil.executeUpdate("insert into loginexample values (?,?);", data);
                    
                    if (status > 0) {
                        System.out.println("Data inserted successfully!");
                    }
                
                } catch (SQLException e) {
                    System.out.println("An exception has occurred: " + e.getMessage());
                }

                break;

            case 3:
                sc.nextLine();
                System.out.println("Enter username for updation: \n");
                String updatedUsername = sc.nextLine();
                System.out.println("Enter new password: \n");
                String updatedPass = sc.nextLine();

                try {
                    int status = sqlUtil.executeUpdate("update loginexample set password='" + updatedPass + "' where username = '" + updatedUsername + "'");

                    if (status > 0) {
                        System.out.println("Data updated successfully!");
                    }
                } catch (SQLException e) {
                    System.out.println("An exception has occurred: " + e.getMessage());
                }
                break;

            case 4:
                sc.nextLine();
                System.out.println("Enter username for updation: \n");
                String deleteUsername = sc.nextLine();

                try {
                    int status = sqlUtil.executeUpdate("delete from loginexample where username='" + deleteUsername + "';");

                    if (status > 0) {
                        System.out.println("Data deleted successfully!");
                    }
                } catch (SQLException e) {
                    System.out.println("An exception has occurred: " + e.getMessage());
                }
                break;

            case 5:
                sc.nextLine();
                System.out.println("Enter username for searching: \n");
                String searchUsername = sc.nextLine();

                try {
                    Connection con = DriverManager.getConnection(url, user, password);
                    // select statement
                    PreparedStatement stmt = con.prepareStatement("select * from loginexample where username = ?;");
                    
                    stmt.setString(1, searchUsername);
                    ResultSet rs = stmt.executeQuery();

                    while (rs.next()) {
                        System.out.println("Username: " + rs.getString("username"));
                        System.out.println("Password: " + rs.getString("password"));
                        System.out.println("=================================================");
                    }
                } catch (SQLException e) {
                    System.out.println("An exception has occurred: " + e.getMessage());
                }
                break;
        }

    }

}
