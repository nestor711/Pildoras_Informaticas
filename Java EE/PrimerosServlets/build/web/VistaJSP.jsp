<%-- 
    Document   : VistaJSP
    Created on : 27/04/2023, 8:24:34 a. m.
    Author     : Néstor David Heredia Gutierrez (2058558-2711)
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:forEach var="tempProductos" items="${lista_productos}">
            ${tempProductos}<br>
        </c:forEach>
    </body>
</html>
