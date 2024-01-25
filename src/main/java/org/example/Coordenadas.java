package org.example;

public class Coordenadas {

    private int x;
    private int y;

    // Constructor para inicializar las coordenadas
    public Coordenadas(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Método para mover en el eje X
    public void deltaX(int delta) {
        this.x += delta;
    }

    // Método para mover en el eje Y
    public void deltaY(int delta) {
        this.y += delta;
    }

    // Método para calcular la distancia entre dos coordenadas
    public int getDistance(Coordenadas other) {
        return Math.abs(this.x - other.x) + Math.abs(this.y - other.y);
    }

    // Getters y Setters
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
