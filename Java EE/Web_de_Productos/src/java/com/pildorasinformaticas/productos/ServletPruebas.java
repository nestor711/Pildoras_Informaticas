package com.pildorasinformaticas.productos;

// Importamos paquetes servlet, sql, annotacion y io
import java.sql.*;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import org.apache.tomcat.jdbc.pool.DataSource;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
@WebServlet(name = "ServletPruebas", urlPatterns = {"/ServletPruebas"})
public class ServletPruebas extends HttpServlet {

    // Definir o establecer el DataSource
    @Resource(name = "jdbc/Productos")
    private DataSource miPool;

    public ServletPruebas() {
        super();
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletPruebas</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletPruebas at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Crear el Objeto printWritter
        PrintWriter salida = response.getWriter();
        response.setContentType("text/plain");

        // Crear conexión con BBDD
        Connection miConexion = null;
        Statement miStatement = null;
        ResultSet miResultSet = null;

        try {

            miConexion = miPool.getConnection();

            String miSql = "SELECT * FROM PRODUCTOS";

            miStatement = miConexion.createStatement();

            miResultSet = miStatement.executeQuery(miSql);

            while (miResultSet.next()) {
                String nombre_articulo = miResultSet.getString(3);
                salida.println(nombre_articulo);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
