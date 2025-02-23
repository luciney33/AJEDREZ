package AJEDREZ;

public class Torre extends Pieza{
    public Torre(boolean color) {
        super(color);
        if (color==false){
            Torre.super.setNombre("\u2656");
        }else {
            Torre.super.setNombre("\u265C");
        }
    }

<<<<<<< HEAD
    @Override
    public boolean validoMovimiento(Movimiento mov, Tablero tablero) {
        if (mov.esHorizontal() || mov.esVertical()) { // La torre solo se mueve en línea recta
            if (!tablero.hayPiezasEntre(mov)) { // Evita que atraviese piezas
                return true;
            } else {
                System.out.println("ERROR: Movimiento bloqueado, hay piezas en el camino.");
=======

    @Override
    public boolean validoMovimiento(Movimiento mov, Tablero tablero) {
        if (mov.esHorizontal() || mov.esVertical()) { // 🔹 La torre solo se mueve en línea recta
            if (!tablero.hayPiezasEntre(mov)) { // 🔹 Evita que atraviese piezas
                return true;
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
        return "Torre"+ colorTexto + " (" + getNombre() + ")";
    }
=======
>>>>>>> 6cf971d51430ebfe80295f177d90df608bfa0602
}
