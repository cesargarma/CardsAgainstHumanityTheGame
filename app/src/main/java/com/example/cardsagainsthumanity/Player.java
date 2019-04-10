package com.example.cardsagainsthumanity;

public class Player {

    private String name = "Default Name";
    private int turn = 1;
    private int nCards = 0;
    private boolean myTurn = false;
    private int score = 0;
    private boolean master = false;

    public Player (){ }

    //overload
    public Player(String name){
        this.name = name;
    }

    //Getters
    public String getName() {
        return name;
    }

    public int getnCards() {
        return nCards;
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
        return "Name: "+name+" "+turn+"\nNumber of cards: "+nCards+"\nScore: "+score;
    }
}
