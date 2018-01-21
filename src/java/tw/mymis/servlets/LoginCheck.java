/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.mymis.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import tw.mymis.model.DBTools;

/**
 *
 * @author student
 */
public class LoginCheck extends HttpServlet {
    private Connection con;
    private Statement stmt;
    private ResultSet rs;
    private HttpSession session; // session 物件
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)            throws ServletException, IOException {
        
        con = DBTools.getConnection();
        
                        
            // 檢查帳密 取得表單資料
            // 3. 預備 Statement
        
            String user = request.getParameter("account");
            String passwd = request.getParameter("passwd");
            rs = DBTools.getEmployeeByPassword(user, passwd);
        try{
            if( rs.next() ) {
            // 儲存使用者資訊(session)  處理檢查結果
                session = request.getSession();
                session.setAttribute("username", rs.getString("email"));
                session.setAttribute("jobTitle", rs.getString("jobTitle"));
                // 1. 成功 --> erp_main.jsp
                RequestDispatcher dispatch = request.getRequestDispatcher("erp_main.jsp");
                dispatch.forward(request, response);                
            } else {
                // 2. 失敗 --> login.jsp
                RequestDispatcher dispatch = request.getRequestDispatcher("login.jsp");
                dispatch.forward(request, response);                
            }
        }catch(SQLException e) {                
    
        }
                    
            
            
            
            
            
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
