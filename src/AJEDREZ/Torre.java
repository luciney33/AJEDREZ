package AJEDREZ;

/**
 * Representa una Torre en el juego de ajedrez. La clase extiende de Pieza y define el comportamiento
 * específico de la torre, incluyendo su movimiento y su validación.
 */
public class Torre extends Pieza {

    /**
     * Constructor que crea una torre con un color específico. La torre puede ser blanca o negra.
     *
     * @param color El color de la torre, donde {@code true} es blanca y {@code false} es negra.
     */
    public Torre(boolean color) {
        super(color);
        if (color == false) {
            Torre.super.setNombre("\u2656");  // Símbolo para torre negra
        } else {
            Torre.super.setNombre("\u265C");  // Símbolo para torre blanca
        }
    }

    /**
     * Valida si un movimiento es válido para esta torre. La torre puede moverse en línea recta,
     * ya sea horizontal o verticalmente, siempre y cuando no haya piezas bloqueando su camino.
     * La torre también puede capturar piezas enemigas si están en su camino.
     *
     * @param mov El movimiento que se quiere validar.
     * @param tablero El tablero donde se realiza el movimiento.
     * @return true si el movimiento es válido, false de lo contrario.
     */
    @Override
    public boolean validoMovimiento(Movimiento mov, Tablero tablero) {
        boolean esValido = false;

        // La torre solo se mueve en línea recta, ya sea horizontal o vertical.
        if (mov.esVertical() || mov.esHorizontal()) {
            if (!tablero.hayPiezasEntre(mov)) { // Verificar que no haya piezas bloqueando el camino
                Pieza piezaDestino = tablero.devuelvePieza(mov.getPosFinal());

                // La torre puede moverse si la casilla está vacía o si hay una pieza enemiga.
                if (piezaDestino == null || piezaDestino.getColor() != this.getColor()) {
                    esValido = true;
                }
            }
        }
        return esValido;
    }

    /**
     * Devuelve una representación en forma de cadena de texto de la torre, incluyendo su color
     * y su símbolo.
     *
     * @return Una cadena que describe la torre.
     */
    @Override
    public String toString () {
        String colorTexto;
        if (getColor()) {
            colorTexto = "Blanco";
        } else {
            colorTexto = "Negro";
        }
        return "Torre " + colorTexto + " (" + getNombre() + ")";
    }
}
