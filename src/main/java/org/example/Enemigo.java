package org.example;

import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class Enemigo extends Coordenadas implements ListChangeListener<Coordenadas> {

    public Enemigo(int startX, int startY) {
        super(startX, startY);
    }

    public void followPlayer(ObservableList<Coordenadas> playerPositions) {
        playerPositions.addListener(this);
    }

    @Override
    public void onChanged(Change<? extends Coordenadas> change) {
        while (change.next()) {
            if (change.wasAdded()) {
                Coordenadas newPlayerPosition = change.getAddedSubList().get(0);
                moveToPlayer(newPlayerPosition);
                System.out.println("Enemigo se ha movido a: (" + getX() + "," + getY() + ")");
            }
        }
    }


    private void moveToPlayer(Coordenadas playerPosition) {
        // Implementa la lógica para mover al enemigo hacia el jugador
        for (int i = 0; i < 2; i++) { // Moverse dos veces
            int deltaX = playerPosition.getX() - this.getX();
            int deltaY = playerPosition.getY() - this.getY();

            if (Math.abs(deltaX) > Math.abs(deltaY)) {
                deltaX(Integer.signum(deltaX)); // Moverse un paso en X
            } else if (deltaY != 0) {
                deltaY(Integer.signum(deltaY)); // Moverse un paso en Y
            }
        }
    }
}


