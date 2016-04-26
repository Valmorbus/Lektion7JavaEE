<%-- 
    Document   : home
    Created on : 2016-apr-25, 13:40:10
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
        <h1>Hello World!</h1>
        <form action="" method="POST">
            Bird:
        <select name="birdvalue">
            <c:forEach items="${allBirds}" var="bird">
                <option value=${bird.id}>${bird.birdname}</option>
            </c:forEach>
                        
                        
        </select> 
            Observer:
             <select name="observersvalue">
            <c:forEach items="${allObservers}" var="observers">
                <option value=${observers.id}>${observers.observername}</option>
            </c:forEach>
                               
        </select> 
            <input type="text" name="comment"/>
            <input type="submit" value="OK"/>
        </form>
        <br><br><br>
        
         <table>
            <c:forEach items="${allObservation}" var="observation">
            <tr><td>${observation.bird.birdname}</td>
            <td>${observation.observer.observername}</td>
            <td>${observation.comment}</td></tr>
            </c:forEach>
        </table>
        <br>

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
 
        
        <br><br><br><br>
   
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
