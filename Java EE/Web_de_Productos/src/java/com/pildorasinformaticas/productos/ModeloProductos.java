package com.pildorasinformaticas.productos;

// Importamos paquetes sql y util
import java.sql.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class ModeloProductos {

    private DataSource origenDatos;

    // Constructor
    public ModeloProductos(DataSource origenDatos) {

        this.origenDatos = origenDatos;

    }

    // Método que devuelve los productos en una lista
    public List<Productos> getProductos() throws Exception {

        List<Productos> productos = new ArrayList<>();

        Connection miConexion = null;
        Statement miStatement = null;
        ResultSet miResulSet = null;

        // Establecer la Conexión
        miConexion = origenDatos.getConnection();

        // Crear sentencia SQL y Statement
        String instruccionSql = "SELECT * FROM PRODUCTOS";
        miStatement = miConexion.createStatement();

        // Ejecutar SQL
        miResulSet = miStatement.executeQuery(instruccionSql);

        // Recorrer el Resulset Obtenido
        while (miResulSet.next()) {
            String c_art = miResulSet.getString("CÓDIGOARTÍCULO");
            String seccion = miResulSet.getString("SECCIÓN");
            String n_art = miResulSet.getString("NOMBREARTÍCULO");
            double precio = miResulSet.getDouble("PRECIO");
            Date fecha = miResulSet.getDate("FECHA");
            String importado = miResulSet.getString("IMPORTADO");
            String p_orig = miResulSet.getString("PAÍSDEORIGEN");

            Productos temProd = new Productos(c_art, seccion, n_art, importado, p_orig, precio, fecha);

            productos.add(temProd);

        }

        return productos;

    }

    void agregarElNuevoProducto(Productos NuevoProducto) throws Exception {
        Connection miConexion = null;
        PreparedStatement miStatement = null;

        // Obtener la conexión
        try {
            miConexion = origenDatos.getConnection();

            // Crear la instrucción SQL que inserte el producto. Crear la consulta preparada (statement)
            String sql = "INSERT INTO PRODUCTOS (CÓDIGOARTÍCULO, SECCIÓN, NOMBREARTÍCULO, PRECIO, FECHA, IMPORTADO, PAÍSDEORIGEN)"
                    + "VALUES(?,?,?,?,?,?,?)";
            miStatement = miConexion.prepareStatement(sql);

            // Establecer los parámetros para el producto
            miStatement.setString(1, NuevoProducto.getcArt());
            miStatement.setString(2, NuevoProducto.getSeccion());
            miStatement.setString(3, NuevoProducto.getnArt());
            miStatement.setDouble(4, NuevoProducto.getPrecio());

            // Convertir la fecha
            java.util.Date utilDate = NuevoProducto.getFecha();
            java.sql.Date fechaConvertida = new java.sql.Date(utilDate.getTime());

            miStatement.setDate(5, fechaConvertida);
            miStatement.setString(6, NuevoProducto.getImportado());
            miStatement.setString(7, NuevoProducto.getpOrigen());

            // Ejecutar la instrucción SQL
            miStatement.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            miStatement.close();
            miConexion.close();
        }
    }

    Productos getProducto(String codigoArticulo) {
        Productos elProducto = null;
        Connection miConexion = null;
        PreparedStatement miStatement = null;
        ResultSet miResulSet = null;
        String cArticulo = codigoArticulo;

        try {
            // Establecer la Conexión con la BBDD
            miConexion = origenDatos.getConnection();

            // Crear SQL que busque el producto
            String sql = "SELECT * FROM PRODUCTOS WHERE CÓDIGOARTÍCULO = ?";

            // Crear la consulta preparada
            miStatement = miConexion.prepareStatement(sql);

            // Establecer los parámetros
            miStatement.setString(1, cArticulo);

            // Ejecutar la consulta
            miResulSet = miStatement.executeQuery();

            // Obtener los datos de respuesta
            if (miResulSet.next()) {
                String c_art = miResulSet.getString("CÓDIGOARTÍCULO");
                String seccion = miResulSet.getString("SECCIÓN");
                String n_art = miResulSet.getString("NOMBREARTÍCULO");
                double precio = miResulSet.getDouble("PRECIO");
                Date fecha = miResulSet.getDate("FECHA");
                String importado = miResulSet.getString("IMPORTADO");
                String p_orig = miResulSet.getString("PAÍSDEORIGEN");

                elProducto = new Productos(c_art, seccion, n_art, importado, p_orig, precio, fecha);
            } else {
                throw new Exception("No hemos encontrado el producto con código artículo = " + cArticulo);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return elProducto;
    }

    void actualizarProducto(Productos ProductoActualizado) throws Exception {
        Connection miConexion = null;
        PreparedStatement miStatement = null;

        // Establecer la conexión 
        try {
            miConexion = origenDatos.getConnection();

            // Crear la sentencia SQL
            String sql = "UPDATE PRODUCTOS SET SECCION = ?, NOMBREARTÍCULO = ?, PRECIO = ?, FECHA = ?, IMPORTADO = ?, PAÍSDEORIGEN = ? WHERE CÓDIGOARTÍCULO = ?";

            // Crear la consulta preparada
            miStatement = miConexion.prepareStatement(sql);

            // Establecer los parámetos
            miStatement.setString(1, ProductoActualizado.getSeccion());
            miStatement.setString(2, ProductoActualizado.getnArt());
            miStatement.setDouble(3, ProductoActualizado.getPrecio());

            java.util.Date utilDate = ProductoActualizado.getFecha();
            java.sql.Date fechaConvertida = new java.sql.Date(utilDate.getTime());

            miStatement.setDate(4, fechaConvertida);
            miStatement.setString(5, ProductoActualizado.getImportado());
            miStatement.setString(6, ProductoActualizado.getpOrigen());
            miStatement.setString(7, ProductoActualizado.getcArt());

            // Ejecutar la instrucción SQL
            miStatement.execute();
        } finally {
            miStatement.close();
            miConexion.close();
        }

    }

    void eliminarProducto(String CodArticulo) throws Exception {
        Connection miConexion = null;
        PreparedStatement miStatement = null;

        // Establecer la Conexión con la BBDD
        try {
            miConexion = origenDatos.getConnection();

            // Crear instrucción SQL de Eliminación
            String sql = "DELETE FROM PRODUCTOS WHERE CÓDIGOARTÍCULO = ?";

            // Preparar la Consulta
            miStatement = miConexion.prepareStatement(sql);

            // Establecer parámetros de consulta
            miStatement.setString(1, CodArticulo);

            // Ejecutar sentencia SQL
            miStatement.execute();

        } finally {
            miStatement.close();
            miConexion.close();
        }

    }

}
