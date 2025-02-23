package AJEDREZ;

public class Juego {
<<<<<<< HEAD
    private static boolean turno = false; // 🔹 false = negras, true = blancas
    private Movimiento mov;

    public Juego() {}
=======
    private boolean turno = false;

    private Movimiento mov;
    public Juego(){}
>>>>>>> 6cf971d51430ebfe80295f177d90df608bfa0602

    public boolean Turno() {
        return turno;
    }

    public void setTurno(boolean turno) {
<<<<<<< HEAD
        this.turno = true; // Se pone en true, debería cambiar al contrario
    }
    public static void cambiarTurno() {
        turno = !turno; // 🔹 Invierte el turno (de true a false y viceversa)
    }

    // Metodo que procesa la jugada introducida por el jugador y si es valida la ejecuta
    public String jugada(String jugada, Tablero tablero) {
        jugada = jugada.toUpperCase();
        String mensaje = null; // Variable para almacenar el resultado de la jugada

        // Verificamos que la jugada tenga exactamente 4 caracteres (ejemplo válido: "A2A4")
        if (jugada.length() != 4) {
            mensaje = "ERROR: No es válido, introduce de nuevo una jugada";
        } else if (jugada.charAt(0) < 'A' || jugada.charAt(0) > 'H' ||
                jugada.charAt(2) < 'A' || jugada.charAt(2) > 'H') {
            mensaje = "ERROR: No es válido, introduce de nuevo una jugada";

            // Verificamos que los números de la jugada estén dentro del rango de filas ('1' a '8')
        } else if (jugada.charAt(1) < '1' || jugada.charAt(1) > '8' ||
                jugada.charAt(3) < '1' || jugada.charAt(3) > '8') {
            mensaje = "ERROR: No es válido, introduce de nuevo una jugada";
        } else {
            // Convertimos las coordenadas en índices de matriz (0-7)
            int filaInicial = 8 - (jugada.charAt(1) - '1') - 1;
            int columnaInicial = jugada.charAt(0) - 'A';
            int filaFinal = 8 - (jugada.charAt(3) - '1') - 1;
            int columnaFinal = jugada.charAt(2) - 'A';

            // Verificamos si hay una pieza en la posición inicial
            if (!tablero.hayPieza(filaInicial, columnaInicial)) {
                mensaje = "ERROR: No hay piezas en la casilla inicial";
            }
            // Verificamos si la pieza pertenece al jugador que tiene el turno
            else if (tablero.devuelvePieza(filaInicial, columnaInicial).getColor() != turno) {
                mensaje = "ERROR: No puedes mover la pieza del rival";
            }
            // Verificamos si la casilla final contiene una pieza aliada (no se puede capturar)
            else if (tablero.hayPieza(filaFinal, columnaFinal) &&
                    tablero.devuelvePieza(filaFinal, columnaFinal).getColor() == turno) {
                mensaje = "ERROR: No te puedes comer tu propia pieza";
            } else {
                // Si la jugada es válida, movemos la pieza en el tablero
                tablero.mover(new Movimiento(new Posicion(filaInicial, columnaInicial), new Posicion(filaFinal, columnaFinal)));
                turno = !turno; // Cambiar de turno tras un movimiento válido
                mensaje = "Movimiento realizado";
            }
        }
        return mensaje;// Devolvemos el mensaje con el resultado de la jugada
=======
        this.turno = true;
    }


    public String jugada(String jugada, Tablero tablero) {
        jugada = jugada.toUpperCase();
        String mensaje = null;
        if (jugada.length() != 4) {
            mensaje = "No es válido, introduce de nuevo una jugada";
        } else if (jugada.charAt(0) < 65 && jugada.charAt(0) > 72 || jugada.charAt(2) < 65 && jugada.charAt(2) > 72) {
            mensaje = "No es válido, introduce de nuevo una jugada";
        } else if (jugada.charAt(1) < 49 && jugada.charAt(1) > 56 || jugada.charAt(3) < 49 && jugada.charAt(3) > 56) {
            mensaje = "No es válido, introduce de nuevo una jugada";
        } else {
            int filaInicial = jugada.charAt(0) - 'A';
            int columnaInicial = 7- jugada.charAt(1) - '1';
            int filaFinal = jugada.charAt(2) - 'A';
            int columnaFinal = 7-jugada.charAt(3) - '1';
            if (tablero.hayPieza(filaInicial, columnaInicial) == false) {
                mensaje = "No hay piezas en la casilla inicial";
            } else if (tablero.devuelvePieza(filaInicial, columnaInicial).getColor() != turno) {
                mensaje = "No puedes mover la pieza del rival";
            } else if (tablero.hayPieza(filaFinal, columnaFinal) == false) {
                if (tablero.devuelvePieza(filaInicial, columnaInicial).getColor() == turno) {
                    mensaje = "No te puedes comer tu propia pieza";
                }
            }
        }
        return mensaje;
>>>>>>> 6cf971d51430ebfe80295f177d90df608bfa0602
    }
}
