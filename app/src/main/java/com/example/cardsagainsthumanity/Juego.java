package com.example.cardsagainsthumanity;

import java.util.Random;
import java.util.Scanner;

public class Juego {
    public static Player[] players = new Player[8];

    public static void iniciarjuego(){
        Scanner teclado = new Scanner(System.in);
        int nPlayers = 0;
        int nCards = 0;
        do{
            System.out.println("¿Cuántos jugadores van a jugar? \nMáximo de 8 jugadores, mínimo 3.");
            nPlayers = Integer.parseInt(teclado.nextLine());
        }while(nPlayers < 3 || nPlayers > 8);
        do{
            System.out.println("¿Cuántas cartas por jugador?");
            nCards = Integer.parseInt(teclado.nextLine());
        }while(nCards <= 0);
        playerCraft(nPlayers,teclado, nCards);
        repartirCartas(nCards);
    }

    private static void repartirCartas(int nCards) {

    }

    private static void playerCraft(int nPlayers, Scanner teclado, int nCards){
        players = new Player[nPlayers];
        int rng = randomNumber(nPlayers);
        for (int i = 0; i < nPlayers; i++) {
            System.out.print("Nombre jugador "+(i+1)+": ");
            String name = teclado.nextLine();
            if(name.equals("")){
                players[i] = new Player(nCards);
            }else{
                players[i] = new Player(name, nCards);
            }
            players[i].setTurn(i);
        }
        players[rng].setMaster();

        mostrarDatos();
    }

    private static void mostrarDatos(){
        for (int i = 0; i < players.length; i++){
            System.out.println();
            System.out.println(players[i]);
        }
    }

    private static int randomNumber(int rango){
        Random random = new Random();
        return random.nextInt(rango);
    }
}
