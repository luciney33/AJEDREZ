package AJEDREZ;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner lect = new Scanner(System.in);
        Tablero tablero = new Tablero();
        boolean turnoBlancas = true; //empiezan las blancas
        boolean seguirJugando = true; //variable para controlar si el juego continua
        String mensaje; //almacena el mensaje del turno

        tablero.pintarTablero();

        while (seguirJugando) { //bucle del juego
            if (turnoBlancas) {
                mensaje = "\nTurno de Blancas";
            } else {
                mensaje = "\nTurno de Negras";
            }
            System.out.println(mensaje);
            System.out.println("Introduce tu movimiento (ejemplo: A2A4) o escribe RENDIRSE o EMPATE:");

            String entrada = lect.nextLine().toUpperCase();
            mensaje = ""; //pa resetear el mensaje

            //comprobar si el jugador se rinde o quiere empate
            if (entrada.equals("EMPATE")) { //empate
                System.out.println("El jugador ha propuesto un empate. ¿Aceptas? (S/N)");
                char respuesta = lect.next().toUpperCase().charAt(0);
                if (respuesta == 'S') {
                    System.out.println("Partida terminada en empate");
                    break;
                }
                System.out.println("El oponente ha rechazado el empate. La partida continúa.");
            }
            else if (entrada.equals("RENDIRSE")) { //rendirse
                System.out.println("El jugador se ha rendido. Fin de la partida!!!");
                break;
            }
            //los 4 caracteres de la entrada y los guardamos en variables
            else if (entrada.length() == 4) {
                char columnaInicialChar = entrada.charAt(0);
                char filaInicialChar = entrada.charAt(1);
                char columnaFinalChar = entrada.charAt(2);
                char filaFinalChar = entrada.charAt(3);

                //verificar si las letras son válidas A-H y los numeros 1-8
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
                                turnoBlancas = !turnoBlancas; //cambiar turno
                            } else {
                                mensaje = "ERROR: Movimiento invalido.";
                            }
                        } else {
                            mensaje = "ERROR: No es tu turno.";
                        }
                    } else {
                        mensaje = "ERROR: No hay pieza en la posición inicial.";
                    }
                } else {
                    mensaje = "ERROR: Movimiento fuera de los limites del tablero.";
                }
            } else {
                mensaje = "ERROR: Entrada incorrecta. Debe tener 4 caracteres.";
            }

            if (mensaje.length() > 0) {
                System.out.println(mensaje);
            }
        }
        lect.close();
    }
}





