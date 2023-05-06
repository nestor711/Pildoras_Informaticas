<%-- 
    Document   : ListaProductos
    Created on : 28/04/2023, 10:28:13 a. m.
    Author     : Néstor David Heredia Gutierrez (2058558-2711)
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%-- <%@page import="java.util.* , com.pildorasinformaticas.productos.*" %>--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page - Productos</title>
        <style type="text/css">
            .cabecera{
                font-size: 1.2em;
                font-weight: bold;
                color: #FFFFFF;
                background-color: #08088A;
            }

            .filas{
                text-align: center;
                background-color: #5882FA;
            }
            table{
                float: left;
            }
            #contenedorBoton{
                margin-left: 1000px;
            }
        </style>
    </head>
    <%-- <%
        // Obtiene los productos del controlador (Servlet)
        List<Productos> losProductos = (List<Productos>) request.getAttribute("LISTAPRODUCTOS");
    %>--%>
    <body>
        <%-- <%= losProductos %>--%>
        <table>
            <tr>
                <td class="cabecera">Código Artículo</td>
                <td class="cabecera">Sección</td>
                <td class="cabecera">Nombre Artículo</td>
                <td class="cabecera">Fecha</td>
                <td class="cabecera">Precio</td>
                <td class="cabecera">Importado</td>
                <td class="cabecera">País de Origen</td>
                <td class="cabecera">Acción</td>
            </tr>
            <%--<% for(Productos tempProd : losProductos ){ %>--%>
            <c:forEach var="tempProd" items="${LISTAPRODUCTOS}">

                <!-- Link para cada producto con su campo clave  -->
                <c:url var="linkTemp" value="ControladorProductos">
                    <c:param name="instruccion" value="cargar"></c:param>
                    <c:param name="CArticulo" value="${tempProd.cArt}"></c:param>
                </c:url>

                <!-- Link para eliminar cada registro con su campo clave -->
                <c:url var="linkTempEliminar" value="ControladorProductos">
                    <c:param name="instruccion" value="eliminar"></c:param>
                    <c:param name="CArticulo" value="${tempProd.cArt}"></c:param>
                </c:url>

                <tr>
                    <td class ="filas">${tempProd.cArt}</td>
                    <td class ="filas">${tempProd.seccion}</td>
                    <td class ="filas">${tempProd.nArt}</td>
                    <td class ="filas">${tempProd.fecha}</td>
                    <td class ="filas">${tempProd.precio}</td>
                    <td class ="filas">${tempProd.importado}</td>
                    <td class ="filas">${tempProd.pOrigen}</td> 
                    <td class ="filas"><a href="${linkTemp}">Actualizar</a>&nbsp;<a href="${linkTempEliminar}">Eliminar</a></td>   
                </tr>
                <%--<% }%>--%>
            </c:forEach>
        </table>
        <div id="contenedorBoton">
            <input type="button" value="Insertar Registro" onclick="window.location.href = 'inserta_producto.jsp'"/>
        </div>
    </body>
</html>
