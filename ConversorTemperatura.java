
package calculadoraapp;

/**
 * Clase encargada de convertir temperaturas.
 *
 * @author Estudiante
 */
public class ConversorTemperatura {

    /**
     * Convierte Fahrenheit a Celsius.
     *
     * @param fahrenheit temperatura en Fahrenheit.
     * @return temperatura en Celsius.
     */
    public double fahrenheitACelsius(double fahrenheit) {

        return (fahrenheit - 32) * 5 / 9;
    }

    /**
     * Convierte Celsius a Fahrenheit.
     *
     * @param celsius temperatura en Celsius.
     * @return temperatura en Fahrenheit.
     */
    public double celsiusAFahrenheit(double celsius) {

        return (celsius * 9 / 5) + 32;
    }
}
