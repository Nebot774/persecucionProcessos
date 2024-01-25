# Juego de Persecución en Java

Este proyecto es un pequeño juego de consola desarrollado en Java, donde un jugador intenta evitar ser atrapado por varios enemigos. Se implementa utilizando el patrón de diseño Observer para manejar la interacción entre el jugador y los enemigos.

## Descripción

El juego consiste en un jugador y varios enemigos en un entorno de cuadrícula 2D. El jugador puede moverse en cuatro direcciones (arriba, abajo, izquierda, derecha) usando las teclas `w`, `s`, `a`, `d`. Los enemigos se mueven automáticamente en respuesta a los movimientos del jugador, tratando de capturarlo. La partida termina cuando uno de los enemigos atrapa al jugador.

## Características

- Implementación del patrón Observer para la interacción entre el jugador y los enemigos.
- Movimiento del jugador a través de entradas de teclado.
- Enemigos que siguen automáticamente al jugador.
- Finalización del juego cuando el jugador es atrapado.

## Cómo Jugar

1. Ejecuta `Main.java`.
2. Usa las teclas `w`, `a`, `s`, `d` para mover al jugador.
3. El juego muestra la posición del jugador y de los enemigos después de cada movimiento.
4. Si un enemigo atrapa al jugador, se muestra un mensaje y el juego termina.

## Requisitos

- Java 8 o superior.

## Estructura del Proyecto

El proyecto contiene las siguientes clases principales:

- `Main`: Clase principal que ejecuta el juego.
- `Jugador`: Representa al jugador en el juego. Notifica a los enemigos sobre sus movimientos.
- `Enemigo`: Implementa la interfaz `Observador` y sigue al jugador.
- `Observador`: Una interfaz para las entidades que observan los movimientos del jugador.

## Autor

Adrià Nebot Clemente


