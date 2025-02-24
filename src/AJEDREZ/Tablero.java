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
        System.out.println("  A     B    C    D    E    F    G    H");
        System.out.println("---------------------------------------");
        for (int i = 0; i < 8; i++) {
            System.out.print((8 - i) + "|  ");
            for (int j = 0; j < 8; j++) {
                if (Tablero[i][j] != null) {
                    System.out.print(Tablero[i][j].getNombre() + "   ");
                } else {
                    System.out.print(".    ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * metodo que mueve una pieza en el tablero si el movimiento es valido
     * @param mov movimiento que contiene la posición inicial y final
     * @return true si el movimiento se realizó correctamente, false si no fue valido
     */
    public boolean mover(Movimiento mov) {
        boolean movimientoValido = false; //controla si el movimiento es válido
        boolean finDelJuego = false; //indica si el juego debe finalizar

        Pieza pieza = devuelvePieza(mov.getPosInicial());
        Pieza destino = devuelvePieza(mov.getPosFinal());

        if (pieza != null) {
            if (destino == null || destino.getColor() != pieza.getColor()) { //si la casilla final está vacia o tiene una pieza enemiga
                if (pieza.validoMovimiento(mov, this)) { //si el movimiento es valido

                    //no he programado jaque mate, esta es una solucion rapida para el fin del juego.
                    if (destino != null) {
                        String nombreDestino = destino.getNombre();
                        if (nombreDestino.equals("\u2654") || nombreDestino.equals("\u265A")) {
                            finDelJuego = true; //adios Rey
                        }
                        quitaPieza(mov.getPosFinal()); //captura la pieza enemiga
                    }

                    //se realiza el movimiento
                    ponPieza(pieza, mov.getPosFinal());
                    quitaPieza(mov.getPosInicial());

                    //se cambia el turno tras un movimiento válido
                    Juego.cambiarTurno();

                    movimientoValido = true;
                }
            }
        }
        if (finDelJuego) {
            System.out.println("¡El Rey ha sido capturado! Fin del juego");
        }
        return movimientoValido;
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


    /**
     * Verifica si hay piezas bloqueando el camino en un movimiento dado
     * @param mov movimiento que se quiere realizar
     * @return true si hay piezas en el camino, false si el camino esta libre
     */
    public boolean hayPiezasEntre(Movimiento mov) {
        //coordenadas iniciales y finales
        int filaInicio = mov.getPosInicial().getFila();
        int columnaInicio = mov.getPosInicial().getColumna();
        int filaFinal = mov.getPosFinal().getFila();
        int columnaFinal = mov.getPosFinal().getColumna();

        boolean bloqueo = false; //variable booleana para indicar si hay piezas bloqueando

        //verificar movimiento vertical
        if (columnaInicio == columnaFinal) {
            int paso;
            if (filaFinal > filaInicio) {
                paso = 1; //hacia abajo
            } else {
                paso = -1; //hacia arriba
            }

            for (int fila = filaInicio + paso; fila != filaFinal; fila += paso) {
                if (Tablero[fila][columnaInicio] != null) {
                    bloqueo = true;
                }
            }
        }
        //verificar movimiento horizontal
        else if (filaInicio == filaFinal) {
            int paso;
            if (columnaFinal > columnaInicio) {
                paso = 1; //hacia la derecha
            } else {
                paso = -1; //hacia la izquierda
            }

            for (int columna = columnaInicio + paso; columna != columnaFinal; columna += paso) {
                if (Tablero[filaInicio][columna] != null) {
                    bloqueo = true;
                }
            }
        }
        //verificar movimiento diagonal
        else if (mov.esDiagonal()) {
            int pasoFila;
            if (filaFinal > filaInicio) { //baja o sube
                pasoFila = 1;
            } else {
                pasoFila = -1;
            }

            int pasoColumna;
            if (columnaFinal > columnaInicio) {//derecha o izquierda
                pasoColumna = 1;
            } else {
                pasoColumna = -1;
            }

            int fila = filaInicio + pasoFila;
            int columna = columnaInicio + pasoColumna;

            while (fila != filaFinal && columna != columnaFinal) {
                //si no esta vacio se bloquea
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
