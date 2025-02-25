package AJEDREZ;

/**
 * Clase abstracta que representa una pieza de ajedrez.
 * Sirve como clase base para piezas específicas como Rey, Dama, Torre, etc.
 */
public abstract class Pieza {
    /** Nombre de la pieza (por ejemplo, "Rey", "Dama") */
    private String nombre;

    /** Color de la pieza: true para blanco, false para negro */
    private boolean color;

    /**
     * Constructor de la clase Pieza.
     *
     * @param color Color de la pieza (true para blanco, false para negro)
     */
    public Pieza(boolean color) {
        this.color = color;
    }

    /**
     * Devuelve el color de la pieza.
     *
     * @return true si la pieza es blanca, false si es negra
     */
    public boolean getColor() {
        return color;
    }

    /**
     * Establece el color de la pieza.
     *
     * @param color true para blanca, false para negra
     */
    public void setColor(boolean color) {
        this.color = color;
    }

    /**
     * Establece el nombre de la pieza.
     *
     * @param nombre Nombre de la pieza
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el nombre de la pieza.
     *
     * @return El nombre de la pieza
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método abstracto que determina si un movimiento es válido para la pieza.
     *
     * @param mov Objeto Movimiento que representa el movimiento propuesto
     * @param tablero El tablero de ajedrez actual
     * @return true si el movimiento es válido, false en caso contrario
     */
    public abstract boolean validoMovimiento(Movimiento mov, Tablero tablero);

    /**
     * Devuelve una representación en texto del nombre de la pieza.
     *
     * @return El nombre de la pieza
     */
    @Override
    public String toString() {
        return nombre;
    }
}

