package com.example.cardsagainsthumanity;


/**
 * La clase main simplemente inicia el juego, especificael numero de rondas que se van a jugar y muestra el nombre del ganador al final
 *
 * @author Golthork
 * @author Daasty
 * @version 1.0
 */


public class Main {
    public static void main(String[] args) {
        //Te gusta mas así el main, Asti?
        GameInit.iniciarjuego();
        for (int i = 0; i < 10; i++) {
            Game.start();
        }
        System.out.println(Game.getGanador().toUpperCase());
        System.out.println("\n\n\n¡¡¡¡FIN DEL JUEGO!!!!");
    }
}