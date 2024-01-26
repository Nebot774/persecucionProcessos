package org.example;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;


import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;


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

        // Lista para almacenar los enemigos
        List<Enemigo> enemigos = new ArrayList<>();

        // Crear y agregar enemigos
        for (int i = 0; i < 3; i++) {
            int enemigoX, enemigoY;
            do {
                enemigoX = random.nextInt(31);
                enemigoY = random.nextInt(31);
            } while (Math.abs(jugadorX - enemigoX) + Math.abs(jugadorY - enemigoY) < 5);

            Enemigo enemigo = new Enemigo(enemigoX, enemigoY);
            jugador.getPosiciones().addListener(enemigo);
            enemigos.add(enemigo); // Añadir el enemigo a la lista

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
                    // Comprobar si algún enemigo ha atrapado al jugador
                    atrapado = enemigos.stream().anyMatch(enemigo -> jugador.getX() == enemigo.getX() && jugador.getY() == enemigo.getY());
                    if (atrapado) {
                        System.out.println("¡Jugador atrapado por el enemigo!");
                    }
                }
            }
        } while (!input.equals("q") && !atrapado);

        scanner.close();
        System.out.println("Juego terminado.");
    }
}





