<%-- 
    Document   : EjemploFunctions
    Created on : 24/04/2023, 5:53:26 p. m.
    Author     : Néstor David Heredia Gutierrez (2058558-2711)
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:set var="datos" value="Ana, López, Directora, 75000"/>

        <c:set var="datosArray" value="${fn:split(datos, ',')}"/>

        <input type="text" value="${datosArray[0]}"><br/>
        <input type="text" value="${datosArray[1]}"><br/>
        <input type="text" value="${datosArray[2]}"><br/>
        <input type="text" value="${datosArray[3]}">

    </body>
</html>
