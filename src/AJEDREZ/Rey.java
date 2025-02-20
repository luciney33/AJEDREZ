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
        int saltoFila = Math.abs(mov.saltoVertical());
        int saltoColumna = Math.abs(mov.saltoHorizontal());

        // 🔹 Verificamos si hay una pieza propia en la casilla final
        Pieza destino = tablero.devuelvePieza(mov.getPosFinal());
        if (destino != null && destino.getColor() == this.getColor()) {
            System.out.println("❌ Movimiento inválido: No puedes ocupar una casilla con tu propia pieza.");
            return false;
        }

        // 🔹 El Rey solo puede moverse 1 casilla en cualquier dirección
        if (saltoFila <= 1 && saltoColumna <= 1) {
            return true;
        }

        return false;
    }

}