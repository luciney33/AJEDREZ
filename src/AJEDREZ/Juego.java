package AJEDREZ;

public class Juego {
    private static boolean turno = false; // false = negras, true = blancas
    private Movimiento mov;

    public Juego() {}

    public boolean Turno() {
        return turno;
    }

    public void setTurno(boolean turno) {
        this.turno = true; // Se pone en true, debería cambiar al contrario
    }
    public static void cambiarTurno() {
        turno = !turno; // Invierte el turno (de true a false y viceversa)
    }

    // Metodo que procesa la jugada introducida por el jugador y si es valida la ejecuta
    public String jugada(String jugada, Tablero tablero) {

        // Convertimos la jugada a mayúsculas para evitar problemas con las minúsculas
        jugada = jugada.toUpperCase();
        String mensaje = null; // Variable para almacenar el resultado de la jugada

        // Verificamos que la jugada tenga exactamente 4 caracteres (ejemplo válido: "A2A4")
        if (jugada.length() != 4) {
            mensaje = "ERROR: No es válido, introduce de nuevo una jugada";
        }
        // Verificamos que las letras de la jugada estén dentro del rango de columnas ('A' a 'H')
        else if (jugada.charAt(0) < 'A' || jugada.charAt(0) > 'H' ||
                jugada.charAt(2) < 'A' || jugada.charAt(2) > 'H') {
            mensaje = "ERROR: No es válido, introduce de nuevo una jugada";
        }
        // Verificamos que los números de la jugada estén dentro del rango de filas ('1' a '8')
        else if (jugada.charAt(1) < '1' || jugada.charAt(1) > '8' ||
                jugada.charAt(3) < '1' || jugada.charAt(3) > '8') {
            mensaje = "ERROR: No es válido, introduce de nuevo una jugada";
        }
        else {
            // Convertimos las coordenadas en índices de matriz (0-7)
            int filaInicial = 8 - (jugada.charAt(1) - '1') - 1; // Convertir '1'-'8' en índices de 0 a 7
            int columnaInicial = jugada.charAt(0) - 'A'; // Convertir 'A'-'H' en índices de 0 a 7
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
            }
            else {
                // Si la jugada es válida, movemos la pieza en el tablero
                tablero.mover(new Movimiento(new Posicion(filaInicial, columnaInicial), new Posicion(filaFinal, columnaFinal)));

                // Cambiamos el turno al otro jugador
                turno = !turno;

                // Indicamos que el movimiento se realizó con éxito
                mensaje = "Movimiento realizado";
            }
        }
        return mensaje; // Devolvemos el mensaje con el resultado de la jugada
    }

}


