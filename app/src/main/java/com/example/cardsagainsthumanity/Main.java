package com.example.cardsagainsthumanity;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Player> playerList = new ArrayList<Player>();

        Player p1 = new Player();
        playerList.add(p1);
        p1.setTurn(playerList.size());
        System.out.println(p1);
        System.out.println(p1.getTurn());

        Player p2 = new Player("César");
        playerList.add(p2);
        p2.setTurn(playerList.size());
        System.out.println(p2);
        System.out.println(p2.getTurn());

        Player p3 = new Player();
        playerList.add(p3);
        p3.setTurn(playerList.size());
        System.out.println(p3);
        System.out.println(p3.getTurn());
    }
}
