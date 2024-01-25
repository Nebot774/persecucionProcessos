package org.example;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
    //atributos
    private int x;
    private int y;

    //lsita de observadores
    private List<Observador> observadores;

    //constructor
    public Jugador(int x, int y) {
        this.x = x;
        this.y = y;
        this.observadores = new ArrayList<>();
    }

    //metodo para mover al jugador
    public void mover(char direccion) {
        switch (direccion) {
            case 'a': // izquierda
                x--;
                break;
            case 'd': // derecha
                x++;
                break;
            case 'w': // arriba
                y--;
                break;
            case 's': // abajo
                y++;
                break;
        }
        System.out.println("Nueva posición del jugador: (" + x + ", " + y + ")");
        notificarObservadores();//cada vez que el jugador se mueva se notificara a los observadores
    }

    //metodo para agregar observadores
    public void agregarObservador(Observador observador) {
        observadores.add(observador);
    }

    //metodo para notificar a los observadores
    public void notificarObservadores() {
        for (Observador observador : observadores) {
            observador.actualizar(x, y);
        }
    }

    //metodo para obtener la lista de observadores
    public List<Observador> getObservadores() {
        return observadores;
    }

    // Métodos getters para x e y
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


}
