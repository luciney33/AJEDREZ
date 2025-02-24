package AJEDREZ;

public class Peon extends Pieza {
    public Peon(boolean color) {
        super(color);
        if (color == false) {
            Peon.super.setNombre("\u2659");
        } else {
            Peon.super.setNombre("\u265F");
        }
    }

    @Override
    public boolean validoMovimiento(Movimiento mov, Tablero tablero) {
        boolean esValido = false;  // Variable para almacenar si el movimiento es válido o no.

        // Definimos la dirección y la fila inicial dependiendo del color del peón.
        int direccion;
        int filaInicio;

        if (this.getColor()) { // Si el peón es blanco.
            direccion = -1;  // Se mueve hacia arriba en el tablero.
            filaInicio = 6;  // Los peones blancos comienzan en la fila 6.
        } else { // Si el peón es negro.
            direccion = 1;   // Se mueve hacia abajo en el tablero.
            filaInicio = 1;  // Los peones negros comienzan en la fila 1.
        }

        // Movimiento normal del peón
        if (mov.esVertical() && mov.saltoHorizontal() == 0) {
            if (mov.saltoVertical() == direccion ||
                    (mov.getPosInicial().getFila() == filaInicio && mov.saltoVertical() == 2 * direccion && !tablero.hayPiezasEntre(mov))) {
                esValido = true;
            }
        }

        // Captura en diagonal
        if (mov.saltoVertical() == direccion && Math.abs(mov.saltoHorizontal()) == 1) {
            if (tablero.hayPieza(mov.getPosFinal()) && tablero.devuelvePieza(mov.getPosFinal()).getColor() != this.getColor()) {
                esValido = true;
            }
        }

        // Si el peón llega a la última fila, se promociona
        if (esValido && (mov.getPosFinal().getFila() == 0 || mov.getPosFinal().getFila() == 7)) {
            promocionar(tablero, mov.getPosFinal());
        }

        return esValido;
    }


    private void promocionar(Tablero tablero, Posicion pos) {
        System.out.println("Promoción! ¿En qué pieza quieres convertir tu peón? (D - Dama, T - Torre, A - Alfil, C - Caballo)");
        String eleccion = new java.util.Scanner(System.in).next().toUpperCase();
        Pieza nuevaPieza;

        switch (eleccion) {
            case "D": nuevaPieza = new Dama(getColor()); break;
            case "T": nuevaPieza = new Torre(getColor()); break;
            case "A": nuevaPieza = new Alfil(getColor()); break;
            case "C": nuevaPieza = new Caballo(getColor()); break;
            default:
                System.out.println("Elección inválida. Se promociona a Dama por defecto.");
                nuevaPieza = new Dama(getColor());
        }

        tablero.ponPieza(nuevaPieza, pos); // Reemplazamos el peón por la nueva pieza
    }


    @Override
    public String toString () {
        String colorTexto;
        if (getColor()) {
            colorTexto = "Blanco";
        } else {
            colorTexto = "Negro";
        }
        return "Peon" + colorTexto + " (" + getNombre() + ")";
    }
}
