<%-- 
    Document   : EjemploScriptlet
    Created on : 23/04/2023, 12:10:08 p. m.
    Author     : Néstor David Heredia Gutierrez (2058558-2711)
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <h1>
            Ejemplo mde scriptlet
        </h1>

        <%
            for(int i=0; i<10; i++){
            out.println("<br>Este es el mensaje " + i);
            }
            
        %>

    </body>
</html>
