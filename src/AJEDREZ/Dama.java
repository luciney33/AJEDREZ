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
        boolean esValido = false;

        //la dama puede moverse en línea recta, vertical u horizontal o en diagonal
        if (mov.esVertical() || mov.esHorizontal() || mov.esDiagonal()) {
            //verifica si el camino está despejado
            if (!tablero.hayPiezasEntre(mov)) {
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
        return "Dama"+ colorTexto + " (" + getNombre() + ")";
    }
}
