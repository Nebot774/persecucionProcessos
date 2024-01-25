package org.example;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Jugador extends Coordenadas {
    // Lista observable de las posiciones del jugador
    private ObservableList<Coordenadas> posiciones;

    // Constructor
    public Jugador(int x, int y) {
        super(x, y); // Llama al constructor de Coordenadas
        this.posiciones = FXCollections.observableArrayList();
        this.posiciones.add(new Coordenadas(x, y)); // Agrega la posición inicial
    }

    // Método para mover al jugador
    public void mover(char direccion) {
        switch (direccion) {
            case 'a': // Izquierda
                deltaX(-1);
                break;
            case 'd': // Derecha
                deltaX(1);
                break;
            case 'w': // Arriba
                deltaY(-1);
                break;
            case 's': // Abajo
                deltaY(1);
                break;
        }
        System.out.println("Nueva posición del jugador: (" + getX() + ", " + getY() + ")");
        posiciones.add(new Coordenadas(getX(), getY())); // Agrega la nueva posición
    }

    // Método para obtener la lista de posiciones
    public ObservableList<Coordenadas> getPosiciones() {
        return posiciones;
    }
}



