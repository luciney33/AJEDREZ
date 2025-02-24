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
        boolean esValido = false;

        // Calculamos la diferencia absoluta en las filas y columnas
        int saltoHorizontal = Math.abs(mov.saltoHorizontal());
        int saltoVertical = Math.abs(mov.saltoVertical());

        // Verificamos si el movimiento cumple con la forma de "L"
        if ((saltoHorizontal == 2 && saltoVertical == 1) || (saltoHorizontal == 1 && saltoVertical == 2)) {
            esValido = true;
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
        return "Caballo"+ colorTexto + " (" + getNombre() + ")";
    }
}
