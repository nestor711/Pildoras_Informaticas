<%-- 
    Document   : inserta_producto
    Created on : 4/05/2023, 8:24:02 p. m.
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
        <h1 style="text-align: center">Actualizar Producto</h1>
        <form name="form1" method="get" action="ControladorProductos">
            <input type="hidden" name="instruccion" value="actualizarBBDD">

            <input type="hidden" name="CArt" value="${ProductoActualizar.cArt}">

            <table width="50%" border="0">
                <!--  <tr>
                    <td width="27%">Código Artículo</td>
                    <td width="73%"><label for="CArt"></label>
                        <input type="text" name="CArt" id="CArt"></td>
                </tr>-->
                <tr>
                    <td>Sección</td>
                    <td><label for="seccion"></label>
                        <input type="text" name="seccion" id="seccion" value="${ProductoActualizar.seccion}"></td>
                </tr>
                <tr>
                    <td>Nombre Artículo</td>
                    <td><label for="NArt"></label>
                        <input type="text" name="NArt" id="NArt" value="${ProductoActualizar.nArt}"></td>
                </tr>
                <tr>
                    <td>Fecha</td>
                    <td><label for="fecha"></label>
                        <input type="text" name="fecha" id="fecha" value="${ProductoActualizar.fecha}"></td>
                </tr>
                <tr>
                    <td>Precio</td>
                    <td><label for="precio"></label>
                        <input type="text" name="precio" id="precio" value="${ProductoActualizar.precio}"></td>
                </tr>
                <tr>
                    <td>Importado</td>
                    <td><label for="importado"></label>
                        <input type="text" name="importado" id="importado" value="${ProductoActualizar.importado}"></td>
                </tr>
                <tr>
                    <td>País de Origen</td>
                    <td><label for="POrigen"></label>
                        <input type="text" name="POrigen" id="POrigen" value="${ProductoActualizar.pOrigen}"></td>
                </tr>
                <tr>
                    <td><input type="submit" name="envio" id="envio" value="Enviar"></td>
                    <td><input type="reset" name="borrar" id="borrar" value="Restablecer"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
