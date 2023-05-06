<%-- 
    Document   : RecorreEmpleados
    Created on : 24/04/2023, 4:56:14 p. m.
    Author     : Néstor David Heredia Gutierrez (2058558-2711)
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.*, java.sql.*, pildorasinformaticas.com.jsptags.Empleado" %>

<%
    ArrayList<Empleado> datos = new ArrayList<>();
    
    Class.forName("com.mysql.Driver");
    
    try{
        Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_jsp","root","");
        
        Statement miStatement = miConexion.createStatement();
        
        String instruccionSql = "SELECT * FROM EMPLEADOS";
        
        ResulSet rs = miStatement.executeQuery(instruccionSql);
        // Bucle while
        while(rs.next()){
            datos.add(new Empleado(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4)));
        }
        rs.close();
        
        miConexion.close();
        
    }catch(Exception e){
        out.println("Ha habido un error");
    }
    
    pageContext.setAttribute("losEmpleados", datos);
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .cabecera{
                font-weight: bold;
            }
        </style>
    </head>
    <body>
        <table border="1">
            <tr class="cabecera"><td>Nombre</td><td>Apellido</td><td>Puesto</td><td>Salario</td></tr>
            <c:forEach var="EmpTemp" items="${losEmpleados}">
                <tr>
                    <td>${EmpTemp.nombre}</td><td>${EmpTemp.apellido}</td><td>${EmpTemp.puesto}</td><td>

                        <c:choose>
                            <c:when test="${EmpTemp.salario<40000}">
                                ${EmpTemp.salario + 5000}
                            </c:when>
                            <c:when test="${EmpTemp.salario>40000 && EmpTemp.salario<=50000}">
                                ${EmpTemp.salario + 2000}
                            </c:when>
                            <c:otherwise>
                                ${EmpTemp.salario}
                            </c:otherwise>
                        </c:choose>

                        <%/*<c:if test="${EmpTemp.salario<40000}">
                            ${EmpTemp.salario + 5000}
                        </c:if>
                        <c:if test="${EmpTemp.salario>=40000}">
                            ${EmpTemp.salario}
                        </c:if>*/%>
                    </td>

                    <%/*<td><c:if test="${EmpTemp.salario < 40000}">5000</c:if>
                        <c:if test="${EmpTemp.salario >= 40000}">-----</c:if>
                        </td>*/%>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
