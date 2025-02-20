package AJEDREZ;

public class Movimiento {
    private Posicion posInicial;
    private Posicion posFinal;

    public Movimiento() {}
    public Movimiento(Posicion posInicial, Posicion posFinal) {
        this.posInicial = posInicial;
        this.posFinal = posFinal;
    }
    public Posicion getPosInicial() {
        return posInicial;
    }

    public Posicion getPosFinal() {
        return posFinal;
    }
    public boolean esVertical() {
        return posInicial.getColumna() == posFinal.getColumna(); // Solo verifica la columna
    }

    public boolean esHorizontal() {
        return posInicial.getFila() == posFinal.getFila(); // Solo verifica la fila
    }

    public boolean esDiagonal(){
        return Math.abs(posFinal.getFila() - posInicial.getFila()) == Math.abs(posFinal.getColumna() - posInicial.getColumna());
    }

    public int saltoHorizontal() {
        return posFinal.getColumna() - posInicial.getColumna(); // Devuelve positivo o negativo
    }
    public int saltoVertical() {
        return posFinal.getFila() - posInicial.getFila();
    }
    @Override
    public String toString() {
        return "Movimiento{" +
                "Inicio=" + posInicial +
                ", Fin=" + posFinal +
                '}';
    }
}
