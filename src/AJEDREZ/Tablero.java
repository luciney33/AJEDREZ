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
     * Método que mueve una pieza en el tablero si el movimiento es válido.
     * @param mov Movimiento que contiene la posición inicial y final.
     * @return true si el movimiento se realizó correctamente, false si no fue válido.
     */
    public boolean mover(Movimiento mov) {
        boolean movimientoValido = false; // Controla si el movimiento es válido
        boolean finDelJuego = false; // Indica si el juego debe finalizar

        Pieza pieza = devuelvePieza(mov.getPosInicial());
        Pieza destino = devuelvePieza(mov.getPosFinal());

        if (pieza != null) { // Si hay una pieza en la posición inicial
            if (destino == null || destino.getColor() != pieza.getColor()) { // Si la casilla final está vacía o tiene una pieza enemiga
                if (pieza.validoMovimiento(mov, this)) { // Si el movimiento es válido

                    // 🔹 Verifica si se ha capturado al Rey comparando nombres en vez de símbolos
                    if (destino != null) {
                        String nombreDestino = destino.getNombre();
                        if (nombreDestino.equals("\u2654") || nombreDestino.equals("\u265A")) {
                            finDelJuego = true; // Se ha capturado el Rey
                        }
                        quitaPieza(mov.getPosFinal()); // Captura la pieza enemiga
                    }

                    // Se realiza el movimiento
                    ponPieza(pieza, mov.getPosFinal());
                    quitaPieza(mov.getPosInicial());

                    // Se cambia el turno tras un movimiento válido
                    Juego.cambiarTurno();

                    movimientoValido = true; // Se marca como movimiento válido
                }
            }
        }

        // Si el juego ha terminado, se notifica (esto se manejará en la interfaz gráfica FX)
        if (finDelJuego) {
            // Aquí en lugar de imprimir, podemos hacer que el método devuelva un estado especial o lo notifique de otra forma
            System.out.println("¡El Rey ha sido capturado! Fin del juego.");
        }

        return movimientoValido; // Devuelve si el movimiento fue válido o no
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
     * Verifica si hay piezas bloqueando el camino en un movimiento dado.
     * @param mov Movimiento que se quiere realizar
     * @return true si hay piezas en el camino, false si el camino está libre.
     */
    public boolean hayPiezasEntre(Movimiento mov) {
        // Obtener coordenadas iniciales y finales
        int filaInicio = mov.getPosInicial().getFila();
        int columnaInicio = mov.getPosInicial().getColumna();
        int filaFinal = mov.getPosFinal().getFila();
        int columnaFinal = mov.getPosFinal().getColumna();

        boolean bloqueo = false; // Variable booleana para indicar si hay piezas bloqueando

        // Verificar movimiento vertical (misma columna)
        if (columnaInicio == columnaFinal) {
            int paso;
            if (filaFinal > filaInicio) {
                paso = 1; // Movimiento hacia abajo
            } else {
                paso = -1; // Movimiento hacia arriba
            }

            for (int fila = filaInicio + paso; fila != filaFinal; fila += paso) {
                if (Tablero[fila][columnaInicio] != null) {
                    bloqueo = true;
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

            for (int columna = columnaInicio + paso; columna != columnaFinal; columna += paso) {
                if (Tablero[filaInicio][columna] != null) {
                    bloqueo = true;
                }
            }
        }
        // Verificar movimiento diagonal
        else if (mov.esDiagonal()) {
            int pasoFila;
            if (filaFinal > filaInicio) {
                pasoFila = 1;
            } else {
                pasoFila = -1;
            }

            int pasoColumna;
            if (columnaFinal > columnaInicio) {
                pasoColumna = 1;
            } else {
                pasoColumna = -1;
            }

            int fila = filaInicio + pasoFila;
            int columna = columnaInicio + pasoColumna;

            while (fila != filaFinal && columna != columnaFinal) {
                if (Tablero[fila][columna] != null) {
                    bloqueo = true;
                }
                fila += pasoFila;
                columna += pasoColumna;
            }
        }

        return bloqueo;
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
