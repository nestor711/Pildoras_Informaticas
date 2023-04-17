
// Importamos paquetes util
import java.util.Comparator;
import java.util.TreeSet;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class Prueba_TreeSet {

    public static void main(String[] args) {

        /*TreeSet<String> ordenaPersonas = new TreeSet<String>();
        ordenaPersonas.add("Laura");
        ordenaPersonas.add("Anny");
        ordenaPersonas.add("Diana");

        for (String s : ordenaPersonas) {
            System.out.println(s);
        }*/
        
        Articulo primero = new Articulo(1, "Primer Artículo");
        Articulo segundo = new Articulo(2, "Segundo Artículo");
        Articulo tercero = new Articulo(3, "Tercer Artículo");

        TreeSet<Articulo> ordenaArticulos = new TreeSet<Articulo>();
        ordenaArticulos.add(tercero);
        ordenaArticulos.add(primero);
        ordenaArticulos.add(segundo);

        for (Articulo art : ordenaArticulos) {
            System.out.println(art.getDescripcion());
        }

        //Articulo comparadorArticulos = new Articulo();
        //TreeSet<Articulo> ordenaArticulos2 = new TreeSet<Articulo>(comparadorArticulos);
        //ComparadorArticulos compara_art = new ComparadorArticulos();
        TreeSet<Articulo> ordenaArticulos2 = new TreeSet<Articulo>(new Comparator<Articulo>() {

            @Override
            public int compare(Articulo o1, Articulo o2) {
                String desc1 = o1.getDescripcion();
                String desc2 = o2.getDescripcion();
                return desc1.compareTo(desc2);
            }

        });

        ordenaArticulos2.add(primero);
        ordenaArticulos2.add(segundo);
        ordenaArticulos2.add(tercero);

        for (Articulo art : ordenaArticulos2) {
            System.out.println(art.getDescripcion());
        }
    }

}

class Articulo implements Comparable<Articulo> {

    private int numero_articulo;
    private String descripcion;

    //public Articulo() {
    //}
    public Articulo(int num, String desc) {
        numero_articulo = num;
        descripcion = desc;
    }

    @Override
    public int compareTo(Articulo o) {
        return numero_articulo - o.numero_articulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    /*@Override
    public int compare(Articulo o1, Articulo o2) {

        String descripcionA = o1.getDescripcion();
        String descripcionB = o2.getDescripcion();

        return descripcionA.compareTo(descripcionB);
    }*/
}

/*class ComparadorArticulos implements Comparator<Articulo> {

    @Override
    public int compare(Articulo o1, Articulo o2) {
        String desc1 = o1.getDescripcion();
        String desc2 = o2.getDescripcion();
        return desc1.compareTo(desc2);
    }

}*/
