package AJEDREZ;

public class Alfil extends Pieza {
    public Alfil(boolean color) {
        super(color);
        if (color==false){
            Alfil.super.setNombre("\u2657");
        }else {
            Alfil.super.setNombre("\u265D");
        }
    }


    @Override
    public boolean validoMovimiento(Movimiento mov, Tablero tablero) {
        boolean esValido = false; // Variable para indicar si el movimiento es válido

        if (mov.esDiagonal()) { // El alfil solo se mueve en diagonal
            if (!tablero.hayPiezasEntre(mov)) { // Verifica que el camino esté libre
                Pieza piezaDestino = tablero.devuelvePieza(mov.getPosFinal());

                // Si la casilla destino está vacía o contiene una pieza enemiga, el movimiento es válido
                if (piezaDestino == null || piezaDestino.getColor() != this.getColor()) {
                    esValido = true;
                }
            }
        }
        return esValido; // Devuelve si el movimiento es válido o no
    }


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
