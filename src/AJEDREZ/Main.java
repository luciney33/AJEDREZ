package AJEDREZ;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tablero tablero = new Tablero();
        boolean turnoBlancas = true; // Empiezan las blancas

        tablero.pintarTablero();

        while (true) { // Bucle del juego
            if (turnoBlancas) {
                System.out.println("\nTurno de Blancas");
            } else {
                System.out.println("\nTurno de Negras");
            }

            System.out.println("Introduce tu movimiento (ejemplo: A2A4):");
            String input = scanner.nextLine().toUpperCase(); // Convertimos a mayúsculas

            // Si la entrada no tiene al menos 4 caracteres, mostrar error y repetir bucle
            if (input.length() < 4) {
                System.out.println("ERROR: Entrada incorrecta.");
            } else {
                // Guardamos cada parte de la jugada en variables
                char columnaInicialChar = input.charAt(0);
                char filaInicialChar = input.charAt(1);
                char columnaFinalChar = input.charAt(2);
                char filaFinalChar = input.charAt(3);

                // Convertimos letras en números para el array 8x8
                int columnaInicial = columnaInicialChar - 'A';
                int filaInicial = '8' - filaInicialChar;
                int columnaFinal = columnaFinalChar - 'A';
                int filaFinal = '8' - filaFinalChar;

                // Verificamos que haya una pieza en la posición inicial
                Pieza pieza = tablero.devuelvePieza(filaInicial, columnaInicial);
                if (pieza == null) {
                    System.out.println("ERROR: No hay pieza en la posición inicial.");
                } else {
                    // Verificamos si es el turno correcto
                    if ((pieza.getColor() && !turnoBlancas) || (!pieza.getColor() && turnoBlancas)) {
                        System.out.println("No es tu turno. Espera al otro jugador.");
                    } else {
                        // Creamos el movimiento con las posiciones convertidas
                        Movimiento mov = new Movimiento(
                                new Posicion(filaInicial, columnaInicial),
                                new Posicion(filaFinal, columnaFinal)
                        );

                        if (pieza.validoMovimiento(mov, tablero)) { // Si el movimiento es válido
                            tablero.mover(mov);
                            tablero.pintarTablero();
                            turnoBlancas = !turnoBlancas; // Cambia el turno
                        } else {
                            System.out.println("ERROR: Movimiento inválido.");
                        }
                    }
                }
            }
        }
    }
}
