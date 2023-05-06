package com.pildorasinformaticas.productos;

// Importamos paquetes util
import java.util.Date;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class Productos {

    private String cArt, seccion, nArt, importado, pOrigen;
    private double precio;
    private Date fecha;

    // Constructores
    public Productos(String seccion, String nArt, String importado, String pOrigen, double precio, Date fecha) {
        this.seccion = seccion;
        this.nArt = nArt;
        this.importado = importado;
        this.pOrigen = pOrigen;
        this.precio = precio;
        this.fecha = fecha;
    }

    public Productos(String cArt, String seccion, String nArt, String importado, String pOrigen, double precio, Date fecha) {
        this.cArt = cArt;
        this.seccion = seccion;
        this.nArt = nArt;
        this.importado = importado;
        this.pOrigen = pOrigen;
        this.precio = precio;
        this.fecha = fecha;
    }

    // Métodos Getter and Setter
    public String getcArt() {
        return cArt;
    }

    public void setcArt(String cArt) {
        this.cArt = cArt;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getnArt() {
        return nArt;
    }

    public void setnArt(String nArt) {
        this.nArt = nArt;
    }

    public String getImportado() {
        return importado;
    }

    public void setImportado(String importado) {
        this.importado = importado;
    }

    public String getpOrigen() {
        return pOrigen;
    }

    public void setpOrigen(String pOrigen) {
        this.pOrigen = pOrigen;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    // Metodo toString()
    @Override
    public String toString() {
        return "Productos{" + "cArt=" + cArt + ", seccion=" + seccion + ", nArt=" + nArt + ", importado=" + importado + ", pOrigen=" + pOrigen + ", precio=" + precio + ", fecha=" + fecha + '}';
    }

}
