<%-- 
    Document   : login
    Created on : 2017/6/11, 上午 11:44:48
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>ERP 使用者登入畫面</h1>
        <form action="LoginCheck.do" method="POST">
            帳號: <input type="text" name="account" value="" size="20" />  <br/>
            密碼: <input type="password" name="passwd" value="" size="20" />  <br/>
            <input type="submit" value="Login" />
        </form>
        <c:if test="${not empty param.error}">
            <h3>${param.error}</h3>
        </c:if>
       
    </body>
</html>
