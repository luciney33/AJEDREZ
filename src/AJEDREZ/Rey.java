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
        // Calculamos la diferencia absoluta entre la posición inicial y final
        int saltoFila = Math.abs(mov.saltoVertical());   // Diferencia en filas
        int saltoColumna = Math.abs(mov.saltoHorizontal()); // Diferencia en columnas

        // Verificamos si en la casilla final hay una pieza del mismo color
        Pieza destino = tablero.devuelvePieza(mov.getPosFinal());
        if (destino != null && destino.getColor() == this.getColor()) {
            System.out.println("ERROR: Movimiento inválido, no puedes ocupar una casilla con tu propia pieza.");
            return false; // Si hay una pieza aliada, el movimiento no es válido
        }

        // Un rey solo puede moverse una casilla en cualquier dirección (vertical, horizontal o diagonal)
        if (saltoFila <= 1 && saltoColumna <= 1) {
            return true; // Movimiento permitido
        }

        return false; // Si no cumple las condiciones anteriores, el movimiento es inválido
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
