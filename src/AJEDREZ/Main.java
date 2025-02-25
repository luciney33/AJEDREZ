package AJEDREZ;
import java.util.Scanner;

/**
 * Clase principal que gestiona la ejecución del juego de ajedrez.
 * Permite a los jugadores introducir movimientos, realizar una partida, rendirse o proponer un empate.
 */
public class Main {

    /**
     * Método principal que ejecuta el juego de ajedrez. Gestiona el turno de los jugadores,
     * permite realizar movimientos, y maneja las condiciones de empate o rendición.
     *
     */
    public static void main(String[] args) {
        Scanner lect = new Scanner(System.in);
        Tablero tablero = new Tablero(); // Crea un nuevo tablero de ajedrez
        boolean turnoBlancas = true; // Las blancas comienzan el juego
        boolean seguirJugando = true; // Variable para controlar si el juego continúa
        String mensaje; // Almacena el mensaje del turno o error

        tablero.pintarTablero(); // Muestra el tablero inicial

        // Bucle principal del juego que se ejecuta mientras se desee seguir jugando
        while (seguirJugando) {
            // Mensaje que indica de quién es el turno
            if (turnoBlancas) {
                mensaje = "\nTurno de Blancas";
            } else {
                mensaje = "\nTurno de Negras";
            }
            System.out.println(mensaje);
            System.out.println("Introduce tu movimiento (ejemplo: A2A4) o escribe RENDIRSE o EMPATE:");

            String entrada = lect.nextLine().toUpperCase(); // Lee el movimiento o comando
            mensaje = ""; // Resetea el mensaje

            // Comprobación de si el jugador quiere proponer un empate
            if (entrada.equals("EMPATE")) { // Empate
                System.out.println("El jugador ha propuesto un empate. ¿Aceptas? (S/N)");
                char respuesta = lect.next().toUpperCase().charAt(0);
                if (respuesta == 'S') {
                    System.out.println("Partida terminada en empate");
                    break; // Termina el juego si se acepta el empate
                }
                System.out.println("El oponente ha rechazado el empate. La partida continúa.");
            }
            // Comprobación de si el jugador quiere rendirse
            else if (entrada.equals("RENDIRSE")) { // Rendir
                System.out.println("El jugador se ha rendido. Fin de la partida!!!");
                break; // Termina el juego si un jugador se rinde
            }
            // Verifica si la entrada es un movimiento válido
            else if (entrada.length() == 4) {
                // Extrae las posiciones iniciales y finales del movimiento
                char columnaInicialChar = entrada.charAt(0);
                char filaInicialChar = entrada.charAt(1);
                char columnaFinalChar = entrada.charAt(2);
                char filaFinalChar = entrada.charAt(3);

                // Verifica si las letras son válidas (A-H) y los números (1-8)
                if ((columnaInicialChar >= 'A' && columnaInicialChar <= 'H') &&
                        (columnaFinalChar >= 'A' && columnaFinalChar <= 'H') &&
                        (filaInicialChar >= '1' && filaInicialChar <= '8') &&
                        (filaFinalChar >= '1' && filaFinalChar <= '8')) {

                    // Convierte las coordenadas de letras y números a índices de matriz
                    int columnaInicial = columnaInicialChar - 'A';
                    int filaInicial = 8 - (filaInicialChar - '1') - 1;
                    int columnaFinal = columnaFinalChar - 'A';
                    int filaFinal = 8 - (filaFinalChar - '1') - 1;

                    // Obtiene la pieza en la posición inicial
                    Pieza pieza = tablero.devuelvePieza(filaInicial, columnaInicial);

                    // Verifica si la pieza pertenece al jugador cuyo turno es
                    if (pieza != null) {
                        if ((pieza.getColor() && turnoBlancas) || (!pieza.getColor() && !turnoBlancas)) {
                            // Crea un objeto Movimiento con las posiciones inicial y final
                            Movimiento mov = new Movimiento(
                                    new Posicion(filaInicial, columnaInicial),
                                    new Posicion(filaFinal, columnaFinal)
                            );

                            // Verifica si el movimiento es válido para la pieza
                            if (pieza.validoMovimiento(mov, tablero)) {
                                tablero.mover(mov); // Realiza el movimiento en el tablero
                                tablero.pintarTablero(); // Muestra el tablero actualizado
                                turnoBlancas = !turnoBlancas; // Cambia el turno
                            } else {
                                mensaje = "ERROR: Movimiento invalido."; // Si el movimiento no es válido
                            }
                        } else {
                            mensaje = "ERROR: No es tu turno."; // Si el jugador mueve una pieza que no le pertenece
                        }
                    } else {
                        mensaje = "ERROR: No hay pieza en la posición inicial."; // Si no hay pieza en la posición inicial
                    }
                } else {
                    mensaje = "ERROR: Movimiento fuera de los limites del tablero."; // Si las coordenadas son inválidas
                }
            } else {
                mensaje = "ERROR: Entrada incorrecta. Debe tener 4 caracteres."; // Si la entrada tiene un formato incorrecto
            }

            // Si hay algún mensaje de error, se muestra en consola
            if (mensaje.length() > 0) {
                System.out.println(mensaje);
            }
        }
        lect.close(); // Cierra el objeto Scanner al final del juego
    }
}






