package AJEDREZ;
import java.util.Scanner;

/**
 * Representa un Peón en el juego de ajedrez. La clase extiende de Pieza y define el comportamiento
 * específico del peón, incluyendo su movimiento, la validación de los movimientos y la promoción
 * a otra pieza cuando llega a la última fila.
 */
public class Peon extends Pieza {

    /**
     * Constructor que crea un peón con un color específico. El peón puede ser blanco o negro.
     *
     * @param color El color del peón, donde {@code true} es blanco y {@code false} es negro.
     */
    public Peon(boolean color) {
        super(color);
        if (color == false) {
            Peon.super.setNombre("\u2659");  // Símbolo para peón negro
        } else {
            Peon.super.setNombre("\u265F");  // Símbolo para peón blanco
        }
    }

    /**
     * Valida si un movimiento es válido para este peón. El movimiento se puede hacer de manera
     * vertical (uno o dos espacios) o en diagonal (para capturar una pieza contraria).
     * También considera la promoción del peón si alcanza la última fila.
     *
     * @param mov El movimiento que se quiere validar.
     * @param tablero El tablero donde se realiza el movimiento.
     * @return true si el movimiento es válido, false de lo contrario.
     */
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

        // Movimiento del peón: solo se mueve de forma vertical.
        if (mov.esVertical() && mov.saltoHorizontal() == 0) {
            if (mov.saltoVertical() == direccion ||
                    (mov.getPosInicial().getFila() == filaInicio && mov.saltoVertical() == 2 * direccion && !tablero.hayPiezasEntre(mov))) {
                esValido = true;
            }
        }

        // El peón puede capturar en diagonal.
        if (mov.saltoVertical() == direccion && Math.abs(mov.saltoHorizontal()) == 1) {
            if (tablero.hayPieza(mov.getPosFinal()) && tablero.devuelvePieza(mov.getPosFinal()).getColor() != this.getColor()) {
                esValido = true;
            }
        }

        // Si el peón llega a la última fila, se promociona a otra pieza.
        if (esValido && (mov.getPosFinal().getFila() == 0 || mov.getPosFinal().getFila() == 7)) {
            promocionar(tablero, mov.getPosFinal());
        }

        return esValido;
    }

    /**
     * Promociona el peón a una pieza de mayor valor (Dama, Torre, Alfil o Caballo) cuando llega
     * a la última fila. La elección de la pieza se hace a través de la entrada del jugador.
     *
     * @param tablero El tablero donde se realiza la promoción.
     * @param pos La posición del peón que se va a promocionar.
     */
    private void promocionar(Tablero tablero, Posicion pos) {
        System.out.println("¡Promoción! ¿En qué pieza quieres convertir tu peón? (D - Dama, T - Torre, A - Alfil, C - Caballo)");
        String eleccion = new Scanner(System.in).next().toUpperCase();
        Pieza nuevaPieza;

        // Se crea la nueva pieza según la elección del jugador.
        switch (eleccion) {
            case "D": nuevaPieza = new Dama(getColor()); break;
            case "T": nuevaPieza = new Torre(getColor()); break;
            case "A": nuevaPieza = new Alfil(getColor()); break;
            case "C": nuevaPieza = new Caballo(getColor()); break;
            default:
                System.out.println("Elección inválida. Se promociona a Dama por defecto");
                nuevaPieza = new Dama(getColor());
        }

        // Reemplaza el peón por la nueva pieza en el tablero.
        tablero.ponPieza(nuevaPieza, pos);
    }

    /**
     * Devuelve una representación en forma de cadena de texto del peón, incluyendo su color
     * y su símbolo.
     *
     * @return Una cadena que describe el peón.
     */
    @Override
    public String toString () {
        String colorTexto;
        if (getColor()) {
            colorTexto = "Blanco";
        } else {
            colorTexto = "Negro";
        }
        return "Peón " + colorTexto + " (" + getNombre() + ")";
    }
}
