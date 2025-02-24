package AJEDREZ;

public class Torre extends Pieza {
    public Torre(boolean color) {
        super(color);
        if (color == false) {
            Torre.super.setNombre("\u2656");
        } else {
            Torre.super.setNombre("\u265C");
        }
    }


    @Override
    public boolean validoMovimiento(Movimiento mov, Tablero tablero) {
        boolean esValido = false; // Variable para indicar si el movimiento es válido

        // La torre solo se mueve en línea recta: horizontal o vertical
        if (mov.esVertical() || mov.esHorizontal()) {
            if (!tablero.hayPiezasEntre(mov)) { // Verifica que no haya piezas bloqueando el camino
                Pieza piezaDestino = tablero.devuelvePieza(mov.getPosFinal());

                // Puede moverse si la casilla está vacía o si hay una pieza enemiga
                if (piezaDestino == null || piezaDestino.getColor() != this.getColor()) {
                    esValido = true;
                }
            }
        }
        return esValido; // Devuelve si el movimiento es válido o no
    }



    @Override
        public String toString () {
            String colorTexto;
            if (getColor()) {
                colorTexto = "Blanco";
            } else {
                colorTexto = "Negro";
            }
            return "Torre" + colorTexto + " (" + getNombre() + ")";

        }
}

