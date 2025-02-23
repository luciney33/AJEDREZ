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
<<<<<<< HEAD
        return posInicial.getColumna() == posFinal.getColumna(); // Solo verifica la columna
    }

    public boolean esHorizontal() {
        return posInicial.getFila() == posFinal.getFila(); // Solo verifica la fila
=======
        return posInicial.getColumna() == posFinal.getColumna(); // ✅ Solo verifica la columna
    }

    public boolean esHorizontal() {
        return posInicial.getFila() == posFinal.getFila(); // ✅ Solo verifica la fila
>>>>>>> 6cf971d51430ebfe80295f177d90df608bfa0602
    }

    public boolean esDiagonal(){
        return Math.abs(posFinal.getFila() - posInicial.getFila()) == Math.abs(posFinal.getColumna() - posInicial.getColumna());
    }

    public int saltoHorizontal() {
<<<<<<< HEAD
        return posFinal.getColumna() - posInicial.getColumna(); // Devuelve positivo o negativo
=======
        return posFinal.getColumna() - posInicial.getColumna(); // ✅ Devuelve positivo o negativo
>>>>>>> 6cf971d51430ebfe80295f177d90df608bfa0602
    }
    public int saltoVertical() {
        return posFinal.getFila() - posInicial.getFila();
    }
<<<<<<< HEAD
    @Override
    public String toString() {
        return "Movimiento{" +
                "Inicio=" + posInicial +
                ", Fin=" + posFinal +
                '}';
    }
=======
>>>>>>> 6cf971d51430ebfe80295f177d90df608bfa0602
}
