package AJEDREZ;

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
        // Definimos la dirección y la fila inicial dependiendo del color del peón
        int direccion;
        int filaInicio;

        if (this.getColor()) { // Si el peón es blanco
            direccion = -1;  // Se mueve hacia arriba en el tablero
            filaInicio = 6;  // Los peones blancos comienzan en la fila 6
        } else { // Si el peón es negro
            direccion = 1;   // Se mueve hacia abajo en el tablero
            filaInicio = 1;  // Los peones negros comienzan en la fila 1
        }

        // Mostrar información del movimiento para depuración
        System.out.println("📌 Peón: " + this.getNombre());
        System.out.println("   Pos inicial: " + mov.getPosInicial().getFila() + "," + mov.getPosInicial().getColumna());
        System.out.println("   Pos final: " + mov.getPosFinal().getFila() + "," + mov.getPosFinal().getColumna());

        // 🔹 Movimiento vertical: avanzar sin capturar
        if (mov.esVertical() && mov.saltoHorizontal() == 0) {
            System.out.println("Movimiento es vertical y no tiene desplazamiento horizontal");

            // Movimiento de 1 casilla hacia adelante
            if (mov.saltoVertical() == direccion) {
                System.out.println("Movimiento válido: 1 casilla hacia adelante");
                return true; // Movimiento permitido
            }

            // Movimiento de 2 casillas en el primer turno del peón
            if (mov.getPosInicial().getFila() == filaInicio && mov.saltoVertical() == 2 * direccion) {
                if (!tablero.hayPiezasEntre(mov)) { // Comprobamos que no haya piezas bloqueando
                    System.out.println("Movimiento válido: 2 casillas en el primer turno");
                    return true;
                } else {
                    System.out.println("ERROR: No se puede mover 2 casillas porque hay una pieza bloqueando.");
                    return false; // Movimiento inválido si hay piezas en el camino
                }
            }
        }

        // 🔹 Movimiento en diagonal: Captura de pieza enemiga
        if (mov.saltoVertical() == direccion && mov.saltoHorizontal() == 1) { // Movimiento diagonal
            if (tablero.hayPieza(mov.getPosFinal())) { // Solo se permite capturar si hay una pieza
                Pieza piezaEnDestino = tablero.devuelvePieza(mov.getPosFinal());

                // Solo puede capturar si la pieza en la casilla destino es del rival
                if (piezaEnDestino.getColor() != this.getColor()) {
                    System.out.println("Captura en diagonal permitida");
                    return true;
                } else {
                    System.out.println("ERROR: No puedes capturar tu propia pieza.");
                    return false;
                }
            } else {
                System.out.println("ERROR: No se puede mover en diagonal sin capturar.");
                return false;
            }
        }

        // Si no cumple ninguna condición, el movimiento es inválido
        System.out.println("FINAL: `validoMovimiento()` devuelve: false");
        return false;
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
