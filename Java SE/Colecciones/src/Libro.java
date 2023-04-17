
/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class Libro {

    private String titulo, autor;
    private int ISBN;

    public Libro(String titulo, String autor, int ISBN) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
    }

    public String getDatos() {
        return "El Título es: " + titulo + ". El Autor es : " + autor + ". Y el ISBN es : " + ISBN;
    }

    /*@Override
    public boolean equals(Object obj) {

        if (obj instanceof Libro) {

            Libro otro = (Libro) obj;

            if (this.ISBN == otro.ISBN) {
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }

    }*/
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.ISBN;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Libro other = (Libro) obj;
        return this.ISBN == other.ISBN;
    }

}
