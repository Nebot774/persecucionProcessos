package org.example;

public class Enemigo implements Observador {
    private int x;
    private int y;

    public Enemigo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //metodo para actualizar la posicion del enemigo
    @Override
    public void actualizar(int jugadorX, int jugadorY) {
        // Decidimos en qué dirección nos moveremos para acercarnos al jugador
        int deltaX = jugadorX - x;
        int deltaY = jugadorY - y;

        // Se movera en la dirección X si la distancia en X es mayor que en Y
        if (Math.abs(deltaX) > Math.abs(deltaY)) {
            x += Integer.signum(deltaX) * 2; // Moverse 2 pasos hacia el jugador en el eje X
        } else {
            y += Integer.signum(deltaY) * 2; // Moverse 2 pasos hacia el jugador en el eje Y
        }

        System.out.println("Nueva posición del enemigo: (" + x + ", " + y + ")");
    }

    // Métodos getters para x e y
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}


