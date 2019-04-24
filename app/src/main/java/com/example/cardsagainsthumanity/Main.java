package com.example.cardsagainsthumanity;

public class Main {
    public static void main(String[] args) {
        Player p1 = new Player();
        System.out.println(p1);
        System.out.println(p1.getTurn());

        Player p2 = new Player("César");
        System.out.println(p2);
        System.out.println(p2.getTurn());
    }
}
