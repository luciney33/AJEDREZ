package AJEDREZ;

/**
 * Representa una posición en el tablero de ajedrez. La clase contiene las coordenadas de fila
 * y columna que definen la ubicación de una pieza en el tablero.
 */
public class Posicion {
    private int fila;    // La fila de la posición (de 0 a 7)
    private int columna; // La columna de la posición (de 0 a 7)

    /**
     * Constructor por defecto que crea una posición sin valores iniciales.
     */
    public Posicion() {}

    /**
     * Constructor que crea una posición con las coordenadas específicas de fila y columna.
     *
     * @param fila La fila de la posición (de 0 a 7).
     * @param columna La columna de la posición (de 0 a 7).
     */
    public Posicion(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    /**
     * Establece el valor de la fila para esta posición.
     *
     * @param fila La fila que se desea establecer (de 0 a 7).
     */
    public void setFila(int fila) {
        this.fila = fila;
    }

    /**
     * Establece el valor de la columna para esta posición.
     *
     * @param columna La columna que se desea establecer (de 0 a 7).
     */
    public void setColumna(int columna) {
        this.columna = columna;
    }

    /**
     * Obtiene el valor de la fila de esta posición.
     *
     * @return La fila de la posición (de 0 a 7).
     */
    public int getFila() {
        return fila;
    }

    /**
     * Obtiene el valor de la columna de esta posición.
     *
     * @return La columna de la posición (de 0 a 7).
     */
    public int getColumna() {
        return columna;
    }

    /**
     * Devuelve una representación en forma de cadena de texto de esta posición.
     *
     * @return Una cadena que describe la posición en el formato "Posicion{fila=X, columna=Y}".
     */
    @Override
    public String toString() {
        return "Posicion{" +
                "fila=" + fila +
                ", columna=" + columna +
                '}';
    }
}





