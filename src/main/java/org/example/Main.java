package org.example;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;


import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        partida();
    }

    //metodo para iniciar i jugar la partida
    public static void partida() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int jugadorX, jugadorY;

        // Generar posición inicial para el jugador
        jugadorX = random.nextInt(31);
        jugadorY = random.nextInt(31);

        //creamos el jugador
        Jugador jugador = new Jugador(jugadorX, jugadorY);

        // Creamos y agregamos tres enemigos
        for (int i = 0; i < 3; i++) {
            int enemigoX, enemigoY;
            do {
                enemigoX = random.nextInt(31);
                enemigoY = random.nextInt(31);
            } while (Math.abs(jugadorX - enemigoX) + Math.abs(jugadorY - enemigoY) < 5);

            //creamos el enemigo con sus posiciones y lo añadimos al array de observadores
            Enemigo enemigo = new Enemigo(enemigoX, enemigoY);
            jugador.agregarObservador(enemigo);

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
                    //Despues de cada movimiento Verificar si alguno de los enemigos ha atrapado al jugador
                    for (Observador observador : jugador.getObservadores()) {
                        Enemigo enemigo = (Enemigo) observador;
                        atrapado = (jugador.getX() == enemigo.getX()) && (jugador.getY() == enemigo.getY());
                        if (atrapado) {
                            System.out.println("¡Jugador atrapado por el enemigo!");
                            break;
                        }
                    }
                    if (atrapado) break;
                }
            }
        } while (!input.equals("q") && !atrapado);//si es atrapado o el jugador pulsa q se acaba el juego

        scanner.close();
        System.out.println("Juego terminado.");
    }
}




