package AJEDREZ;

<<<<<<< HEAD
import java.util.Scanner;

=======
>>>>>>> 6cf971d51430ebfe80295f177d90df608bfa0602
public class Tablero {
    private Pieza Tablero[][] = new Pieza[8][8];

    Tablero() {
<<<<<<< HEAD
        // Se recorre el tablero para asegurarse de que todas las casillas inicien vacías (null)
=======
>>>>>>> 6cf971d51430ebfe80295f177d90df608bfa0602
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Tablero[i][j] = null;
            }
        }
<<<<<<< HEAD
        // Colocamos las piezas negras en la fila 0
=======

>>>>>>> 6cf971d51430ebfe80295f177d90df608bfa0602
        Tablero[0][0] = new Torre(false);
        Tablero[0][1] = new Caballo(false);
        Tablero[0][2] = new Alfil(false);
        Tablero[0][3] = new Dama(false);
        Tablero[0][4] = new Rey(false);
        Tablero[0][5] = new Alfil(false);
        Tablero[0][6] = new Caballo(false);
        Tablero[0][7] = new Torre(false);
<<<<<<< HEAD

        // Colocamos los peones negros en la fila 1
=======
>>>>>>> 6cf971d51430ebfe80295f177d90df608bfa0602
        for (int i = 0; i < 8; i++) {
            Tablero[1][i] = new Peon(false);
        }

<<<<<<< HEAD
        // Colocamos las piezas blancas en la fila 7
=======
>>>>>>> 6cf971d51430ebfe80295f177d90df608bfa0602
        Tablero[7][0] = new Torre(true);
        Tablero[7][1] = new Caballo(true);
        Tablero[7][2] = new Alfil(true);
        Tablero[7][3] = new Dama(true);
        Tablero[7][4] = new Rey(true);
        Tablero[7][5] = new Alfil(true);
        Tablero[7][6] = new Caballo(true);
        Tablero[7][7] = new Torre(true);
<<<<<<< HEAD

        // Colocamos los peones blancos en la fila 6
=======
>>>>>>> 6cf971d51430ebfe80295f177d90df608bfa0602
        for (int i = 0; i < 8; i++) {
            Tablero[6][i] = new Peon(true);
        }
    }

    public void pintarTablero() {
<<<<<<< HEAD
        System.out.println("  A  B  C  D  E  F  G  H"); // Encabezado de columnas
=======
        System.out.println("  A B C D E F G H"); // Encabezado de columnas
>>>>>>> 6cf971d51430ebfe80295f177d90df608bfa0602
        for (int i = 0; i < 8; i++) {
            System.out.print((8 - i) + " "); // Número de fila (8 a 1)
            for (int j = 0; j < 8; j++) {
                if (Tablero[i][j] != null) {
<<<<<<< HEAD
                    System.out.print(Tablero[i][j].getNombre() + "  ");
                } else {
                    System.out.print(".   ");
                }
            }
            System.out.println();
=======
                    System.out.print(Tablero[i][j].getNombre() + " ");
                } else {
                    System.out.print(".  "); // Ahora sí imprimimos correctamente los puntos
                }
            }
            System.out.println(); // Salto de línea para la siguiente fila
>>>>>>> 6cf971d51430ebfe80295f177d90df608bfa0602
        }
        System.out.println();
    }

<<<<<<< HEAD

=======
>>>>>>> 6cf971d51430ebfe80295f177d90df608bfa0602
    public void mover(Movimiento mov) {
        Pieza pieza = devuelvePieza(mov.getPosInicial()); // Obtener la pieza en la posición inicial
        Pieza destino = devuelvePieza(mov.getPosFinal()); // Obtener la pieza en la posición final

        if (pieza == null) {
<<<<<<< HEAD
            System.out.println("ERROR: No hay pieza en la posición inicial.");
=======
            System.out.println("❌ No hay pieza en la posición inicial.");
>>>>>>> 6cf971d51430ebfe80295f177d90df608bfa0602
            return;
        }

        // Verifica si la casilla final contiene una pieza aliada
        if (destino != null && destino.getColor() == pieza.getColor()) {
<<<<<<< HEAD
            System.out.println("ERROR: No puedes capturar tu propia pieza en " + mov.getPosFinal());
            return;
        }
        // No permito capturar al rey porque en ajedrez no se puede, aunque no implementé jaque ni jaque mate.
        if (destino != null && destino instanceof Rey) {
            System.out.println("ERROR: No puedes capturar al rey.");
=======
            System.out.println("❌ No puedes capturar tu propia pieza en " + mov.getPosFinal());
>>>>>>> 6cf971d51430ebfe80295f177d90df608bfa0602
            return;
        }

        // Validar si el movimiento es correcto para esa pieza
        if (!pieza.validoMovimiento(mov, this)) {
<<<<<<< HEAD
            System.out.println("ERROR: Movimiento inválido para la pieza.");
=======
            System.out.println("❌ Movimiento inválido para la pieza.");
>>>>>>> 6cf971d51430ebfe80295f177d90df608bfa0602
            return;
        }

        // Si hay una pieza enemiga, se captura (la eliminamos del tablero)
        if (destino != null && destino.getColor() != pieza.getColor()) {
<<<<<<< HEAD
            System.out.println("Capturaste una pieza enemiga en " + mov.getPosFinal());
            quitaPieza(mov.getPosFinal());  // Elimina la pieza enemiga
        }

        // Verificar si el peón ha llegado a la última fila y permitir promoción
        if (pieza instanceof Peon) {
            int filaFinal = mov.getPosFinal().getFila();

            if ((pieza.getColor() && filaFinal == 0) || (!pieza.getColor() && filaFinal == 7)) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("¡Tu peón ha llegado al final! ¿En qué pieza quieres convertirlo? (D/T/A/C)");
                System.out.print("Introduce D (Dama), T (Torre), A (Alfil) o C (Caballo): ");

                String eleccion = scanner.nextLine().toUpperCase();
                switch (eleccion) {
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

        ponPieza(pieza, mov.getPosFinal());  // Mueve la pieza
        quitaPieza(mov.getPosInicial());     // Borra la pieza de la posición original

        System.out.println("Movimiento realizado.");

        // Cambia el turno después del movimiento
        Juego.cambiarTurno();
    }


    //Verifica si hay una pieza en una posición específica del tablero
=======
            System.out.println("⚔️ Capturaste una pieza enemiga en " + mov.getPosFinal());
            quitaPieza(mov.getPosFinal());  // Elimina la pieza enemiga
        }

        ponPieza(pieza, mov.getPosFinal());  // Mueve la pieza
        quitaPieza(mov.getPosInicial());     // Borra la pieza de la posición original

        System.out.println("✅ Movimiento realizado.");
    }


>>>>>>> 6cf971d51430ebfe80295f177d90df608bfa0602
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
<<<<<<< HEAD
        // Se obtienen las coordenadas de la posición inicial y final
=======
>>>>>>> 6cf971d51430ebfe80295f177d90df608bfa0602
        int filaInicio = mov.getPosInicial().getFila();
        int columnaInicio = mov.getPosInicial().getColumna();
        int filaFinal = mov.getPosFinal().getFila();
        int columnaFinal = mov.getPosFinal().getColumna();

        // Movimiento vertical (misma columna)
        if (columnaInicio == columnaFinal) {
<<<<<<< HEAD
            int paso;
            if (filaFinal > filaInicio) {
                paso = 1;
            } else {
                paso = -1;
            }
            // Recorre las casillas entre la posición inicial y final
            for (int fila = filaInicio + paso; fila != filaFinal; fila += paso) {
                if (Tablero[fila][columnaInicio] != null) { // Si hay una pieza en el camino
                    System.out.println("ERROR: Hay una pieza bloqueando en: (" + fila + "," + columnaInicio + ")");
=======
            int paso = (filaFinal > filaInicio) ? 1 : -1;
            for (int fila = filaInicio + paso; fila != filaFinal; fila += paso) { // 🔹 Arreglado el límite
                if (Tablero[fila][columnaInicio] != null) {
                    System.out.println("❌ Hay una pieza bloqueando en: (" + fila + "," + columnaInicio + ")");
>>>>>>> 6cf971d51430ebfe80295f177d90df608bfa0602
                    return true;
                }
            }
        }

        // Movimiento horizontal (misma fila)
        else if (filaInicio == filaFinal) {
<<<<<<< HEAD
            int paso;
            if (columnaFinal > columnaInicio) {
                paso = 1; // Movimiento hacia la derecha
            } else {
                paso = -1; // Movimiento hacia la izquierda
            }
            for (int columna = columnaInicio + paso; columna != columnaFinal; columna += paso) {
                if (Tablero[filaInicio][columna] != null) {
                    System.out.println("ERROR: Hay una pieza bloqueando en: (" + filaInicio + "," + columna + ")");
=======
            int paso = (columnaFinal > columnaInicio) ? 1 : -1;
            for (int columna = columnaInicio + paso; columna != columnaFinal; columna += paso) { // 🔹 Arreglado el límite
                if (Tablero[filaInicio][columna] != null) {
                    System.out.println("❌ Hay una pieza bloqueando en: (" + filaInicio + "," + columna + ")");
>>>>>>> 6cf971d51430ebfe80295f177d90df608bfa0602
                    return true;
                }
            }
        }

<<<<<<< HEAD
        // Movimiento diagonal (misma diferencia de filas y columnas)
        else if (mov.esDiagonal()) {
            int pasoFila, pasoColumna;

            if (filaFinal > filaInicio) {
                pasoFila = 1; // Movimiento hacia abajo
            } else {
                pasoFila = -1; // Movimiento hacia arriba
            }

            if (columnaFinal > columnaInicio) {
                pasoColumna = 1;
            } else {
                pasoColumna = -1;
            }

            int fila = filaInicio + pasoFila;
            int columna = columnaInicio + pasoColumna;

            while (fila != filaFinal && columna != columnaFinal) {
                if (Tablero[fila][columna] != null) {
                    System.out.println("ERROR: Hay una pieza bloqueando en: (" + fila + "," + columna + ")");
                    return true;
                }
                fila += pasoFila;
                columna += pasoColumna;
            }
        }

        return false; // No hay piezas bloqueando
=======
        return false; // 🔹 No hay piezas bloqueando
>>>>>>> 6cf971d51430ebfe80295f177d90df608bfa0602
    }



<<<<<<< HEAD
=======

>>>>>>> 6cf971d51430ebfe80295f177d90df608bfa0602
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
