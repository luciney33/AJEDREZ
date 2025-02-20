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
        boolean respuesta =false;
        if (mov.esVertical()||mov.esHorizontal()||mov.esDiagonal()){
            respuesta= true;
        }
        return respuesta;
    }
}
