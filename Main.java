
package calculadoraapp;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

/**
 * Clase principal que contiene la interfaz grafica
 * de la calculadora cientifica.
 *
 * @author Estudiante
 */
public class Main extends JFrame {

    // Objetos de las clases de operaciones.
    private final Calculadora calculadora = new Calculadora();
    private final ConversorTemperatura conversor =
            new ConversorTemperatura();
    private final RaizCuadradaExponente matematicas =
            new RaizCuadradaExponente();

    // Formato para mostrar los resultados.
    private final DecimalFormat formato =
            new DecimalFormat("#,##0.####");

    // Componentes de la calculadora.
    private JTextField txtNumero1;
    private JTextField txtNumero2;
    private JLabel lblResultadoCalculadora;

    // Componentes del conversor.
    private JTextField txtTemperatura;
    private JLabel lblResultadoTemperatura;

    // Componentes de raiz y potencia.
    private JTextField txtNumero;
    private JTextField txtExponente;
    private JLabel lblResultadoMatematico;

    /**
     * Constructor de la ventana principal.
     */
    public Main() {

        setTitle("Calculadora Cientifica");
        setSize(600, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Panel de pestañas.
        JTabbedPane pestañas = new JTabbedPane();

        pestañas.addTab("Calculadora", crearPanelCalculadora());
        pestañas.addTab("Conversor", crearPanelConversor());
        pestañas.addTab("Raiz y Potencia", crearPanelMatematico());

        add(pestañas);

    }

    /**
     * Crea la interfaz de las operaciones aritmeticas.
     */
    private JPanel crearPanelCalculadora() {

        JPanel panel = new JPanel(new GridLayout(0, 2, 12, 15));
        panel.setBorder(
                BorderFactory.createEmptyBorder(30, 35, 30, 35)
        );

        JLabel titulo = new JLabel("OPERACIONES ARITMETICAS");
        titulo.setFont(new Font("Arial", Font.BOLD, 19));

        txtNumero1 = new JTextField();
        txtNumero2 = new JTextField();

        lblResultadoCalculadora = new JLabel(
                "Resultado: --"
        );

        JButton btnSumar = new JButton("Sumar (+)");
        JButton btnRestar = new JButton("Restar (-)");
        JButton btnMultiplicar = new JButton("Multiplicar (*)");
        JButton btnDividir = new JButton("Dividir (/)");

        panel.add(titulo);
        panel.add(new JLabel(""));

        panel.add(new JLabel("Primer numero:"));
        panel.add(txtNumero1);

        panel.add(new JLabel("Segundo numero:"));
        panel.add(txtNumero2);

        panel.add(btnSumar);
        panel.add(btnRestar);

        panel.add(btnMultiplicar);
        panel.add(btnDividir);

        panel.add(new JLabel(""));

        panel.add(lblResultadoCalculadora);

        // Acciones de los botones.
        btnSumar.addActionListener(e -> operar("sumar"));
        btnRestar.addActionListener(e -> operar("restar"));
        btnMultiplicar.addActionListener(e -> operar("multiplicar"));
        btnDividir.addActionListener(e -> operar("dividir"));

        return panel;
    }

    /**
     * Ejecuta la operacion aritmetica seleccionada.
     */
    private void operar(String operacion) {

        try {

            double numero1 = Double.parseDouble(
                    txtNumero1.getText().trim()
            );

            double numero2 = Double.parseDouble(
                    txtNumero2.getText().trim()
            );

            double resultado;

            switch (operacion) {

                case "sumar":
                    resultado = calculadora.sumar(numero1, numero2);
                    break;

                case "restar":
                    resultado = calculadora.restar(numero1, numero2);
                    break;

                case "multiplicar":
                    resultado = calculadora.multiplicar(numero1, numero2);
                    break;

                case "dividir":
                    resultado = calculadora.dividir(numero1, numero2);
                    break;

                default:
                    return;
            }

            lblResultadoCalculadora.setForeground(
                    new Color(0, 128, 0)
            );

            lblResultadoCalculadora.setText(
                    "Resultado: " + formato.format(resultado)
            );

        } catch (NumberFormatException ex) {

            mostrarError("Introduzca dos numeros validos.");

        } catch (ArithmeticException ex) {

            mostrarError(ex.getMessage());
        }
    }

    /**
     * Crea la interfaz del conversor de temperatura.
     */
    private JPanel crearPanelConversor() {

        JPanel panel = new JPanel(new GridLayout(0, 2, 12, 18));

        panel.setBorder(
                BorderFactory.createEmptyBorder(45, 35, 45, 35)
        );

        JLabel titulo = new JLabel("CONVERSOR DE TEMPERATURA");
        titulo.setFont(new Font("Arial", Font.BOLD, 18));

        txtTemperatura = new JTextField();

        lblResultadoTemperatura = new JLabel(
                "Resultado: --"
        );

        JButton btnACelsius = new JButton(
                "Fahrenheit a Celsius"
        );

        JButton btnAFahrenheit = new JButton(
                "Celsius a Fahrenheit"
        );

        panel.add(titulo);
        panel.add(new JLabel(""));

        panel.add(new JLabel("Temperatura:"));
        panel.add(txtTemperatura);

        panel.add(btnACelsius);
        panel.add(btnAFahrenheit);

        panel.add(new JLabel(""));

        panel.add(lblResultadoTemperatura);

        btnACelsius.addActionListener(
                e -> convertirTemperatura(true)
        );

        btnAFahrenheit.addActionListener(
                e -> convertirTemperatura(false)
        );

        return panel;
    }

    /**
     * Realiza las conversiones de temperatura.
     *
     * @param aCelsius true para Fahrenheit a Celsius.
     *                 false para Celsius a Fahrenheit.
     */
    private void convertirTemperatura(boolean aCelsius) {

        try {

            double temperatura = Double.parseDouble(
                    txtTemperatura.getText().trim()
            );

            double resultado;

            if (aCelsius) {

                resultado = conversor.fahrenheitACelsius(temperatura);

                lblResultadoTemperatura.setText(
                        formato.format(resultado) + " °C"
                );

            } else {

                resultado = conversor.celsiusAFahrenheit(temperatura);

                lblResultadoTemperatura.setText(
                        formato.format(resultado) + " °F"
                );
            }

        } catch (NumberFormatException ex) {

            mostrarError("Introduzca una temperatura valida.");
        }
    }

    /**
     * Crea la interfaz para raiz cuadrada y potencia.
     */
    private JPanel crearPanelMatematico() {

        JPanel panel = new JPanel(new GridLayout(0, 2, 12, 15));

        panel.setBorder(
                BorderFactory.createEmptyBorder(30, 35, 30, 35)
        );

        JLabel titulo = new JLabel("OPERACIONES MATEMATICAS");
        titulo.setFont(new Font("Arial", Font.BOLD, 18));

        txtNumero = new JTextField();
        txtExponente = new JTextField();

        lblResultadoMatematico = new JLabel(
                "Resultado: --"
        );

        JButton btnRaiz = new JButton("Raiz cuadrada");
        JButton btnPotencia = new JButton("Calcular potencia");

        panel.add(titulo);
        panel.add(new JLabel(""));

        panel.add(new JLabel("Numero / Base:"));
        panel.add(txtNumero);

        panel.add(new JLabel("Exponente:"));
        panel.add(txtExponente);

        panel.add(btnRaiz);
        panel.add(btnPotencia);

        panel.add(new JLabel(""));
        panel.add(lblResultadoMatematico);

        btnRaiz.addActionListener(e -> calcularRaiz());

        btnPotencia.addActionListener(e -> calcularPotencia());

        return panel;
    }

    /**
     * Calcula la raiz cuadrada del numero introducido.
     */
    private void calcularRaiz() {

        try {

            double numero = Double.parseDouble(
                    txtNumero.getText().trim()
            );

            double resultado = matematicas.calcularRaiz(numero);

            lblResultadoMatematico.setText(
                    "Resultado: " + formato.format(resultado)
            );

        } catch (NumberFormatException ex) {

            mostrarError("Introduzca un numero valido.");

        } catch (ArithmeticException ex) {

            mostrarError(ex.getMessage());
        }
    }

    /**
     * Calcula una potencia utilizando base y exponente.
     */
    private void calcularPotencia() {

        try {

            double base = Double.parseDouble(
                    txtNumero.getText().trim()
            );

            double exponente = Double.parseDouble(
                    txtExponente.getText().trim()
            );

            double resultado = matematicas.calcularExponente(
                    base, exponente
            );

            lblResultadoMatematico.setText(
                    "Resultado: " + formato.format(resultado)
            );

        } catch (NumberFormatException ex) {

            mostrarError("Introduzca la base y el exponente.");

        } catch (ArithmeticException ex) {

            mostrarError(ex.getMessage());
        }
    }

    /**
     * Muestra mensajes de error al usuario.
     */
    private void mostrarError(String mensaje) {

        JOptionPane.showMessageDialog(
                this,
                mensaje,
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }

    /**
     * Punto de entrada de la aplicacion.
     */
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            Main ventana = new Main();
            ventana.setVisible(true);

        });
    }
}
