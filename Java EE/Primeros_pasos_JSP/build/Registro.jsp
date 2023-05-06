<%-- 
    Document   : Registro
    Created on : 24/04/2023, 10:18:48 a. m.
    Author     : Néstor David Heredia Gutierrez (2058558-2711)
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <h2> Usuarios Registrados </h2>
        Usuario Confirmado: <br/><br/>
        Nombre: <%=request.getParameter("nombre")%> &nbsp; Apellido: <%=request.getParameter("apellido")%>
        <br/>
        <br/>
        <jsp:include page="Fecha.jsp"></jsp:include>
    </body>
</html>
