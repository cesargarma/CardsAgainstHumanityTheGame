package com.example.cardsagainsthumanity;

public class Main {
    public static void main(String[] args) {
        //Te gusta mas así el main, Asti?
        GameInit.iniciarjuego();
        for (int i = 0; i < 3; i++) {
            Game.start();
        }
        System.out.println("\n\n\n¡¡¡¡FIN DEL JUEGO!!!!");
    }
}