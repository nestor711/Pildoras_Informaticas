<%-- 
    Document   : ejemplo_objetos
    Created on : 23/04/2023, 12:57:07 p. m.
    Author     : Néstor David Heredia Gutierrez (2058558-2711)
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <h2>Objetos Predefinidos JSP</h2>

        Petición datos del Navegador: <%= request.getHeader("User-Agent") %>

        <br/><br/>

        Petición idioma utilizado: <%= request.getLocale() %>

    </body>
</html>
