<%-- 
    Document   : CommonError
    Created on : 2017/6/18, 下午 04:28:10
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  isErrorPage="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>伺服器發生異常 !!</h1>
        
        異常原因:        
        <%= exception.getMessage() %>
        
    </body>
</html>
