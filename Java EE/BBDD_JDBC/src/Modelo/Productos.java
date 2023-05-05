package Modelo;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class Productos {

    private String nArticulo, seccion, precio, pOrigen;

    public Productos() {
        nArticulo = "";
        seccion = "";
        precio = "";
        pOrigen = "";
    }

    public Productos(String nArticulo, String seccion, String precio, String pOrigen) {
        this.nArticulo = nArticulo;
        this.seccion = seccion;
        this.precio = precio;
        this.pOrigen = pOrigen;
    }

    public String getnArticulo() {
        return nArticulo;
    }

    public void setnArticulo(String nArticulo) {
        this.nArticulo = nArticulo;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getpOrigen() {
        return pOrigen;
    }

    public void setpOrigen(String pOrigen) {
        this.pOrigen = pOrigen;
    }

}
