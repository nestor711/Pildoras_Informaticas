<%-- 
    Document   : EjemploDeclaraciones
    Created on : 23/04/2023, 12:15:48 p. m.
    Author     : Néstor David Heredia Gutierrez (2058558-2711)
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <h1 style="text-align: center">
            Ejemplo Declaraciones
        </h1>

        <%!
            private int resultado;

            public int metodoSuma(int num1, int num2){
                resultado = num1 + num2;
                return resultado;
            }

            public int metodoResta(int num1, int num2){
                resultado = num1 - num2;
                return resultado;
            }

            public int metodoMultiplica(int num1, int num2){
                resultado = num1 * num2;
                return resultado;
            }
            
        %>

        El resultado de la suma es: <%= metodoSuma(7,5)%>

        <br>
        El resultado de la resta es: <%= metodoResta(7,5)%>

        <br>
        El resultado de la multiplicación es: <%= metodoMultiplica(7,5)%>

    </body>
</html>
