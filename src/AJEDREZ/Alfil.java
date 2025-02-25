package AJEDREZ;

/**
 * Clase que representa un alfil en el juego de ajedrez.
 * El alfil se mueve únicamente en diagonales.
 */

public class Alfil extends Pieza {
    /**
     * Constructor de la clase Alfil.
     * Asigna el símbolo Unicode correspondiente según el color de la pieza.
     *
     * @param color true si es blanco, false si es negro
     */
    public Alfil(boolean color) {
        super(color);
        if (color==false){
            Alfil.super.setNombre("\u2657");
        }else {
            Alfil.super.setNombre("\u265D");
        }
    }
    /**
     * Verifica si el movimiento propuesto es válido para un alfil.
     * Un alfil se mueve en línea diagonal y no puede saltar piezas.
     *
     * @param mov Objeto Movimiento que representa el movimiento deseado
     * @param tablero El tablero actual de ajedrez
     * @return true si el movimiento es válido, false en caso contrario
     */

    @Override
    public boolean validoMovimiento(Movimiento mov, Tablero tablero) {
        boolean esValido = false;

        if (mov.esDiagonal()) { //el alfil solo se mueve en diagonal
            if (!tablero.hayPiezasEntre(mov)) {
                Pieza piezaDestino = tablero.devuelvePieza(mov.getPosFinal());

                //si la casilla destino está vacía o contiene una pieza enemiga, el movimiento es valido
                if (piezaDestino == null || piezaDestino.getColor() != this.getColor()) {
                    esValido = true;
                }
            }
        }
        return esValido;
    }

    /**
     * Devuelve una representación en texto del alfil.
     *
     * @return Un String que indica el tipo y color del alfil junto con su símbolo
     */
    @Override
    public String toString() {
        String colorTexto;
        if (getColor()) {
            colorTexto = "Blanco";
        } else {
            colorTexto = "Negro";
        }
        return "Alfil"+ colorTexto + " (" + getNombre() + ")";
    }
}
