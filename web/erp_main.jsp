<%-- 
    Document   : erp_main
    Created on : 2017/6/11, 上午 11:45:31
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
        // 請使用 JSTL 開發此段 判斷程式
        // 檢查登入狀態
        // 未登入 請返回 login.jsp
        String username = null;
        username = (String) session.getAttribute("username");
        if( null == username || username.length() < 3) {
            // 登入狀態異常 轉送回 login.jsp
            
        }
        
        // 已登入 繼續進行以下畫面顯示
    %>
    <body>
        
        <h1>ERP Main</h1>
        <c:if test="${empty sessionScope.username}">
            <c:redirect url="login.jsp"/>
        </c:if>
        
        登入身分: ${sessionScope.username} <br/>
        職稱: ${sessionScope.jobTitle}  <br/>
        <hr/>
        <a href="QueryCustomer.jsp">客戶資料查詢</a><br/>
        <a href="#">訂單資料查詢</a><br/>
        <a href="#">產品資料查詢</a><br/>
        <a href="#">庫存資料查詢</a><br/>
        <hr/>
        <h2>資料維護作業</h2>
        <a href="ProductCreationForm.jsp">產品資料建檔</a><br/>
        
    </body>
</html>
