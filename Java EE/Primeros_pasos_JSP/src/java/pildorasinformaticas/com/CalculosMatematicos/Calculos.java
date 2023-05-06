package pildorasinformaticas.com.CalculosMatematicos;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class Calculos {

    private static int resultado;

    public static int metodoSuma(int num1, int num2) {
        resultado = num1 + num2;
        return resultado;
    }

    public static int metodoResta(int num1, int num2) {
        resultado = num1 - num2;
        return resultado;
    }

    public static int metodoMultiplica(int num1, int num2) {
        resultado = num1 * num2;
        return resultado;
    }

}
