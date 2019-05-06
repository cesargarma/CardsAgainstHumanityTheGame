package com.example.cardsagainsthumanity;

import static com.example.cardsagainsthumanity.GameInit.players;

public class Game {

    public static void start(){
        int master = lookForMaster();

        System.out.println("\n\nEl master de esta ronda es: "+players[master].getName());
    }

    private static int lookForMaster(){
        for (int i = 0; i < players.length; i++){
            if(players[i].isMaster()) return i;

        }
        return -1;
    }
}
