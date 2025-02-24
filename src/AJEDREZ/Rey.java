package AJEDREZ;

public class Rey extends Pieza{
    public Rey(boolean color) {
        super(color);
        if (color==false){
            Rey.super.setNombre("\u2654");
        }else {
            Rey.super.setNombre("\u265A");
        }
    }

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
