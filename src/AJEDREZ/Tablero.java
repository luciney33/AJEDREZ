package AJEDREZ;

import java.util.Scanner;

public class Tablero {
    private Pieza Tablero[][] = new Pieza[8][8];


    Tablero() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Tablero[i][j] = null;
                System.out.println("sisiisisu");
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

    /**
     * metodo para visionar el tablero
     */
    public void pintarTablero() {
        System.out.println("  A  B  C  D  E  F  G  H");
        for (int i = 0; i < 8; i++) {
            System.out.print((8 - i) + " ");
            for (int j = 0; j < 8; j++) {
                if (Tablero[i][j] != null) {
                    System.out.print(Tablero[i][j].getNombre() + "  ");
                } else {
                    System.out.print(".   ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * método que sirve para mover las piezas y verificar los movimientos
     * @param mov movimiento definido por la posición inicial y final...
     */
    public void mover(Movimiento mov) {
        Pieza pieza = devuelvePieza(mov.getPosInicial());
        Pieza destino = devuelvePieza(mov.getPosFinal());

        if (pieza == null) {
            System.out.println("ERROR: No hay pieza en la posición inicial.");
            return;
        }

        // Verifica si la casilla final contiene una pieza aliada
        if (destino != null && destino.getColor() == pieza.getColor()) {
            System.out.println("ERROR: No puedes capturar tu propia pieza en " + mov.getPosFinal());
            return;
        }


        // Validar si el movimiento es correcto para esa pieza
        if (!pieza.validoMovimiento(mov, this)) {
            System.out.println("ERROR: Movimiento inválido para la pieza.");
            return;
        }

        // Si hay una pieza enemiga, se captura (la eliminamos del tablero)
        if (destino != null && destino.getColor() != pieza.getColor()) {
            System.out.println("Capturaste una pieza enemiga en " + mov.getPosFinal());
            quitaPieza(mov.getPosFinal());  // Elimina la pieza enemiga
        }

        // Verificar si el peón ha llegado a la última fila y permitir promoción
        if (pieza instanceof Peon) {
            int filaFinal = mov.getPosFinal().getFila();

            if ((pieza.getColor() && filaFinal == 0) || (!pieza.getColor() && filaFinal == 7)) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Tu peón ha llegado al final ¿En qué pieza quieres convertirlo?");
                System.out.print("Introduce D (Dama), T (Torre), A (Alfil) o C (Caballo): ");

                String opc = scanner.nextLine().toUpperCase();
                switch (opc) {
                    case "D":
                        pieza = new Dama(pieza.getColor());
                        break;
                    case "T":
                        pieza = new Torre(pieza.getColor());
                        break;
                    case "A":
                        pieza = new Alfil(pieza.getColor());
                        break;
                    case "C":
                        pieza = new Caballo(pieza.getColor());
                        break;
                    default:
                        System.out.println("ERROR: Opción no válida, el peón se convertirá en una Dama por defecto.");
                        pieza = new Dama(pieza.getColor());
                }
            }
        }

        /**
         * ponPieza mueve la pieza
         * quitaPieza borra la pieza de la posición original
         */
        ponPieza(pieza, mov.getPosFinal());
        quitaPieza(mov.getPosInicial());

        System.out.println("Movimiento realizado.");

        /**
         * Cambia el turno después del movimiento
         */
        Juego.cambiarTurno();
    }

    /**
     * @param fila
     * @param columna
     * @return true si hay pieza
     */
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


    /**
     * @param mov
     * @return no hay piezas bloqueando el camino
     */
    public boolean hayPiezasEntre(Movimiento mov) {
        /**
         * se obtienen las coordenadas de la posición inicial y final
         */
        int filaInicio = mov.getPosInicial().getFila();
        int columnaInicio = mov.getPosInicial().getColumna();
        int filaFinal = mov.getPosFinal().getFila();
        int columnaFinal = mov.getPosFinal().getColumna();

        // Verificar movimiento vertical (misma columna)
        if (columnaInicio == columnaFinal) {
            int paso;
            if (filaFinal > filaInicio) {
                paso = 1; // Movimiento hacia abajo
            } else {
                paso = -1; // Movimiento hacia arriba
            }

            // Recorre las casillas entre la posición inicial y final
            for (int fila = filaInicio + paso; fila != filaFinal; fila += paso) {
                if (Tablero[fila][columnaInicio] != null) { // Si hay una pieza en el camino
                    System.out.println("ERROR: Hay una pieza bloqueando en: (" + fila + "," + columnaInicio + ")");
                    return true; // Hay una obstrucción
                }
            }
        }

        // Verificar movimiento horizontal (misma fila)
        else if (filaInicio == filaFinal) {
            int paso;
            if (columnaFinal > columnaInicio) {
                paso = 1; // Movimiento hacia la derecha
            } else {
                paso = -1; // Movimiento hacia la izquierda
            }

            // Recorre las casillas entre la posición inicial y final
            for (int columna = columnaInicio + paso; columna != columnaFinal; columna += paso) {
                if (Tablero[filaInicio][columna] != null) { // Si hay una pieza en el camino
                    System.out.println("ERROR: Hay una pieza bloqueando en: (" + filaInicio + "," + columna + ")");
                    return true; // Hay una obstrucción
                }
            }
        }

        // Verificar movimiento diagonal
        else if (mov.esDiagonal()) {
            int pasoFila;
            int pasoColumna;

            if (filaFinal > filaInicio) {
                pasoFila = 1;
            } else {
                pasoFila = -1;
            }

            if (columnaFinal > columnaInicio) {
                pasoColumna = 1;
            } else {
                pasoColumna = -1;
            }

            int fila = filaInicio + pasoFila;
            int columna = columnaInicio + pasoColumna;

            // Recorre las casillas entre la posición inicial y final
            while (fila != filaFinal && columna != columnaFinal) {
                if (Tablero[fila][columna] != null) { // Si hay una pieza en el camino
                    System.out.println("ERROR: Hay una pieza bloqueando en: (" + fila + "," + columna + ")");
                    return true; // Hay una obstrucción
                }
                fila += pasoFila;
                columna += pasoColumna;
            }
        }
        return false;
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
