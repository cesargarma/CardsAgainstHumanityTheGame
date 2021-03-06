package com.example.cardsagainsthumanity;

import java.util.Random;
import java.util.Scanner;

/**
 * Esta clase inicia el juego<br/>
 * Pide los datos como el numero de jugadores y el numero de cartas<br/>
 * posibilidad de que indique el modo de juego en un futuro<br/>
 * Crea jugadores, les asigna cartas blancas por primera vez<br/>
 * Asigana el rol de master de manera aleatoria por primera vez<br/>
 *
 * @author Golthork
 * @author Daasty
 * @version 1.0
 *
 */




public class GameInit {
    public static Player[] players = new Player[8];

    /**
     * Inicia el juego<br/>
     * Primero solicita informacion sobre el nº de jugadores y el nº de cartas deseadas para cada uno<br/>
     * a continuacion crea los jugadores y reparte las cartas
     */
    public static void iniciarjuego() {
        Scanner teclado = new Scanner(System.in);

        int nPlayers = 0;
        int nCards = 0;

        //Solicita el numero de jugadores a jugar, un minimo de 3 y un maximo de 8
        do {
            try{
                System.out.println("¿Cuántos jugadores van a jugar? \nMáximo de 8 jugadores, mínimo 3.");
                nPlayers = Integer.parseInt(teclado.nextLine());
                if(nPlayers < 3 || nPlayers > 8) throw new Exception("El número introducido no es válido.");
            }catch(NumberFormatException e){
                System.out.println("ERROR: Se debe de introducir un número");
            }catch(Exception e){
                System.out.println("ERROR: "+e.getMessage());
            }


        } while (nPlayers < 3 || nPlayers > 8);

        //Solicita el numero de cartas por jugador
        //el minimo es 0 y no hay limite maximo

        do {
            try{
                System.out.println("¿Cuántas cartas por jugador?");
                nCards = Integer.parseInt(teclado.nextLine());
            }catch(NumberFormatException e){
                System.out.println("ERROR: Se debe de introducir un número");
            }
        } while (nCards <= 0);

        //Crea los jugadores con los datos anteriores
        playerCraft(nPlayers, teclado, nCards);

        //Llena las manos de los jugadores de cartas por primera vez.
        repartirCartas(nCards);
        mostrarCartasEnMano(nCards);
    }

    /**
     * Sabiendo el numero de cartas que cada jugador debe tener en la mano<br/>
     * Solicita cartas aleatorias para llenar ese array por primera vez
     *
     * @param nCards    Esel numero de cartas que tiene que repartir a cada jugador, es decir, el numero de iteracciones del bucle
     */
    private static void repartirCartas(int nCards) {
        for (int i = 0; i < nCards; i++) {
            for (int j = 0; j < players.length; j++) {
                //esto comunica con la clase Player,
                //para solicitar que se llene la mano del jugador
                //una vez alli, va a la clase Cards para solicitar las cartas correspondientes
                players[j].setCards(i);
            }
        }
    }


    /**
     * Muestra las cartas en mano de cada jugador
     *
     * @param nCards    Es el numero de cartas en mano de cada jugador, es decir, el numero de iteracciones del bucle.
     */
    public static void mostrarCartasEnMano(int nCards) {

        System.out.print("\n\n¡CARTAS DE CADA JUGADOR!");

        for (int i = 0; i < players.length; i++) {
            System.out.println();
            System.out.println(players[i].getName());

            for (int j = 0; j < nCards; j++) {
                System.out.println(players[i].getCards(j));
            }
        }
    }


    /**
     * Crea los objetos Player y los almacena en un array de objetos para tenerlos controlados
     *
     * @param nPlayers  Es el numero de jugadores que se crean
     * @param nCards    Es el numero de cartas que cada jugador tiene en mano
     */
    private static void playerCraft(int nPlayers, Scanner teclado, int nCards) {
        players = new Player[nPlayers];
        int rng = randomNumber(nPlayers);

        for (int i = 0; i < nPlayers; i++) {
            System.out.print("Nombre jugador " + (i + 1) + ": ");
            String name = teclado.nextLine();

            //si no se ha introducido nombre se pone uno por defecto
            if (name.equals("")) {
                //constructor del jugador en case de que no indique nombre
                players[i] = new Player(nCards);
            } else {
                //Constructor del jugador cuando SI se indica nombre
                players[i] = new Player(name, nCards);
            }

            //Indica el turno en el que jugará cada jugador
            //los master estan exentos de jugar en su turno y se les saltará
            players[i].setTurn(i);
        }

        //Indica de manera aleatoria quien es el master por primera vez
        players[rng].setMaster();

        mostrarDatos();
    }

    /**
     * Muestra la informacion de los jugadores
     */
    private static void mostrarDatos() {
        for (int i = 0; i < players.length; i++) {
            System.out.println();
            System.out.println(players[i]);
            System.out.println();
        }
    }

    private static int randomNumber(int rango) {
        Random random = new Random();
        return random.nextInt(rango);
    }
}
