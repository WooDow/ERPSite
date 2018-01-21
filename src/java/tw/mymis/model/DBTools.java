/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.mymis.model;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import tw.mymis.servlets.LoginCheck;

/**
 *
 * @author student
 */
public class DBTools {
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;
    private static Connection[] pools  = new Connection[50];
    
    static {
        try {
            //資料庫連線
            // 1. 載入 driver
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginCheck.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public static Connection getConnection() {
        Connection con = null;
        try{
            // 2. 取得連線            
            String connectionString = "jdbc:mariadb://127.0.0.1:3366/classicmodels";
            con = DriverManager.getConnection(connectionString,"root","1234");
            stmt = con.createStatement();
        }catch(SQLException e) {            
            
        }
        return con;
    }
    
    public static ResultSet getEmployeeByPassword(String employeeNumber , String passwd) {
        String sql = "Select * from employees where employeeNumber = " + employeeNumber + " and passwd= '"+passwd+"'";
        ResultSet rs = null;
        try{
            Connection con = DBTools.getConnection();
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
        }catch(SQLException e) {
            rs = null;
        }
        return rs;
    }
    
    public static Employee getEmployeeById(int employeeNumber) {
        String sql = "Select * from employees where employeeNumber = " + employeeNumber;
        ResultSet rs = null;
        Employee employee = null;
        try{
            Connection con = DBTools.getConnection();
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            // ORM     Object<--->RDBMS Mapping
            if( rs.next() ) {
                employee.setEmployeeNumber(rs.getInt(0));
                employee.setLastName(rs.getString(1));
                employee.setFirstName(rs.getString(2));
                employee.setExtension(rs.getString(3));
                employee.setEmail(rs.getString(4));
                //....
               
            } else {
                employee = null;
            }
        }catch(SQLException e) {
            
        } finally {
            //con.close();
        }
        return employee;
    }
    
}
