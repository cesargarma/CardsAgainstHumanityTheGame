package com.example.cardsagainsthumanity;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        playerCraft(4,teclado);
    }

    public static void playerCraft(int nPlayers, Scanner teclado){
        Player [] players = new Player[nPlayers];
        for (int i = 0; i < nPlayers; i++) {
            System.out.println("Nombre jugador "+(i+1)+": ");
            String name = teclado.nextLine();
            if(name.equals("")){
               players[i] = new Player();
            }else{
                players[i] = new Player(name);
            }
            players[i].setTurn(i);

            System.out.println(players[i]);
        }
    }
}
