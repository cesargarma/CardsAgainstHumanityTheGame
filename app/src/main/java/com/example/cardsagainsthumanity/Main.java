package com.example.cardsagainsthumanity;


/**
 * La clase main simplemente inicia el juego,
 * especifica el numero de rondas que se van a jugar
 * y muestra el nombre del ganador al final
 * <br/>
 * <a href="https://github.com/cesargarma/CardsAgainstHumanityTheGame">Enlace a la pagina de git del proyecto</a>
 *
 * @author Golthork
 * @author Daasty
 * @version 1.0
 */


public class Main {
    public static void main(String[] args) {
        GameInit.iniciarjuego();
        for (int i = 0; i < 10; i++) {
            Game.start();
        }
        System.out.println(Game.getGanador().toUpperCase());
        System.out.println("\n\n\n¡¡¡¡FIN DEL JUEGO!!!!");
    }
}