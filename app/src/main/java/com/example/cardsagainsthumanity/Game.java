package com.example.cardsagainsthumanity;

import java.util.Scanner;

import static com.example.cardsagainsthumanity.GameInit.players;

public class Game {

    public static String[] whiteCards = new String[players.length-1];

    public static void start(){

        //Busca al master de la ronda y lo muestra en pantalla
        int master = lookForMaster();
        System.out.println("\n\nEl master de esta ronda es: "+players[master].getName());

        //al jugador con rango de master le adjudica una carta negra aleatoria
        //se comunica con la clase player para solicitar la carta negra
        //y de ahi va a la clase Cards para obtenerla
        players[master].setBlackCards();
        System.out.println("Carta negra: \n"+players[master].getBlackCard());

        //comienza el juego
        play();
    }

    //Busca el master entre todos los jugadores
    //Sale al primer resultado obtenido
    private static int lookForMaster(){
        for (int i = 0; i < players.length; i++){
            if(players[i].isMaster()) return i;

        }
        return -1;
    }

    //El juego como tal
    private static void play() {
        chooseWhiteCard();
        winner();
        mostrarDatos();
    }

    //va jugador por jugador
    //a excepcion del master
    //muestra las cartas blancas que tienen, les pide que escojan una
    //la escogida la almacena en un vector para mostrar al master
    //y la sustituye por una nueva
    private static void chooseWhiteCard() {
        Scanner teclado = new Scanner(System.in);
        int k = 0;

        for (int i = 0; i < players.length; i++) {
            if(!players[i].isMaster()){ //Busca jugadores que no sean master para que escojan carta blanca

                System.out.println();
                System.out.println("Turno del siguiente jugador: "+players[i].getName());


                //Muestra a los jugadores todas las cartas blancas que tienen
                for (int j = 0; j < players[i].getnCards(); j++) {
                    System.out.println((j+1) +"- "+players[i].getCards(j));
                }

                //solicita al jugador que escoja la carta que desea mostrar al master en esa ronda
                System.out.println("Elige una carta (1-"+players[i].getnCards()+")");
                int opcion = Integer.parseInt(teclado.nextLine()) - 1;

                //almacena la carta elegida en el array whiteCards
                //solicita una nueva carta blanca para sustituir a la elegida
                System.out.println("Elegida la carta: "+players[i].getCards(opcion));
                whiteCards[k++] = players[i].getCards(opcion);
                players[i].setCards(opcion);
            }
        }
    }

    //Se le muestran todas las cartas blancas elegidas por los jugadores al master
    //y se le pide a este que elija una para ser la ganadora de la ronda
    //el jugador que selecciono la carta ganadora gana un punto y se convierte en master
    private static void winner() {
        System.out.println("\n\nTurno del master: "+players[lookForMaster()].getName());
        System.out.println("Carta negra: \n"+players[lookForMaster()].getBlackCard());
        System.out.println("\n\nElige la carta ganadora (1-"+whiteCards.length+"): ");

        //Muestra todas las cartas blancas a elegir como ganadoras
        for (int i = 0; i < whiteCards.length; i++) {
            System.out.println((i+1) + "- "+ whiteCards[i]);
        }

        //Solicita que elija una ganadora
        Scanner teclado = new Scanner(System.in);
        int opcion = Integer.parseInt(teclado.nextLine()) - 1;
        System.out.println("Carta ganadora: "+whiteCards[opcion]);

        //Si el turno del master es menor o igual que la opcion elegida, esta opcion, como numero,
        //se debe incrementar en uno para que coincida con el jugador que la seleccionó
        if(lookForMaster() <= opcion) opcion++;
        System.out.println("El ganador es: "+players[opcion].getName());


        //ajusta el rol de master y entrega el punto al ganador
        players[lookForMaster()].setMaster();

        players[opcion].setScore();
        players[opcion].setMaster();

    }

    private static void mostrarDatos() {
        for (int i = 0; i < players.length; i++) {
            System.out.println();
            System.out.println(players[i]);
            System.out.println();
        }
    }

    public static String getGanador(){
        int score = players[0].getScore();
        int temp = 0;
        for (int i = 1; i < players.length; i++) {
            if(players[i].getScore()>score){
                score = players[i].getScore();
                temp = i;
            }
        }
        return players[temp].getName();
    }
}
