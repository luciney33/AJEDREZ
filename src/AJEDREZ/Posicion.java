package AJEDREZ;

public class Posicion {
    private int fila;
    private int columna;

    public Posicion() {}

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




