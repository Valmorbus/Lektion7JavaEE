<%-- 
    Document   : bird
    Created on : 2016-apr-25, 11:12:36
    Author     : borgs_000
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>All Birds!</h1>
        <form action="" method="POST">
            <input type="text" name="birdname"/>
            <input type="submit" value="OK"/>
        </form>
        
        <table>
            <c:forEach items="${allBirds}" var="bird">
            <tr><td>${bird.birdname}</td></tr>
            </c:forEach>
        </table>
    </body>
</html>
