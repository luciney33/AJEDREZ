package AJEDREZ;

public class Juego {
    private static boolean turno = false; // false = negras, true = blancas

    public Juego() {}

    public boolean getTurno() {
        return turno;
    }

    public void setTurno(boolean nuevoTurno) {
        turno = nuevoTurno;
    }

    public static void cambiarTurno() {
        turno = !turno;
    }

    public String jugada(String jugada, Tablero tablero) {
        jugada = jugada.toUpperCase();
        String mensaje = "Movimiento realizado";
        boolean esValido = true;

        if (jugada.length() != 4) {
            mensaje = "ERROR: No es válido, introduce de nuevo una jugada";
            esValido = false;
        } else if (jugada.charAt(0) < 'A' || jugada.charAt(0) > 'H' ||
                jugada.charAt(2) < 'A' || jugada.charAt(2) > 'H') {
            mensaje = "ERROR: No es válido, introduce de nuevo una jugada";
            esValido = false;
        } else if (jugada.charAt(1) < '1' || jugada.charAt(1) > '8' ||
                jugada.charAt(3) < '1' || jugada.charAt(3) > '8') {
            mensaje = "ERROR: No es válido, introduce de nuevo una jugada";
            esValido = false;
        } else {
            int filaInicial = 8 - (jugada.charAt(1) - '1') - 1;
            int columnaInicial = jugada.charAt(0) - 'A';
            int filaFinal = 8 - (jugada.charAt(3) - '1') - 1;
            int columnaFinal = jugada.charAt(2) - 'A';

            if (!tablero.hayPieza(filaInicial, columnaInicial)) {
                mensaje = "ERROR: No hay piezas en la casilla inicial";
                esValido = false;
            } else if (tablero.devuelvePieza(filaInicial, columnaInicial).getColor() != turno) {
                mensaje = "ERROR: No puedes mover la pieza del rival";
                esValido = false;
            } else if (tablero.hayPieza(filaFinal, columnaFinal) &&
                    tablero.devuelvePieza(filaFinal, columnaFinal).getColor() == turno) {
                mensaje = "ERROR: No te puedes comer tu propia pieza";
                esValido = false;
            } else {
                tablero.mover(new Movimiento(new Posicion(filaInicial, columnaInicial),
                        new Posicion(filaFinal, columnaFinal)));
                cambiarTurno();
            }
        }
        return mensaje;
    }
}



