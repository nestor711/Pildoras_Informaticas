<%-- 
    Document   : Calculos
    Created on : 23/04/2023, 12:39:32 p. m.
    Author     : Néstor David Heredia Gutierrez (2058558-2711)
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@page import = "pildorasinformaticas.com.CalculosMatematicos.*" %>

<html>
    <body>
        La suma de 5 y 7 es: <%= Calculos.metodoSuma(5,7) %>
        <br>
        La resta de 5 y 7 es: <%= Calculos.metodoResta(5,7) %>
        <br>
        La multiplicación de 5 y 7 es: <%= Calculos.metodoMultiplica(5,7) %>
    </body>
</html>
