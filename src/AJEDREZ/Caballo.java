package AJEDREZ;

public class Caballo extends Pieza{
    public Caballo(boolean color) {
        super(color);
        if (color==false){
            Caballo.super.setNombre("\u2658");
        }else {
            Caballo.super.setNombre("\u265E");
        }
    }

    @Override
    public boolean validoMovimiento(Movimiento mov, Tablero tablero) {
        boolean respuesta = false;
        if ((Math.abs(mov.saltoHorizontal())==2 && Math.abs(mov.saltoVertical())==1) ||
                (Math.abs(mov.saltoHorizontal())==1 && Math.abs(mov.saltoVertical())==2)){
            respuesta = true;
        }
        return respuesta;
    }
}
