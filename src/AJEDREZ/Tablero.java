package AJEDREZ;

public class Tablero {
    private Pieza Tablero[][] = new Pieza[8][8];

    Tablero() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Tablero[i][j] = null;
            }
        }

        Tablero[0][0] = new Torre(false);
        Tablero[0][1] = new Caballo(false);
        Tablero[0][2] = new Alfil(false);
        Tablero[0][3] = new Dama(false);
        Tablero[0][4] = new Rey(false);
        Tablero[0][5] = new Alfil(false);
        Tablero[0][6] = new Caballo(false);
        Tablero[0][7] = new Torre(false);
        for (int i = 0; i < 8; i++) {
            Tablero[1][i] = new Peon(false);
        }

        Tablero[7][0] = new Torre(true);
        Tablero[7][1] = new Caballo(true);
        Tablero[7][2] = new Alfil(true);
        Tablero[7][3] = new Dama(true);
        Tablero[7][4] = new Rey(true);
        Tablero[7][5] = new Alfil(true);
        Tablero[7][6] = new Caballo(true);
        Tablero[7][7] = new Torre(true);
        for (int i = 0; i < 8; i++) {
            Tablero[6][i] = new Peon(true);
        }
    }

    public void pintarTablero() {
        System.out.println("  A B C D E F G H"); // Encabezado de columnas
        for (int i = 0; i < 8; i++) {
            System.out.print((8 - i) + " "); // Número de fila (8 a 1)
            for (int j = 0; j < 8; j++) {
                if (Tablero[i][j] != null) {
                    System.out.print(Tablero[i][j].getNombre() + " ");
                } else {
                    System.out.print(".  "); // Ahora sí imprimimos correctamente los puntos
                }
            }
            System.out.println(); // Salto de línea para la siguiente fila
        }
        System.out.println();
    }

    public void mover(Movimiento mov) {
        Pieza pieza = devuelvePieza(mov.getPosInicial()); // Obtener la pieza en la posición inicial
        Pieza destino = devuelvePieza(mov.getPosFinal()); // Obtener la pieza en la posición final

        if (pieza == null) {
            System.out.println("❌ No hay pieza en la posición inicial.");
            return;
        }

        // Verifica si la casilla final contiene una pieza aliada
        if (destino != null && destino.getColor() == pieza.getColor()) {
            System.out.println("❌ No puedes capturar tu propia pieza en " + mov.getPosFinal());
            return;
        }

        // Validar si el movimiento es correcto para esa pieza
        if (!pieza.validoMovimiento(mov, this)) {
            System.out.println("❌ Movimiento inválido para la pieza.");
            return;
        }

        // Si hay una pieza enemiga, se captura (la eliminamos del tablero)
        if (destino != null && destino.getColor() != pieza.getColor()) {
            System.out.println("⚔️ Capturaste una pieza enemiga en " + mov.getPosFinal());
            quitaPieza(mov.getPosFinal());  // Elimina la pieza enemiga
        }

        ponPieza(pieza, mov.getPosFinal());  // Mueve la pieza
        quitaPieza(mov.getPosInicial());     // Borra la pieza de la posición original

        System.out.println("✅ Movimiento realizado.");
    }


    public boolean hayPieza(int fila, int columna) {
        boolean respuesta = false;
        if (Tablero[fila][columna] != null) {
            respuesta = true;
        }
        return respuesta;
    }

    public boolean hayPieza(Posicion pos) {
        return hayPieza(pos.getFila(), pos.getColumna());
    }

    public boolean hayPiezasEntre(Movimiento mov) {
        int filaInicio = mov.getPosInicial().getFila();
        int columnaInicio = mov.getPosInicial().getColumna();
        int filaFinal = mov.getPosFinal().getFila();
        int columnaFinal = mov.getPosFinal().getColumna();

        // Movimiento vertical (misma columna)
        if (columnaInicio == columnaFinal) {
            int paso = (filaFinal > filaInicio) ? 1 : -1;
            for (int fila = filaInicio + paso; fila != filaFinal; fila += paso) { // 🔹 Arreglado el límite
                if (Tablero[fila][columnaInicio] != null) {
                    System.out.println("❌ Hay una pieza bloqueando en: (" + fila + "," + columnaInicio + ")");
                    return true;
                }
            }
        }

        // Movimiento horizontal (misma fila)
        else if (filaInicio == filaFinal) {
            int paso = (columnaFinal > columnaInicio) ? 1 : -1;
            for (int columna = columnaInicio + paso; columna != columnaFinal; columna += paso) { // 🔹 Arreglado el límite
                if (Tablero[filaInicio][columna] != null) {
                    System.out.println("❌ Hay una pieza bloqueando en: (" + filaInicio + "," + columna + ")");
                    return true;
                }
            }
        }

        return false; // 🔹 No hay piezas bloqueando
    }




    public void ponPieza(Pieza figura, int fila, int columna) {
        Tablero[fila][columna] = figura;
    }

    public void ponPieza(Pieza figura, Posicion pos) {
        ponPieza(figura, pos.getFila(), pos.getColumna());
    }

    public void quitaPieza(int fila, int columna) {
        Tablero[fila][columna] = null;
    }

    public void quitaPieza(Posicion pos) {
        quitaPieza(pos.getFila(), pos.getColumna());
    }

    public Pieza devuelvePieza(int fila, int columna) {
        return Tablero[fila][columna];
    }

    public Pieza devuelvePieza(Posicion pos) {
        return Tablero[pos.getFila()][pos.getColumna()];
    }


}
