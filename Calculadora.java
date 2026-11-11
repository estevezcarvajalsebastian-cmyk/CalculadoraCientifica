
package calculadoraapp;

/**
 * Clase encargada de realizar las operaciones aritmeticas.
 *
 * @author Estudiante
 */
public class Calculadora {

    /**
     * Realiza una suma.
     */
    public double sumar(double num1, double num2) {
        return num1 + num2;
    }

    /**
     * Realiza una resta.
     */
    public double restar(double num1, double num2) {
        return num1 - num2;
    }

    /**
     * Realiza una multiplicacion.
     */
    public double multiplicar(double num1, double num2) {
        return num1 * num2;
    }

    /**
     * Realiza una division.
     *
     * @throws ArithmeticException si el divisor es cero.
     */
    public double dividir(double num1, double num2) {

        if (num2 == 0) {
            throw new ArithmeticException(
                "No se puede dividir entre cero."
            );
        }

        return num1 / num2;
    }
}
