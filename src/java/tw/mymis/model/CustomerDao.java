/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.mymis.model;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author student
 */
public class CustomerDao {
    private Connection con;
    
    public CustomerDao() {
        con = DBTools.getConnection();
    }
    
    public Customers getCustomerById(int customerNumber) throws SQLException {
        String sql = "Select * from customers where customerNumber = " + customerNumber;
        ResultSet rs = null;
        Statement stmt = con.createStatement();
        rs = stmt.executeQuery(sql);
        Customers customer = null;
        if( rs.next() ) {
            customer = new Customers();
            // fill-in customer properties....
            
            // 
        } else {
            customer = null;
        }
        return customer;        
    }
    
    public List getCustomersAll() throws SQLException {
        String sql = "Select * from customers";
        ArrayList customers = new ArrayList();
        ResultSet rs = null;
        Statement stmt = con.createStatement();
        rs = stmt.executeQuery(sql);
        while( rs.next()  ) {
            Customers customer = null;
            // 
            
            customers.add(customer);
        }
        
        return customers;
    }
}
