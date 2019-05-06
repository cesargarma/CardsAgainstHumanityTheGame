package com.example.cardsagainsthumanity;

import java.util.Scanner;

import static com.example.cardsagainsthumanity.GameInit.players;

public class Game {

    public static String[] whiteCards = new String[players.length-1];

    public static void start(){

        int master = lookForMaster();
        System.out.println("\n\nEl master de esta ronda es: "+players[master].getName());

        players[master].setBlackCards();
        System.out.println("Carta negra: \n"+players[master].getBlackCard());

        play();
    }

    private static int lookForMaster(){
        for (int i = 0; i < players.length; i++){
            if(players[i].isMaster()) return i;

        }
        return -1;
    }

    private static void play() {
        chooseWhiteCard();
        winner();
    }

    private static void chooseWhiteCard() {
        Scanner teclado = new Scanner(System.in);

        for (int i = 0; i < players.length; i++) {
            if(!players[i].isMaster()){

                System.out.println();
                System.out.println("Turno del siguiente jugador: "+players[i].getName());


                for (int j = 0; j < players[i].getnCards(); j++) {
                    System.out.println(players[i].getCards(j));
                }

                System.out.println("Elige una carta (1-"+players[i].getnCards()+")");
                int opcion = Integer.parseInt(teclado.nextLine()) - 1;

                System.out.println("Elegida la carta: "+players[i].getCards(opcion));
                whiteCards[i] = players[i].getCards(opcion);
            }
        }
    }

    private static void winner() {
        System.out.println("\n\nTurno del master: "+players[lookForMaster()].getName());
        System.out.println("Elige la carta ganadora (1-"+whiteCards.length+"): ");
        for (int i = 0; i < whiteCards.length; i++) {
            System.out.println(i + "- "+ whiteCards[i]);
        }
        Scanner teclado = new Scanner(System.in);
        int opcion = Integer.parseInt(teclado.nextLine()) - 1;
        System.out.println("Carta ganadora: "+whiteCards[opcion]);
    }
}
