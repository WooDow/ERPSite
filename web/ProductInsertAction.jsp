<%-- 
    Document   : ProductInsertAction
    Created on : 2017/6/11, 下午 04:00:40
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
    <sql:update var="result" dataSource="${ds}">
        INSERT INTO Products VALUES ( ? , ? , ? , ? , ? , ? , ? , ? , ? )
        <sql:param>${param.pcode}</sql:param>
        <sql:param>${param.pname}</sql:param>
        <sql:param>${param.pline}</sql:param>
        <sql:param>${param.pscale}</sql:param>
        <sql:param>${param.pvendor}</sql:param>
        <sql:param>${param.pdesc}</sql:param>
        <sql:param>${param.pqty}</sql:param>
        <sql:param>${param.pcost}</sql:param>
        <sql:param>${param.pmsrp}</sql:param>
    </sql:update>
    <body>
        <h1>產品建檔作業</h1>
        結果: ${result}
    </body>
</html>
