package AJEDREZ;

public class Torre extends Pieza{
    public Torre(boolean color) {
        super(color);
        if (color==false){
            Torre.super.setNombre("\u2656");
        }else {
            Torre.super.setNombre("\u265C");
        }
    }


    @Override
    public boolean validoMovimiento(Movimiento mov, Tablero tablero) {
        if (mov.esHorizontal() || mov.esVertical()) { // 🔹 La torre solo se mueve en línea recta
            if (!tablero.hayPiezasEntre(mov)) { // 🔹 Evita que atraviese piezas
                return true;
            } else {
                System.out.println("❌ Movimiento bloqueado: Hay piezas en el camino.");
            }
        }
        return false;
    }

}
