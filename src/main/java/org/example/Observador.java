package org.example;

public interface Observador {
    //Esta interfaz sera implementada por enemigo y cada vez que el jugador se mueva se llamara al metodo actualizar
    void actualizar(int x, int y);

}
