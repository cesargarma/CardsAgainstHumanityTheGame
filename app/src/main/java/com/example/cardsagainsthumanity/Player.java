package com.example.cardsagainsthumanity;

import java.util.ArrayList;

public class Player {

    private String name = "Default Name";
    private int turn = 0;
    private int nCards = 0;
    private boolean myTurn = false;
    private int score = 0;
    private boolean master = false;

   ArrayList<Player> playerList = new ArrayList<Player>();

    public Player (){
        playerList.add(this);
        this.name = name + " " + this.turn;
        setInitialTurn();
    }
    //overload

    public Player(String name){
        this.name = name;
        setInitialTurn();
    }


    private void setInitialTurn(){
        this.turn = this.playerList.size();
    }

    //Getters
    public String getName() {
        return name;
    }

    public int getnCards() {
        return nCards;
    }

    public int getTurn () {
        return turn;
    }

    public boolean isMyTurn() {
        return myTurn;
    }

    public int getScore() {
        return score;
    }

    public boolean isMaster() {
        return master;
    }

    @Override
    public String toString() {
        return "Name: "+name+"\nNumber of cards: "+nCards+"\nScore: "+score;
    }
}
