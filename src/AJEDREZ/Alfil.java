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
<<<<<<< HEAD
        if (mov.esDiagonal()) { // El alfil solo se mueve en diagonal
            if (!tablero.hayPiezasEntre(mov)) { // Verifica que el camino esté libre
                // No puede capturar su propia pieza
=======
        if (mov.esDiagonal()) { // 🔹 El alfil solo se mueve en diagonal
            if (!tablero.hayPiezasEntre(mov)) { // 🔹 Verifica que el camino esté libre
                // 📌 Nueva verificación: No puede capturar su propia pieza
>>>>>>> 6cf971d51430ebfe80295f177d90df608bfa0602
                Pieza piezaDestino = tablero.devuelvePieza(mov.getPosFinal());
                if (piezaDestino == null || piezaDestino.getColor() != this.getColor()) {
                    return true;
                } else {
<<<<<<< HEAD
                    System.out.println("ERROR: No puedes capturar tu propia pieza en " + mov.getPosFinal());
                }
            } else {
                System.out.println("ERROR: Movimiento bloqueado: Hay piezas en el camino.");
=======
                    System.out.println("❌ No puedes capturar tu propia pieza en " + mov.getPosFinal());
                }
            } else {
                System.out.println("❌ Movimiento bloqueado: Hay piezas en el camino.");
>>>>>>> 6cf971d51430ebfe80295f177d90df608bfa0602
            }
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
        return "Alfil"+ colorTexto + " (" + getNombre() + ")";
    }
=======
>>>>>>> 6cf971d51430ebfe80295f177d90df608bfa0602
}
