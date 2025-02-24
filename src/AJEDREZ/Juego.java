package AJEDREZ;

public class Juego {
    private static boolean turno = false;

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

    /**
     * procesa la jugada introducida por el jugador y verifica su validez
     * @param jugada cadena de 4 caracteres con la jugada
     * @param tablero tablero donde se realiza la jugada
     * @return un mensaje con el resultado del movimiento o error si no es valido
     */
    public String jugada(String jugada, Tablero tablero) {
        jugada = jugada.toUpperCase();
        String mensaje = "Movimiento realizado";
        boolean esValido = true;

        //verificar si la entrada tiene 4 caracteres
        if (jugada.length() != 4) {
            mensaje = "ERROR: No es valido, introduce de nuevo una jugada";
            esValido = false;
        }
        //que las columnas esten en el rango A-H
        else if (jugada.charAt(0) < 'A' || jugada.charAt(0) > 'H' ||
                jugada.charAt(2) < 'A' || jugada.charAt(2) > 'H') {
            mensaje = "ERROR: Movimiento fuera de los limites del tablero";
            esValido = false;
        }
        //que las filas esten en el rango 1-8
        else if (jugada.charAt(1) < '1' || jugada.charAt(1) > '8' ||
                jugada.charAt(3) < '1' || jugada.charAt(3) > '8') {
            mensaje = "ERROR: Movimiento fuera de los limites del tablero";
            esValido = false;
        }


        if (esValido) {
            int filaInicial = 8 - (jugada.charAt(1) - '1') - 1; //convertimos 1-8 a 0-7
            int columnaInicial = jugada.charAt(0) - 'A'; //convertimos A-H a 0-7
            int filaFinal = 8 - (jugada.charAt(3) - '1') - 1;
            int columnaFinal = jugada.charAt(2) - 'A';

            //se verifica si hay una pieza en la posicion inicial
            if (!tablero.hayPieza(filaInicial, columnaInicial)) {
                mensaje = "ERROR: No hay piezas en la casilla inicial";
            }
            //se verifica si la pieza pertenece al jugador que tiene el turno
            else if (tablero.devuelvePieza(filaInicial, columnaInicial).getColor() != turno) {
                mensaje = "ERROR: No puedes mover la pieza del rival";
            }
            //si la casilla final tiene una pieza aliada, no se puede capturar
            else if (tablero.hayPieza(filaFinal, columnaFinal) &&
                    tablero.devuelvePieza(filaFinal, columnaFinal).getColor() == turno) {
                mensaje = "ERROR: No te puedes comer tu propia pieza";
            }
            //realizar el movimiento
            else {
                boolean movimientoRealizado = tablero.mover(new Movimiento(
                        new Posicion(filaInicial, columnaInicial),
                        new Posicion(filaFinal, columnaFinal)
                ));

                //cambiar el turno
                if (movimientoRealizado) {
                    cambiarTurno();
                } else {
                    mensaje = "ERROR: Movimiento invalido";
                }
            }
        }
        return mensaje;
    }
}





