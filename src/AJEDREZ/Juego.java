package AJEDREZ;

public class Juego {
    private boolean turno = false;

    private Movimiento mov;
    public Juego(){}

    public boolean Turno() {
        return turno;
    }

    public void setTurno(boolean turno) {
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
    }
}
