package AJEDREZ;

/**
 * Clase que representa un caballo en el juego de ajedrez.
 * El caballo se mueve en forma de "L": dos casillas en una dirección y una en perpendicular.
 */
public class Caballo extends Pieza {

    /**
     * Constructor de la clase Caballo.
     * Asigna el símbolo Unicode correspondiente según el color.
     *
     * @param color true si la pieza es blanca, false si es negra
     */
    public Caballo(boolean color) {
        super(color);
        if (color==false){
            Caballo.super.setNombre("\u2658");
        }else {
            Caballo.super.setNombre("\u265E");
        }
    }

    /**
     * Verifica si el movimiento es válido para un caballo.
     * El movimiento debe formar una "L": dos en una dirección y uno en la otra.
     *
     * @param mov Objeto Movimiento que representa el movimiento deseado
     * @param tablero El tablero actual de ajedrez
     * @return true si el movimiento es válido, false en caso contrario
     */
    @Override
    public boolean validoMovimiento(Movimiento mov, Tablero tablero) {
        boolean esValido = false;

        //diferencia absoluta en las filas y columnas
        int saltoHorizontal = Math.abs(mov.saltoHorizontal());
        int saltoVertical = Math.abs(mov.saltoVertical());

        //verificar si el movimiento cumple con la forma de L
        if ((saltoHorizontal == 2 && saltoVertical == 1) || (saltoHorizontal == 1 && saltoVertical == 2)) {
            esValido = true;
        }

        return esValido;
    }

    /**
     * Devuelve una representación en texto del caballo con su color y símbolo.
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
        return "Caballo"+ colorTexto + " (" + getNombre() + ")";
    }
}
