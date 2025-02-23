package AJEDREZ;

public class Dama extends Pieza{
    public Dama(boolean color) {
        super(color);
        if (color==false){
            Dama.super.setNombre("\u2655");
        }else {
            Dama.super.setNombre("\u265B");
        }
    }

    @Override
    public boolean validoMovimiento(Movimiento mov, Tablero tablero) {
<<<<<<< HEAD
        // Si se mueve en línea recta o en diagonal
        if (mov.esVertical() || mov.esHorizontal() || mov.esDiagonal()) {
            // Verifica si hay piezas en el camino
            if (!tablero.hayPiezasEntre(mov)) {
                return true; // Movimiento válido si el camino está despejado
            }
        }
        return false; // Movimiento inválido si está bloqueado o no es recto/diagonal
    }

    @Override
    public String toString() {
        String colorTexto;
        if (getColor()) {
            colorTexto = "Blanco";
        } else {
            colorTexto = "Negro";
        }
        return "Dama"+ colorTexto + " (" + getNombre() + ")";
=======
        boolean respuesta =false;
        if (mov.esVertical()||mov.esHorizontal()||mov.esDiagonal()){
            respuesta= true;
        }
        return respuesta;
>>>>>>> 6cf971d51430ebfe80295f177d90df608bfa0602
    }
}
