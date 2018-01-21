<%-- 
    Document   : QueryCustomerByCountry
    Created on : 2017/6/11, 下午 02:52:14
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<sql:setDataSource var="ds"
                       driver="org.mariadb.jdbc.Driver"
                       url="jdbc:mariadb://127.0.0.1:3366/classicmodels" 
                       user="root" password="12345" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>依據國家地區查詢客戶</h1>
        國家別: ${param.country}
        <hr/>
        <sql:query var="customers" dataSource="${ds}">
            Select * from Customers where country = ?
            <sql:param>${param.country}</sql:param>
        </sql:query>
    
        <table border="1">
            <!-- column headers -->
            <tr>
                <c:forEach var="columnName" items="${customers.columnNames}">
                    <th><c:out value="${columnName}"/></th>
                    </c:forEach>
            </tr>
            <!-- column data -->
            <c:forEach var="row" items="${customers.rowsByIndex}">
                <tr>
                    <c:forEach var="column" items="${row}">
                        <td><c:out value="${column}"/></td>
                    </c:forEach>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
