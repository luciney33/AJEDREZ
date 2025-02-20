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
        int direccion = (this.getColor()) ? -1 : 1;
        int filaInicio = (this.getColor()) ? 6 : 1;

        System.out.println("📌 Peón: " + this.getNombre());
        System.out.println("   Pos inicial: " + mov.getPosInicial().getFila() + "," + mov.getPosInicial().getColumna());
        System.out.println("   Pos final: " + mov.getPosFinal().getFila() + "," + mov.getPosFinal().getColumna());
        System.out.println("   Salto vertical: " + mov.saltoVertical());
        System.out.println("   Salto horizontal: " + mov.saltoHorizontal());
        System.out.println("   Dirección esperada: " + direccion);

        // Movimiento vertical (avanzar sin capturar)
        if (mov.esVertical() && mov.saltoHorizontal() == 0) {
            System.out.println("✅ Movimiento es vertical y no tiene desplazamiento horizontal");

            if (mov.saltoVertical() == direccion) {
                System.out.println("✅ Movimiento válido: 1 casilla hacia adelante");
                return true; // 🔹 RETORNAMOS AQUÍ DIRECTAMENTE
            }

            if (mov.getPosInicial().getFila() == filaInicio && mov.saltoVertical() == 2 * direccion) {
                if (!tablero.hayPiezasEntre(mov)) {
                    System.out.println("✅ Movimiento válido: 2 casillas en el primer turno");
                    return true; // 🔹 RETORNAMOS AQUÍ DIRECTAMENTE
                } else {
                    System.out.println("❌ No se puede mover 2 casillas porque hay una pieza bloqueando.");
                    return false; // 🔹 SI HAY PIEZAS, RETORNAMOS `false`
                }
            }
        }

        // 🚀 Nueva condición: Captura en diagonal
        if (mov.saltoVertical() == direccion && mov.saltoHorizontal() == 1) { // Movimiento diagonal
            if (tablero.hayPieza(mov.getPosFinal())) { // Solo si hay una pieza en la casilla destino
                Pieza piezaEnDestino = tablero.devuelvePieza(mov.getPosFinal());

                if (piezaEnDestino.getColor() != this.getColor()) { // Solo permite capturar piezas enemigas
                    System.out.println("✅ Captura en diagonal permitida");
                    return true;
                } else {
                    System.out.println("❌ No puedes capturar tu propia pieza.");
                    return false;
                }
            } else {
                System.out.println("❌ No se puede mover en diagonal sin capturar.");
                return false;
            }
        }


        System.out.println("🔎 FINAL: `validoMovimiento()` devuelve: false");
        return false; // 🔹 SI NINGUNA CONDICIÓN SE CUMPLE, RETORNAMOS `false`
    }

}

