<%-- 
    Document   : observer
    Created on : 2016-apr-25, 13:29:18
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
        <h1>All Observers!</h1>
        <form action="" method="POST">
            <input type="text" name="observername"/>
            <input type="submit" value="OK"/>
        </form>
        
        <table>
            <c:forEach items="${allObservers}" var="observer">
            <tr><td>${observer.observername}</td></tr>
            </c:forEach>
        </table>
    </body>
</html>
