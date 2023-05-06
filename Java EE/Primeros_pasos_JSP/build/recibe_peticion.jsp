<%-- 
    Document   : recibe_peticion
    Created on : 24/04/2023, 4:10:38 p. m.
    Author     : Néstor David Heredia Gutierrez (2058558-2711)
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            // Leyendo datos del formulario
            String ciudad_favorita = request.getParameter("ciudad_favorita");
            
            // Crear la Cookie
            Cookie laCookie = new Cookie("agencia_viajes.ciudad_favorita", ciudad_favorita);
            
            // Vida de la Cookie
            laCookie.setMaxAge(365*24*60*60); //un año según cálculo del parámetro
            
            // Enviar a Usuario
            response.addCookie(laCookie);         
        %>

        Gracias por enviar tus preferencias

        <a href="agencia_viajes.jsp">Ir a la agencia de viajes</a>

    </body>
</html>
