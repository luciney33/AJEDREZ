package AJEDREZ;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tablero tablero = new Tablero();
        boolean turnoBlancas = true; // Empiezan las blancas
        boolean seguirJugando = true; // Variable para controlar si el juego continúa
        String mensaje; // Almacena el mensaje del turno

        tablero.pintarTablero();

        while (seguirJugando) { // Bucle del juego
            if (turnoBlancas) {
                mensaje = "\nTurno de Blancas";
            } else {
                mensaje = "\nTurno de Negras";
            }
            System.out.println(mensaje);
            System.out.println("Introduce tu movimiento (ejemplo: A2A4) o escribe RENDIRSE o EMPATE:");

            String entrada = scanner.nextLine().toUpperCase(); // Convertimos a mayúsculas
            mensaje = ""; // Reseteamos el mensaje

            //  rendirse
            if (entrada.length() == 8 && entrada.charAt(0) == 'R' && entrada.charAt(1) == 'E' &&
                    entrada.charAt(2) == 'N' && entrada.charAt(3) == 'D' && entrada.charAt(4) == 'I' &&
                    entrada.charAt(5) == 'R' && entrada.charAt(6) == 'S' && entrada.charAt(7) == 'E') {

                if (turnoBlancas) {
                    System.out.println("Las blancas se han rendido. ¡Negras ganan!");
                } else {
                    System.out.println("Las negras se han rendido. ¡Blancas ganan!");
                }
                seguirJugando = false;
            }
            // empate
            else if (entrada.length() == 6 && entrada.charAt(0) == 'T' && entrada.charAt(1) == 'A' &&
                    entrada.charAt(2) == 'B' && entrada.charAt(3) == 'L' && entrada.charAt(4) == 'A' &&
                    entrada.charAt(5) == 'S') {
                System.out.println("¡Empate acordado! Fin del juego.");
                seguirJugando = false;
            }
            // Validación del movimiento
            else if (entrada.length() == 4) {
                char columnaInicialChar = entrada.charAt(0);
                char filaInicialChar = entrada.charAt(1);
                char columnaFinalChar = entrada.charAt(2);
                char filaFinalChar = entrada.charAt(3);

                // Verificar si las letras son válidas (A-H) y los números (1-8)
                if ((columnaInicialChar >= 'A' && columnaInicialChar <= 'H') &&
                        (columnaFinalChar >= 'A' && columnaFinalChar <= 'H') &&
                        (filaInicialChar >= '1' && filaInicialChar <= '8') &&
                        (filaFinalChar >= '1' && filaFinalChar <= '8')) {

                    int columnaInicial = columnaInicialChar - 'A';
                    int filaInicial = 8 - (filaInicialChar - '1') - 1;
                    int columnaFinal = columnaFinalChar - 'A';
                    int filaFinal = 8 - (filaFinalChar - '1') - 1;

                    Pieza pieza = tablero.devuelvePieza(filaInicial, columnaInicial);

                    if (pieza != null) {
                        if ((pieza.getColor() && turnoBlancas) || (!pieza.getColor() && !turnoBlancas)) {
                            Movimiento mov = new Movimiento(
                                    new Posicion(filaInicial, columnaInicial),
                                    new Posicion(filaFinal, columnaFinal)
                            );

                            if (pieza.validoMovimiento(mov, tablero)) {
                                tablero.mover(mov);
                                tablero.pintarTablero();
                                turnoBlancas = !turnoBlancas; // Cambiar turno
                            } else {
                                mensaje = "ERROR: Movimiento inválido.";
                            }
                        } else {
                            mensaje = "ERROR: No es tu turno.";
                        }
                    } else {
                        mensaje = "ERROR: No hay pieza en la posición inicial.";
                    }
                } else {
                    mensaje = "ERROR: Movimiento fuera de los límites del tablero.";
                }
            } else {
                mensaje = "ERROR: Entrada incorrecta. Debe tener 4 caracteres.";
            }

            if (mensaje.length() > 0) {
                System.out.println(mensaje);
            }
        }
        scanner.close();
    }
}


