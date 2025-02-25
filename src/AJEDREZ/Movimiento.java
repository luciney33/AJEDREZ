package AJEDREZ;

/**
 * Representa un movimiento realizado en el tablero de ajedrez. Un movimiento tiene una posición
 * inicial y una posición final, y define la forma en que una pieza se desplaza en el tablero.
 */
public class Movimiento {
    private Posicion posInicial; // La posición inicial de la pieza
    private Posicion posFinal;   // La posición final de la pieza

    /**
     * Constructor por defecto que crea un movimiento sin posiciones iniciales o finales definidas.
     */
    public Movimiento() {}

    /**
     * Constructor que crea un movimiento con posiciones inicial y final específicas.
     *
     * @param posInicial La posición inicial de la pieza.
     * @param posFinal La posición final de la pieza.
     */
    public Movimiento(Posicion posInicial, Posicion posFinal) {
        this.posInicial = posInicial;
        this.posFinal = posFinal;
    }

    /**
     * Obtiene la posición inicial del movimiento.
     *
     * @return La posición inicial del movimiento.
     */
    public Posicion getPosInicial() {
        return posInicial;
    }

    /**
     * Obtiene la posición final del movimiento.
     *
     * @return La posición final del movimiento.
     */
    public Posicion getPosFinal() {
        return posFinal;
    }

    /**
     * Verifica si el movimiento es vertical, es decir, si la columna de la posición inicial es
     * igual a la columna de la posición final.
     *
     * @return true si el movimiento es vertical, false de lo contrario.
     */
    public boolean esVertical() {
        return posInicial.getColumna() == posFinal.getColumna(); // Solo verifica la columna
    }

    /**
     * Verifica si el movimiento es horizontal, es decir, si la fila de la posición inicial es
     * igual a la fila de la posición final.
     *
     * @return true si el movimiento es horizontal, false de lo contrario.
     */
    public boolean esHorizontal() {
        return posInicial.getFila() == posFinal.getFila(); // Solo verifica la fila
    }

    /**
     * Verifica si el movimiento es diagonal, es decir, si el cambio en las filas es igual al cambio
     * en las columnas en valor absoluto.
     *
     * @return true si el movimiento es diagonal, false de lo contrario.
     */
    public boolean esDiagonal() {
        return Math.abs(posFinal.getFila() - posInicial.getFila()) == Math.abs(posFinal.getColumna() - posInicial.getColumna());
    }

    /**
     * Calcula el salto horizontal del movimiento, que es la diferencia entre la columna final
     * y la columna inicial.
     *
     * @return El salto horizontal, que puede ser positivo, negativo o cero.
     */
    public int saltoHorizontal() {
        return posFinal.getColumna() - posInicial.getColumna(); // Devuelve positivo o negativo
    }

    /**
     * Calcula el salto vertical del movimiento, que es la diferencia entre la fila final
     * y la fila inicial.
     *
     * @return El salto vertical.
     */
    public int saltoVertical() {
        return posFinal.getFila() - posInicial.getFila();
    }

    /**
     * Devuelve una representación en forma de cadena de texto del movimiento, mostrando las
     * posiciones inicial y final.
     *
     * @return Una cadena que describe el movimiento en el formato "Movimiento{posInicial=..., posFinal=...}".
     */
    @Override
    public String toString() {
        return "Movimiento{" +
                "posInicial=" + posInicial +
                ", posFinal=" + posFinal +
                '}';
    }
}
