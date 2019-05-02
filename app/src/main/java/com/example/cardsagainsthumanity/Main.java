package com.example.cardsagainsthumanity;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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
    }

    public static void playerCraft(int nPlayers, Scanner teclado, int nCards){
        Player [] players = new Player[nPlayers];
        for (int i = 0; i < nPlayers; i++) {
            System.out.print("Nombre jugador "+(i+1)+": ");
            String name = teclado.nextLine();
            if(name.equals("")){
                players[i] = new Player(nCards);
            }else{
                players[i] = new Player(name, nCards);
            }
            players[i].setTurn(i);

            System.out.println(players[i]);
        }
    }
}
