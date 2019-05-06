package com.example.cardsagainsthumanity;

import com.example.cardsagainsthumanity.Cards;

public class Player {

    //Nombre del jugador
    private String name = "Default Name";

    //Turno en el que juega el jugador
    private int turn = 0;

    //Número de cartas en mano
    private int nCards = 0;

    //Indica si es el turno del jugador,
    //Los master de cada turno, lo deben tener en FALSE todo ese turno
    private boolean myTurn = false;

    //Puntuacion de cada jugador, nº de rondas que ha ganado
    private int score = 0;

    //Indica si es el master de la ronda.
    private boolean master = false;

    //Valor de las cartas en mano del jugador
    private String[] cards = new String[10];

    private String blackCard = "";

    ///////////////
    //CONSTRUCTOR//
    ///////////////

    public Player() {
    }


    //overload
    public Player(String name) {
        this.name = name;
    }

    public Player(String name, int nCards) {
        this.name = name;
        this.nCards = nCards;
        this.cards = new String[nCards];
    }

    public Player(int nCards) {
        this.nCards = nCards;
        this.cards = new String[nCards];
    }

    ///////////
    //SETTERS//
    ///////////

    public void setTurn(int turn) {
        this.turn = turn;
        this.name = name + " " + this.turn;
    }

    public void setMaster() {
        this.master = true;
    }

    public void setMasterFalse(){
        this.master = false;
    }

    //Le das una posicion (indica la posicion de la carta en el array de cartas en mano
    //y solicita una nueva carta para esa posicion.
    public void setCards(int pos) {
        this.cards[pos] = Cards.getWhiteCard();
    }

    public void setBlackCards() {
        this.blackCard = Cards.getBlackCard();
    }

    public void setScore(){
        this.score++;
    }

    ///////////
    //GETTERS//
    ///////////

    public String getName() {
        return name;
    }

    public int getnCards() {
        return nCards;
    }

    public int getTurn() {
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

    public String getCards(int pos) {
        return this.cards[pos];
    }

    public String getBlackCard(){
        return this.blackCard;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nNumber of cards: " + nCards + "\nScore: " + score + "\nMaster: " + isMaster();
    }
}
