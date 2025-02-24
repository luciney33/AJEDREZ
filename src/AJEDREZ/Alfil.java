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
