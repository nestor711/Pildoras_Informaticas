<%-- 
    Document   : Lista_Compra
    Created on : 24/04/2023, 3:33:56 p. m.
    Author     : Néstor David Heredia Gutierrez (2058558-2711)
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@page import="java.util.*" %>
<html>
    <body>
        <form name="Formulario_Compra" action="Lista_Compra.jsp">

            <p>Artículos a comprar: </p>
            <p>
                <label>
                    <input type="checkbox" name="articulos" value="agua">
                    Agua</label>
                <br>
                <label>
                    <input type="checkbox" name="articulos" value="leche">
                    Leche</label>
                <br>
                <label>
                    <input type="checkbox" name="articulos" value="pan">
                    Pan</label>
                <br>
                <label>
                    <input type="checkbox" name="articulos" value="manzanas">
                    Manzanas</label>
                <br>
                <label>
                    <input type="checkbox" name="articulos" value="carne">
                    Carne</label>
                <br>
                <label>
                    <input type="checkbox" name="articulos" value="pescado">
                    Pescado</label>
            </p>
            <p>
                <input type="submit" name="button" id="button" value="Enviar">
                <br>
            </p>
        </form>

        <h2>Carro de la Compra: </h2>

        <ul>
            <%
            
            List<String> ListaElementos = (List<String>) session.getAttribute("misElementos");
            
            if(ListaElementos==null){
                ListaElementos = new ArrayList<String>();
                session.setAttribute("misElementos", ListaElementos);
            }
            
            String[] elementos = request.getParameterValues("ariculos");
        
            if(elementos!=null){
        
                for(String elemTemp : elementos){
                    // out.println("<li>" + elemTemp + "</li>");
                    ListaElementos.add(elemTemp);
                }
        
            }
            
            for(String elemTemp : ListaElementos){
                out.println("<li>" + elemTemp + "</li>");
            }
       
            %>
        </ul>
    </body>
</html>
