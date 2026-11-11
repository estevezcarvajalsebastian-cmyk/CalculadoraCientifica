
package calculadoraapp;

/**
 * Clase para operaciones de raiz cuadrada y potencia.
 *
 * @author Estudiante
 */
public class RaizCuadradaExponente {

    /**
     * Calcula la raiz cuadrada de un numero.
     *
     * @throws ArithmeticException si el numero es negativo.
     */
    public double calcularRaiz(double numero) {

        if (numero < 0) {
            throw new ArithmeticException(
                "No existe una raiz cuadrada real de un numero negativo."
            );
        }

        return Math.sqrt(numero);
    }

    /**
     * Calcula una potencia.
     *
     * @param base numero que sera elevado.
     * @param exponente potencia a la que se elevara.
     * @return resultado de la potencia.
     */
    public double calcularExponente(double base, double exponente) {

        double resultado = Math.pow(base, exponente);

        if (Double.isNaN(resultado)
                || Double.isInfinite(resultado)) {

            throw new ArithmeticException(
                "El resultado no es un numero real finito."
            );
        }

        return resultado;
    }
}
