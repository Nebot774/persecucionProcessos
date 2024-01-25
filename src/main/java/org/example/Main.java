package org.example;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;


import javafx.collections.ObservableList;

public class Main {
    public static void main(String[] args) {
        partida();
    }

    public static void partida() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int jugadorX, jugadorY;

        // Generar posición inicial para el jugador
        jugadorX = random.nextInt(31);
        jugadorY = random.nextInt(31);
        Jugador jugador = new Jugador(jugadorX, jugadorY);

        // Suscribir enemigos a las posiciones del jugador
        for (int i = 0; i < 3; i++) {
            int enemigoX, enemigoY;
            do {
                enemigoX = random.nextInt(31);
                enemigoY = random.nextInt(31);
            } while (Math.abs(jugadorX - enemigoX) + Math.abs(jugadorY - enemigoY) < 5);

            Enemigo enemigo = new Enemigo(enemigoX, enemigoY);
            jugador.getPosiciones().addListener(enemigo);
            System.out.println("Posición inicial del enemigo " + (i+1) + ": (" + enemigoX + ", " + enemigoY + ")");
        }

        System.out.println("El juego ha comenzado!");
        System.out.println("Posición inicial del jugador: (" + jugadorX + ", " + jugadorY + ")");
        System.out.println("Usa las teclas a (izquierda), d (derecha), w (arriba) y s (abajo) para mover al jugador. Presiona 'q' para salir.");

        String input;
        boolean atrapado = false;
        do {
            input = scanner.nextLine();
            if (!input.isEmpty()) {
                char movimiento = input.charAt(0);
                if (movimiento == 'a' || movimiento == 'd' || movimiento == 'w' || movimiento == 's') {
                    jugador.mover(movimiento);
                    // Comprobar si el jugador ha sido atrapado después de cada movimiento
                    ObservableList<Coordenadas> posiciones = jugador.getPosiciones();
                    Coordenadas ultimaPosicion = posiciones.get(posiciones.size() - 1);
                    for (Enemigo enemigo : jugador.getPosiciones().getListeners(Enemigo.class)) {
                        if (ultimaPosicion.getX() == enemigo.getX() && ultimaPosicion.getY() == enemigo.getY()) {
                            System.out.println("¡Jugador atrapado por el enemigo!");
                            atrapado = true;
                            break;
                        }
                    }
                }
            }
        } while (!input.equals("q") && !atrapado);

        scanner.close();
        System.out.println("Juego terminado.");
    }
}




