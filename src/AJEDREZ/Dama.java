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
    }
}
