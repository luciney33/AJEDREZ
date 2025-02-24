package AJEDREZ;
import java.util.Scanner;

public class Peon extends Pieza {
    public Peon(boolean color) {
        super(color);
        if (color == false) {
            Peon.super.setNombre("\u2659");
        } else {
            Peon.super.setNombre("\u265F");
        }
    }

    @Override
    public boolean validoMovimiento(Movimiento mov, Tablero tablero) {
        boolean esValido = false;

        int direccion;
        int filaInicio;

        if (this.getColor()) { //si el peón es blanco.
            direccion = -1;  //se mueve hacia arriba
            filaInicio = 6;  //los peones blancos comienzan en la fila 6.
        } else { //si es negro.
            direccion = 1;
            filaInicio = 1;
        }

        //movimiento del peón
        if (mov.esVertical() && mov.saltoHorizontal() == 0) {
            if (mov.saltoVertical() == direccion ||
                    (mov.getPosInicial().getFila() == filaInicio && mov.saltoVertical() == 2 * direccion && !tablero.hayPiezasEntre(mov))) {
                esValido = true;
            }
        }

        //come en diagonal
        if (mov.saltoVertical() == direccion && Math.abs(mov.saltoHorizontal()) == 1) {
            if (tablero.hayPieza(mov.getPosFinal()) && tablero.devuelvePieza(mov.getPosFinal()).getColor() != this.getColor()) {
                esValido = true;
            }
        }

        //si el peon llega a la ultima fila, se promociona
        if (esValido && (mov.getPosFinal().getFila() == 0 || mov.getPosFinal().getFila() == 7)) {
            promocionar(tablero, mov.getPosFinal());
        }

        return esValido;
    }


    private void promocionar(Tablero tablero, Posicion pos) {
        System.out.println("Promoción! ¿En qué pieza quieres convertir tu peón? (D - Dama, T - Torre, A - Alfil, C - Caballo)");
        String eleccion = new Scanner(System.in).next().toUpperCase();
        Pieza nuevaPieza;

        switch (eleccion) {
            case "D": nuevaPieza = new Dama(getColor()); break;
            case "T": nuevaPieza = new Torre(getColor()); break;
            case "A": nuevaPieza = new Alfil(getColor()); break;
            case "C": nuevaPieza = new Caballo(getColor()); break;
            default:
                System.out.println("Elección invalida. Se promociona a Dama por defecto");
                nuevaPieza = new Dama(getColor());
        }

        tablero.ponPieza(nuevaPieza, pos); //reemplazamos el peon por la nueva pieza
    }


    @Override
    public String toString () {
        String colorTexto;
        if (getColor()) {
            colorTexto = "Blanco";
        } else {
            colorTexto = "Negro";
        }
        return "Peon" + colorTexto + " (" + getNombre() + ")";
    }
}
