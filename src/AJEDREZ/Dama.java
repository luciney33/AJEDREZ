package AJEDREZ;

/**
 * Clase que representa una dama (reina) en el juego de ajedrez.
 * La dama puede moverse en línea recta vertical, horizontal o en diagonal.
 */
public class Dama extends Pieza {

    /**
     * Constructor de la clase Dama.
     * Asigna el símbolo Unicode correspondiente según el color.
     *
     * @param color true si la pieza es blanca, false si es negra
     */
    public Dama(boolean color) {
        super(color);
        if (color==false){
            Dama.super.setNombre("\u2655");
        }else {
            Dama.super.setNombre("\u265B");
        }
    }

    /**
     * Verifica si el movimiento es válido para una dama.
     * El movimiento debe ser vertical, horizontal o diagonal sin piezas en el camino.
     *
     * @param mov Objeto Movimiento que representa el movimiento deseado
     * @param tablero El tablero actual de ajedrez
     * @return true si el movimiento es válido, false en caso contrario
     */
    @Override
    public boolean validoMovimiento(Movimiento mov, Tablero tablero) {
        boolean esValido = false;

        //la dama puede moverse en línea recta, vertical u horizontal o en diagonal
        if (mov.esVertical() || mov.esHorizontal() || mov.esDiagonal()) {
            //verifica si el camino está despejado
            if (!tablero.hayPiezasEntre(mov)) {
                esValido = true;
            }
        }

        return esValido;
    }

    /**
     * Devuelve una representación en texto de la dama con su color y símbolo.
     *
     * @return Un String que describe la pieza
     */
    @Override
    public String toString() {
        String colorTexto;
        if (getColor()) {
            colorTexto = "Blanco";
        } else {
            colorTexto = "Negro";
        }
        return "Dama"+ colorTexto + " (" + getNombre() + ")";
    }
}

