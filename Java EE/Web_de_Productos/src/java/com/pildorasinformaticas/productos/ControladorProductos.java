package com.pildorasinformaticas.productos;

// Importamos paquetes servlet, annotation, util, sql y io
import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
@WebServlet(name = "ControladorProductos", urlPatterns = {"/ControladorProductos"})
public class ControladorProductos extends HttpServlet {

    private ModeloProductos modeloProductos;

    @Resource(name = "jdbc/Productos")
    private DataSource miPool;

    @Override
    public void init() throws ServletException {
        super.init(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        try {
            modeloProductos = new ModeloProductos(miPool);
        } catch (Exception e) {
            throw new ServletException(e);
        }
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
            out.println("<title>Servlet ControladorProductos</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorProductos at " + request.getContextPath() + "</h1>");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Leer el parámetro del Formulario
        String elComando = request.getParameter("instruccion");

        // Si no se envía el parámetro, listar productos
        if (elComando == null) {
            elComando = "listar";
        }

        // Redirigir el flujo de ejecución al método adecuado
        switch (elComando) {
            case "listar":
                obtenerProductos(request, response);
                break;
            case "insertarBBDD":
                agregarProductos(request, response);
                break;
            case "cargar":
                try {
                cargaProductos(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
            break;
            case "actualizarBBDD":
                try {
                actualizaPeoductos(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
            break;
            case "eliminar":
                try {
                eliminarProducto(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
            break;
            default:
                obtenerProductos(request, response);
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

    private void obtenerProductos(HttpServletRequest request, HttpServletResponse response) {
        // Obtener la lista de productos desde el modelo
        List<Productos> productos;

        try {
            productos = modeloProductos.getProductos();

            // Agregar lista de productos al request
            request.setAttribute("LISTAPRODUCTOS", productos);

            // Enviar ese request a la página JSP
            RequestDispatcher miDispatcher = request.getRequestDispatcher("/ListaProductos.jsp");
            miDispatcher.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void agregarProductos(HttpServletRequest request, HttpServletResponse response) {
        // Leer la información del producto que viene del formulario
        String CodArticulo = request.getParameter("CArt");
        String Seccion = request.getParameter("seccion");
        String NombreArticulo = request.getParameter("NArt");

        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        Date Fecha = null;

        try {
            Fecha = formatoFecha.parse(request.getParameter("fecha"));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        double Precio = Double.parseDouble(request.getParameter("precio"));
        String Importado = request.getParameter("importado");
        String PaisOrigen = request.getParameter("POrigen");

        // Crear un objeto de tipo Producto
        Productos NuevoProducto = new Productos(CodArticulo, Seccion, NombreArticulo, Importado, PaisOrigen, Precio, Fecha);

        // Enviar el objeto al modelo y después insertar el objeto Producto en la BBDD
        try {
            modeloProductos.agregarElNuevoProducto(NuevoProducto);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Volver al listado de Productos
        obtenerProductos(request, response);

    }

    private void cargaProductos(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // Leer el C. Artículo que viene del listado
        String codigoArticulo = request.getParameter("CArticulo");

        // Enviar C. Artículo a modelo
        Productos elProducto = modeloProductos.getProducto(codigoArticulo);

        // Colocar atributo correspondiente al C. Artículo 
        request.setAttribute("ProductoActualizar", elProducto);

        // Enviar Producto al formulario de actualizar (jsp)
        RequestDispatcher dispatcher = request.getRequestDispatcher("/actualizarProducto.jsp");
        dispatcher.forward(request, response);

    }

    private void actualizaPeoductos(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // Leer los datos que le vienen al formulario actualizar 
        String CodArticulo = request.getParameter("CArt");
        String Seccion = request.getParameter("seccion");
        String NombreArticulo = request.getParameter("NArt");

        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        Date Fecha = null;

        try {
            Fecha = formatoFecha.parse(request.getParameter("fecha"));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        double Precio = Double.parseDouble(request.getParameter("precio"));
        String Importado = request.getParameter("importado");
        String PaisOrigen = request.getParameter("POrigen");

        // Crear un objeto de tipo Producto con la info del formulario
        Productos ProductoActualizado = new Productos(CodArticulo, Seccion, NombreArticulo, Importado, PaisOrigen, Precio, Fecha);

        // Actualizar la BBDD con la info del obj. Producto
        modeloProductos.actualizarProducto(ProductoActualizado);

        // Volver al listado con la info actualizada
        obtenerProductos(request, response);

    }

    private void eliminarProducto(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // Capturar el Código Artículo
        String CodArticulo = request.getParameter("CArticulo");

        // Borrar Producto de la BBDD
        modeloProductos.eliminarProducto(CodArticulo);

        // Volver a  la lista de productos
        obtenerProductos(request, response);

    }

}
