package AJEDREZ;

/**
 * Clase que representa un rey en el juego de ajedrez.
 * El rey se mueve una sola casilla en cualquier dirección.
 */
public class Rey extends Pieza {

    /**
     * Constructor de la clase Rey.
     * Asigna el símbolo Unicode correspondiente según el color.
     *
     * @param color true si la pieza es blanca, false si es negra
     */
    public Rey(boolean color) {
        super(color);
        if (color==false){
            Rey.super.setNombre("\u2654");
        }else {
            Rey.super.setNombre("\u265A");
        }
    }

    /**
     * Verifica si el movimiento es válido para un rey.
     * El rey puede moverse solo una casilla en cualquier dirección,
     * siempre que la casilla de destino no contenga una pieza del mismo color.
     *
     * @param mov Objeto Movimiento que representa el movimiento deseado
     * @param tablero El tablero actual de ajedrez
     * @return true si el movimiento es válido, false en caso contrario
     */
    @Override
    public boolean validoMovimiento(Movimiento mov, Tablero tablero) {
        boolean esValido = false;

        int saltoFila = Math.abs(mov.saltoVertical());
        int saltoColumna = Math.abs(mov.saltoHorizontal());

        //verificar si en la casilla final hay una pieza del mismo color
        Pieza destino = tablero.devuelvePieza(mov.getPosFinal());

        if (destino == null || destino.getColor() != this.getColor()) { //la casilla esta vacia o hay una pieza enemiga
            if (saltoFila <= 1 && saltoColumna <= 1) { //Rey solo se mueve 1 casilla en cualquier dirección
                esValido = true;
            }
        }
        return esValido;
    }

    /**
     * Devuelve una representación en texto del rey con su color y símbolo.
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
        return "Rey"+ colorTexto + " (" + getNombre() + ")";
    }
}
