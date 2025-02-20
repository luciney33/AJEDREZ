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
        if (mov.esDiagonal()) { // 🔹 El alfil solo se mueve en diagonal
            if (!tablero.hayPiezasEntre(mov)) { // 🔹 Verifica que el camino esté libre
                // 📌 Nueva verificación: No puede capturar su propia pieza
                Pieza piezaDestino = tablero.devuelvePieza(mov.getPosFinal());
                if (piezaDestino == null || piezaDestino.getColor() != this.getColor()) {
                    return true;
                } else {
                    System.out.println("❌ No puedes capturar tu propia pieza en " + mov.getPosFinal());
                }
            } else {
                System.out.println("❌ Movimiento bloqueado: Hay piezas en el camino.");
            }
        }
        return false;
    }

}
