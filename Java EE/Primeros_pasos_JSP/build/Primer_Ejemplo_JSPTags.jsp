<%-- 
    Document   : Primer_Ejemplo_JSPTags
    Created on : 24/04/2023, 4:43:32 p. m.
    Author     : Néstor David Heredia Gutierrez (2058558-2711)
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    String alumnos[] = {"Antonio", "Sandra", "Maria", "Paco"};
    
    pageContext.setAttribute("losAlumnos", alumnos);
    
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:forEach var="tempAlumnos" items="${losAlumnos}">
            ${tempAlumnos} <br/>
        </c:forEach>
    </body>
</html>
