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
<<<<<<< HEAD
        // Calculamos la diferencia absoluta entre la posición inicial y final
        int saltoFila = Math.abs(mov.saltoVertical());
        int saltoColumna = Math.abs(mov.saltoHorizontal());

        // Verificamos si hay una pieza propia en la casilla final
        Pieza destino = tablero.devuelvePieza(mov.getPosFinal());
        if (destino != null && destino.getColor() == this.getColor()) {
            System.out.println("ERROR: Movimiento inválido, no puedes ocupar una casilla con tu propia pieza.");
            return false;// Si hay una pieza aliada, el movimiento no es válido
        }

        // El Rey solo puede moverse 1 casilla en cualquier dirección
=======
        int saltoFila = Math.abs(mov.saltoVertical());
        int saltoColumna = Math.abs(mov.saltoHorizontal());

        // 🔹 Verificamos si hay una pieza propia en la casilla final
        Pieza destino = tablero.devuelvePieza(mov.getPosFinal());
        if (destino != null && destino.getColor() == this.getColor()) {
            System.out.println("❌ Movimiento inválido: No puedes ocupar una casilla con tu propia pieza.");
            return false;
        }

        // 🔹 El Rey solo puede moverse 1 casilla en cualquier dirección
>>>>>>> 6cf971d51430ebfe80295f177d90df608bfa0602
        if (saltoFila <= 1 && saltoColumna <= 1) {
            return true;
        }

        return false;
    }

<<<<<<< HEAD
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
=======
>>>>>>> 6cf971d51430ebfe80295f177d90df608bfa0602
}