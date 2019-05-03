package com.example.cardsagainsthumanity;

import com.example.cardsagainsthumanity.Cards;

public class Player {

    private String name = "Default Name";
    private int turn = 0;
    private int nCards = 0;
    private boolean myTurn = false;
    private int score = 0;
    private boolean master = false;
    private String [] cards = new String[10];


    public Player (){ }
    //overload
    public Player(String name){
        this.name = name;
    }

    public Player(String name, int nCards){
        this.name = name;
        this.nCards = nCards;
        this.cards = new String[nCards];
    }

    public Player(int nCards){
        this.nCards = nCards;
        this.cards = new String[nCards];
    }

    //setters
    public void setTurn(int turn) {
        this.turn = turn;
        this.name = name + " " + this.turn;
    }

    public void setMaster(){
        this.master = true;
    }

    public void setCards(int pos){
        this.cards[pos] = Cards.getWhiteCard();
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

    public String getCards(int pos){
        return this.cards[pos];
    }

    @Override
    public String toString() {
        return "Name: "+name+"\nNumber of cards: "+nCards+"\nScore: "+score+"\nMaster: "+isMaster();
    }
}
