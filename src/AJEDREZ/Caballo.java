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

<<<<<<< HEAD
    public boolean validoMovimiento(Movimiento mov, Tablero tablero) {
        // Calculamos la diferencia absoluta en las filas y columnas
        int saltoHorizontal = Math.abs(mov.saltoHorizontal());
        int saltoVertical = Math.abs(mov.saltoVertical());

        // Verificamos si el movimiento cumple con la forma de "L":
        // - 2 casillas en una dirección y 1 en la otra (ejemplo: 2 horizontal y 1 vertical)
        // - 1 casilla en una dirección y 2 en la otra (ejemplo: 1 horizontal y 2 vertical)
        if ((saltoHorizontal == 2 && saltoVertical == 1) || (saltoHorizontal == 1 && saltoVertical == 2)) {
            return true;
        } else {
            return false;
        }
    }


    @Override
    public String toString() {
        String colorTexto;
        if (getColor()) {
            colorTexto = "Blanco";
        } else {
            colorTexto = "Negro";
        }
        return "Caballo"+ colorTexto + " (" + getNombre() + ")";
=======
    @Override
    public boolean validoMovimiento(Movimiento mov, Tablero tablero) {
        boolean respuesta = false;
        if ((Math.abs(mov.saltoHorizontal())==2 && Math.abs(mov.saltoVertical())==1) ||
                (Math.abs(mov.saltoHorizontal())==1 && Math.abs(mov.saltoVertical())==2)){
            respuesta = true;
        }
        return respuesta;
>>>>>>> 6cf971d51430ebfe80295f177d90df608bfa0602
    }
}
