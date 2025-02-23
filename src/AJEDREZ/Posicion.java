package AJEDREZ;

<<<<<<< HEAD
//La clase Posicion representa una posición en el tablero de ajedrez,utilizando coordenadas de fila y columna.
public class Posicion {
    private int fila;     // Almacena la fila de la posición en el tablero
    private int columna;  // Almacena la columna de la posición en el tablero

    //Constructor vacío: permite crear una posición sin valores iniciales.
    public Posicion() {}

    //Constructor que inicializa la posición con valores específicos de fila y columna.
=======
public class Posicion{
    private int fila;
    private int columna;

    public Posicion() {}
>>>>>>> 6cf971d51430ebfe80295f177d90df608bfa0602
    public Posicion(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    @Override
    public String toString() {
        return "Posicion{" +
                "fila=" + fila +
                ", columna=" + columna +
                '}';
    }
}
<<<<<<< HEAD

=======
>>>>>>> 6cf971d51430ebfe80295f177d90df608bfa0602
