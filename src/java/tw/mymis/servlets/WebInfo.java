/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.mymis.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author student
 */
public class WebInfo extends HttpServlet {
    private String url = "jdbc:mariadb://localhost:3336/classicmodels";
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        //取得 ServletConfig 取出 config 內的參數
        ServletConfig config =  this.getServletConfig();
        ServletContext context = this.getServletContext();
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet WebInfo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>網站介紹</h1>");
            out.println("<hr/>");
            //若再測試階段, 顯示相關除錯資訊
            
            
            String mode = context.getInitParameter("WebMode");
            String modeName = mode.equals("dev") ? "開發階段" : "上線狀態";
            out.println("目前 web 執行模式: " + modeName +"<br/>");
            if( mode.equals("dev") ) {
                out.println("資料庫帳號: " + context.getInitParameter("Account") +"<br/>" );
                out.println("資料庫路徑: " + context.getInitParameter("DBServer") 
                        +"/" + context.getInitParameter("DBName") );
            } else {
                out.println("<h3>online模式</h3>");
            }
            
            out.println("使用 MVC架構開發 <br/>");            
            out.println("程式使用資料庫為: " + config.getInitParameter("DBType")+ "<Br/>");
            out.println("資料庫路徑為: " + config.getInitParameter("URL") );
            
            out.println("</body>");
            out.println("</html>");
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
