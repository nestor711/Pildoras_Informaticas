<%-- 
    Document   : Comprueba_Usuario
    Created on : 24/04/2023, 11:37:54 a. m.
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
            String usuario = request.getParameter("usuario");
            String contra = request.getParameter("contra");
            Class.forName("com.mysql.jdbc.Driver");
            try{
            
            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_jsp", "root", "");
            PreparedStatement c_preparada = miConexion.prepareStatement("SELECT * FROM USUARIOS WHERE USUARIO=? AND CONTRASENA=?");
            c_preparada.setString(1, usuario);
            c_preparada.setString(2, contra);
            
            ResulSet miResultSet = c_preparada.executeQuery();
            
            if(miResultSet.absolute(1)){
            out.println("Usuario Autorizado");
            }else{
            out.println("No hay usuarios con esos datos");
            }
            
            }catch(Exception e){
            out.println("Ha ocurrido un error");
            }
        %>
    </body>
</html>
