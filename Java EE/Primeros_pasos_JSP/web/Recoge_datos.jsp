<%-- 
    Document   : Recoge_datos
    Created on : 24/04/2023, 11:04:28 a. m.
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
        <%@page import="java.sql.*" %>
        <%
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String usuario = request.getParameter("usuario");
            String contra = request.getParameter("contra");
            String pais = request.getParameter("pais");
            String tecno = request.getParameter("tecnologias");
            Class.forName("com.mysql.jdbc.Driver");
            
            try{
            
            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_jsp", "root", "");
            Statement miStatement = miConexion.createStatement();
            String instruccionSql = "INSERT INTO USUARIOS (Nombre, Apellido, Uusuario, Contrasena, Pais, Tecnologias) VALUES ('" + nombre + "','" + apellido + "','" + usuario + "','" + contra + "','" + pais + "','" + tecno + "')";
            miStatement.executeUpdate(instruccionSql);
            out.println("Registrado con éxito");
            
            }catch(Exception e){
            out.println("Ha ocurrido un error");
            }
        %>
    </body>
</html>
