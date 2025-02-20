package AJEDREZ;

public abstract class Pieza {
    private String nombre;
    private boolean color;

    public Pieza(boolean color) {
        this.color = color;
    }

    public boolean getColor() {
        return color;
    }
    public void setColor(boolean color) {
        this.color = color;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract boolean validoMovimiento(Movimiento mov, Tablero tablero);

    @Override
    public String toString() {
        return nombre;
    }
}
