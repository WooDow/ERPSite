<%-- 
    Document   : QueryCustomer
    Created on : 2017/6/11, 下午 02:37:38
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include  file="WEB-INF/jspf/dsfile.jspf" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>客戶資料查詢</h1>
        <hr/>
        <h3> 依國家/地區查詢</h3>
        <sql:query var="cuntries" dataSource="${ds}">
            SELECT distinct country from customers order by country
        </sql:query>
            
            <form action="QueryCustomerByCountry.jsp" method="POST">
               客戶所在國家: 
               <select name="country">
                <c:forEach var="row" items="${cuntries.rowsByIndex}">                                           
                            <option>${row[0]}</option>                    
                </c:forEach>        
              </select>
               <input type="submit" value="查詢" />
            </form>
    </body>
</html>
