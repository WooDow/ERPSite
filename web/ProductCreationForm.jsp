<%-- 
    Document   : ProductCreationForm
    Created on : 2017/6/11, 下午 04:00:05
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include  file="WEB-INF/jspf/dsfile.jspf" %>
<sql:query var="plines" dataSource="${ds}">
    SELECT  productLine  FROM PRODUCTLINES
</sql:query>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>模型產品資料建立作業</h1>
        <hr/>
        <form action="ProductInsertAction.jsp" method="POST">
            產品代碼: <input type="text" name="pcode" value="" size="6"  />  <br/>
            產品類型: 
            <select name="pline">
                <c:forEach var="pline" items="${plines.rowsByIndex}">
                    <option>${pline[0]}</option>
                </c:forEach>                 
            </select>
            <br/>
            模型名稱: <input type="text" name="pname" value=""  size="30"/>  <br/>
            模型比例: <input type="text" name="pscale" value="" size="6"/>  <br/>
            供應商: :<input type="text" name="pvendor" value="" size="30"/>  <br/>
            在庫數量: <input type="text" name="pqty" value=""  size="6"/>  <br/>            
            進貨成本: <input type="text" name="pcost" value="" size="6" />  <br/>
            標準售價: <input type="text" name="pmsrp" value="" size="6" />  <br/>
            產品說明: <textarea name="pdesc" rows="4" cols="20">
            </textarea>
            <br/>
            <input type="submit" value="存檔" /><input type="reset" value="清除" />
        </form>
        
    </body>
</html>
