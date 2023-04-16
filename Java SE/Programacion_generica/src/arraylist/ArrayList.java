package arraylist;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class ArrayList {

    private Object[] datosElemento;
    private int i = 0;

    public ArrayList(int z) {
        datosElemento = new Object[z];
    }

    public Object get(int i) {
        return datosElemento[i];
    }

    public void add(Object o) {
        datosElemento[i] = o;
        i++;
    }

}
