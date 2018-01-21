<%-- 
    Document   : login_check
    Created on : 2017/6/11, 上午 11:45:12
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
    <sql:query var="rows" dataSource="${ds}">
        select * from employees where  employeeNumber = ? and  passwd = ?
        <sql:param>${param.account}</sql:param>
        <sql:param>${param.passwd}</sql:param>
    </sql:query>
        <c:choose>
            <c:when test="${rows.rowCount>0}">                
                <c:set var="username" value="${rows.getRowsByIndex()[0][4]}" scope="session"/>
                <c:set var="jobTitle" value="${rows.getRowsByIndex()[0][7]}" scope="session"/>
                <c:redirect url="erp_main.jsp"/>
            </c:when>
            <c:when test="${rows.rowCount < 1}">
                <c:url value="login.jsp" var="relogin">
                    <c:param name="error" value="登入失敗"/>
                </c:url>
                <c:redirect url="${relogin}"/>
            </c:when>
        </c:choose>
</html>
